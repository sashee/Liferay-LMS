package hu.advancedweb.service.impl;

import hu.advancedweb.lms.evaluation.DefaultExamEvaluator;
import hu.advancedweb.lms.evaluation.DefaultExamEvaluatorLogic;
import hu.advancedweb.lms.evaluation.ExamAnswers;
import hu.advancedweb.lms.evaluation.ExamValidationResult;
import hu.advancedweb.model.ExamAnswer;
import hu.advancedweb.model.ExamConfig;
import hu.advancedweb.pilot.rhino.ValidationBean;
import hu.advancedweb.service.ExamAnswerLocalServiceUtil;
import hu.advancedweb.service.ExamConfigLocalServiceUtil;
import hu.advancedweb.service.base.ExamAnswerLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the exam answer local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * {@link hu.advancedweb.service.ExamAnswerLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the
 * same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see hu.advancedweb.service.base.ExamAnswerLocalServiceBaseImpl
 * @see hu.advancedweb.service.ExamAnswerLocalServiceUtil
 */
public class ExamAnswerLocalServiceImpl extends ExamAnswerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link hu.advancedweb.service.ExamAnswerLocalServiceUtil} to access the exam answer local service.
	 */

	public ExamAnswer createExamAnswer(long companyId, long groupId, long userId, String answers, Date date, long examConfigId) throws SystemException {
		List<ExamAnswer> list = getExamAnswerPersistence().findByCompanyId_GroupId_UserId_ExamConfigId(companyId, groupId, userId, examConfigId);

		Preconditions.checkArgument(list.isEmpty());

		ExamAnswer result = createExamAnswer(counterLocalService.increment());
		result.setCompanyId(companyId);
		result.setGroupId(groupId);
		result.setUserId(userId);
		result.setAnswers(answers);
		result.setDate(date);
		result.setExamConfigId(examConfigId);
		result.resetOriginalValues();
		result = updateExamAnswer(result);
		return result;

	}

	public ExamAnswer getExamAnswer(long companyId, long groupId, long userId, long examConfigId) throws SystemException {
		return Iterables.getFirst(getExamAnswerPersistence().findByCompanyId_GroupId_UserId_ExamConfigId(companyId, groupId, userId, examConfigId), null);
	}

	private String appendAnswers(String oldAnswers, String pageName, Map<String, String> newAnswers) {
		if (oldAnswers == null || oldAnswers.trim().compareTo("") == 0) {
			oldAnswers = "{}";
		}
		ExamAnswers ans = new ExamAnswers(oldAnswers);
		ans.answers.put(pageName, Maps.newHashMap(newAnswers));
		return JSONObject.toJSONString(ans.answers);
	}

	/** Appends the user's answers to the already persisted object (if present, if not, then create it) */
	public void appendAnswers(long companyId, long groupId, long userId, long examConfigId, String pageName, Map<String, String> newAnswers) throws SystemException {
		try {
			ExamAnswer answer = getExamAnswer(companyId, groupId, userId, examConfigId);
			if (answer == null) {
				createExamAnswer(companyId, groupId, userId, appendAnswers("", pageName, newAnswers), new Date(), examConfigId);
			} else {
				answer.setAnswers(appendAnswers(answer.getAnswers(), pageName, newAnswers));
				updateExamAnswer(answer);
			}
		} finally {
			examAnswerPersistence.clearCache();// TODO:workaround
		}
	}

	/** Returns true if the user already answered the exams on the given page */
	public boolean isPageAnswered(long companyId, long groupId, long userId, long examConfigId, String pageName) throws SystemException {
		ExamAnswer answer = ExamAnswerLocalServiceUtil.getExamAnswer(companyId, groupId, userId, examConfigId);
		if (answer == null) {
			return false;
		}

		return new ExamAnswers(answer.getAnswers()).answers.containsKey(pageName);
	}

	/** Returns the answers for the exam given by a user */
	public ExamAnswers getExamAnswers(long companyId, long groupId, long userId, long examConfigId, String pageName) throws SystemException {
		ExamAnswer answer = ExamAnswerLocalServiceUtil.getExamAnswer(companyId, groupId, userId, examConfigId);
		if (answer == null) {
			return null;
		}

		return new ExamAnswers(answer.getAnswers());
	}

	/** Returns the evaluation for a given test and a user */
	public ExamValidationResult evaluate(long companyId, long groupId, long userId, long examConfigId) throws PortalException, SystemException {
		ExamConfig config = ExamConfigLocalServiceUtil.getExamConfig(examConfigId);

		ExamAnswer answer = ExamAnswerLocalServiceUtil.getExamAnswer(companyId, groupId, userId, examConfigId);

		return evaluate(answer.getAnswers(), config.getEvaluator());
	}

	private ExamValidationResult evaluate(String answers, String evaluationLogic) {
		Context cx = Context.enter();

		try {
			Scriptable scope = cx.initStandardObjects();

			/*
			 * Loads the helper js functions to the scope.
			 */
			// Script javascriptFrameworkScript = Context.getCurrentContext().compileString(getJavascriptFramework(), "Framework Script", 1, null);
			// javascriptFrameworkScript.exec(cx, scope);

			/*
			 * Loads the exam data object to the scope.
			 */
			Scriptable examData = cx.getWrapFactory().wrapAsJavaObject(cx, scope, new ExamAnswers(answers), ExamAnswers.class);
			scope.put("examAnswers", scope, examData);

			/*
			 * Loads the validations js function to the scope.
			 */
			Script validationScript = Context.getCurrentContext().compileString(evaluationLogic, "Validation Script", 1, null);
			validationScript.exec(cx, scope);

			/* Loads the default evaluator */
			Scriptable defaultEvaluator = cx.getWrapFactory().wrapAsJavaObject(cx, scope, new DefaultExamEvaluator(), DefaultExamEvaluator.class);
			scope.put("defaultEvaluator", scope, defaultEvaluator);

			Scriptable defaultEvaluatorLogic = cx.getWrapFactory().wrapAsJavaObject(cx, scope, new DefaultExamEvaluatorLogic(), DefaultExamEvaluatorLogic.class);
			scope.put("defaultEvaluatorLogic", scope, defaultEvaluatorLogic);

			/*
			 * Loads the validation data object to the scope.
			 */

			ExamValidationResult validationBean = new ExamValidationResult();
			Scriptable validationData = cx.getWrapFactory().wrapAsJavaObject(cx, scope, validationBean, ValidationBean.class);
			scope.put("validationDataObj", scope, validationData);

			/*
			 * Validate.
			 */
			cx.evaluateString(scope, "validate();", "Main Script", 1, null);

			return validationBean;

			/*
			 * Do something with the filled validation bean.
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Context.exit();
		}

		return null;
	}

	public boolean hasConfigBeenAnswered(long examConfigId) throws SystemException {
		return examAnswerPersistence.findByExamConfigId(examConfigId).isEmpty() == false;
	}

	public void deleteAnswers(long examConfigId) throws SystemException {
		try {
			examAnswerPersistence.removeByExamConfigId(examConfigId);
		} finally {
			examAnswerPersistence.clearCache();// TODO:workaround
		}
	}
}
