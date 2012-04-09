package hu.advancedweb.lms.action;

import hu.advancedweb.lms.evaluation.DefaultExamEvaluatorLogic;
import hu.advancedweb.lms.evaluation.ExamEvaluator;
import hu.advancedweb.lms.evaluation.ExamTest;
import hu.advancedweb.lms.portlet.ConfigConstants;
import hu.advancedweb.model.ExamConfig;
import hu.advancedweb.service.ExamConfigLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String cmd = actionRequest.getParameter(Constants.CMD);
		
		if (cmd.equals(ConfigConstants.CMD_CHANGE_EXAM)) {
			// Modify selected Exam in portlet prefs.
			String newValue = actionRequest.getParameter(ConfigConstants.QP_EXAM_CONFIG_ID);
			preferences.setValue(ConfigConstants.PREFERENCE_EXAMID, newValue);
			
		} else if (cmd.equals(ConfigConstants.CMD_UPDATE)) {
			// Create or update Exam Config
			ExamTest examTest = new ExamTest();
			DefaultExamEvaluatorLogic examEvaluatorLogic = new DefaultExamEvaluatorLogic();
			String evaluatorScriptText = actionRequest.getParameter(ConfigConstants.QP_GENERATE_EVALUATOR_SCRIPT);
			String evaluatorLogicAutogenerate = actionRequest.getParameter(ConfigConstants.QP_GENERATE_EVALUATOR_LOGIC);
			
			fillExamTest(examTest, examEvaluatorLogic, actionRequest);
			
			Optional<String> evaluator = Optional.absent();
			Optional<DefaultExamEvaluatorLogic> evaluatorLogic = Optional.absent();
			
			if (evaluatorLogicAutogenerate.equalsIgnoreCase("true")) {
				evaluatorLogic = Optional.of(examEvaluatorLogic);
			} else {
				evaluator = Optional.of(evaluatorScriptText);
			}
			
			long examConfigId = GetterUtil.getLong(preferences.getValue(ConfigConstants.PREFERENCE_EXAMID, "-1"));
			
			if (examConfigId == -1L) {
				ExamConfig config = ExamEvaluator.createExamConfig(PortalUtil.getCompanyId(actionRequest), themeDisplay.getLayout().getGroupId(), examTest, evaluator, evaluatorLogic);
				String newValue = config.getId() + "";
				preferences.setValue(ConfigConstants.PREFERENCE_EXAMID, newValue);
			} else {
				ExamEvaluator.updateExamConfig(examConfigId, examTest, evaluator, evaluatorLogic);
			}
		} else {
			// unknown command
			System.out.println("Unknown command");
		}
		
		preferences.store();
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		// Portlet preferences
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		PortletPreferences preferences = null;
		if (renderRequest != null) {
			preferences = renderRequest.getPreferences();
		}
		String portletResource = ParamUtil.getString(request, "portletResource");
		if (Validator.isNotNull(portletResource)) {
			preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
		}
		
		// Render Command
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
		
		// Render Command Params
		String pageIndexParam = ParamUtil.getString(renderRequest, ConfigConstants.CP_PAGE_INDEX);
		if (pageIndexParam != null) {
			renderRequest.setAttribute(ConfigConstants.RA_PAGE_INDEX, pageIndexParam + "");
		}
		String questionIndexParam = ParamUtil.getString(renderRequest, ConfigConstants.CP_QUESTION_INDEX);
		if (questionIndexParam != null) {
			renderRequest.setAttribute(ConfigConstants.RA_QUESTION_INDEX, questionIndexParam + "");
		}
		
		if (cmd.equals(ConfigConstants.CMD_ADD_PAGE)) {
			// Render page fragment
			return "/edit_page.jsp";
		} else if (cmd.equals(ConfigConstants.CMD_ADD_QUESTION)) {
			// Render question fragment
			return "/edit_question.jsp";
		} else if (cmd.equals(ConfigConstants.CMD_ADD_ANSWER)) {
			// Render answer fragment
			return "/edit_answer.jsp";
		} else {
			// Render whole config page
			
			
			//  Selected Exam config
			long examConfigId = GetterUtil.getLong(preferences.getValue(ConfigConstants.PREFERENCE_EXAMID, "-1"));
			ExamConfig selectedExamConfig = null;
			boolean examConfigIdFound = false;
			
			//  Exam configs
			List<ExamConfig> examConfigs = ExamConfigLocalServiceUtil.getExamConfigs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			List<Long> examConfigIds = new ArrayList<Long>();
			for (ExamConfig examConfig : examConfigs) {
				if (examConfig.getId() == examConfigId) {
					examConfigIdFound = true;
					selectedExamConfig = examConfig;
				}
				examConfigIds.add(examConfig.getId());
			}
			Collections.sort(examConfigIds);
			
			renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_EXAM_CONFIGS, examConfigIds);
			
			if (examConfigIdFound) {
				renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_CONFIG, examConfigId);
				renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_TEST, new ExamTest(selectedExamConfig.getQuestions()));
				renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_JSP_EVALUATORSCRIPT, selectedExamConfig.getEvaluator());
			} else {
				renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_CONFIG, -1L);
			}
			
			return "/configuration.jsp";
		}
	}
	
	private void fillExamTest(ExamTest examTest, DefaultExamEvaluatorLogic examEvaluatorLogic, ActionRequest actionRequest) {
		String[] pageFieldIndexes = actionRequest.getParameter(ConfigConstants.QP_PAGE_FIELD_INDEXES).split(",");
		
		int targetPageNum = 1;
		for (String pageFieldIndex : pageFieldIndexes) {
			int pageNum = Integer.parseInt(pageFieldIndex);
			
			Map<String, List<String>> value = Maps.newLinkedHashMap();
			examTest.tests.put(targetPageNum + "", value);
			
			addPage(examTest, examEvaluatorLogic, actionRequest, pageNum, targetPageNum);
			targetPageNum ++;
		}
	}
	
	private void addPage(ExamTest examTest, DefaultExamEvaluatorLogic examEvaluatorLogic, ActionRequest actionRequest, int pageNum, int targetPageNum) {
		String[] questionFieldIndexes = actionRequest.getParameter(ConfigConstants.getQuestionFieldIndexName(pageNum)).split(",");
		
		int targetQuestionNum = 1;
		for (String questionFieldIndex : questionFieldIndexes) {
			int questionIndex = Integer.parseInt(questionFieldIndex);
			
			List<String> value = new ArrayList<String>();
			examTest.tests.get(targetPageNum + "").put(targetQuestionNum + "", value);
			
			addQuestion(examTest, examEvaluatorLogic, actionRequest, pageNum, questionIndex, targetPageNum, targetQuestionNum);
			targetQuestionNum ++;
		}
	}
	
	private void addQuestion(ExamTest examTest, DefaultExamEvaluatorLogic examEvaluatorLogic, ActionRequest actionRequest, int pageNum, int questionNum, int targetPageNum, int targetQuestionNum) {
		
		// question data
		String questionType = actionRequest.getParameter(ConfigConstants.getQuestionTypeName(pageNum, questionNum));
		String questionTitle = actionRequest.getParameter(ConfigConstants.getQuestionTitleName(pageNum, questionNum));
		
		List<String> questionData = examTest.tests.get(targetPageNum + "").get(targetQuestionNum + "");
		questionData.add(questionType);
		questionData.add(questionTitle);
		
		// answers
		StringBuffer keyBuffer = new StringBuffer();
		StringBuffer titleBuffer = new StringBuffer();
		
		String[] answerFieldIndexes = actionRequest.getParameter(ConfigConstants.getAnswerFieldIndexName(pageNum, questionNum)).split(",");
		for (String answerFieldIndex : answerFieldIndexes) {
			int answerIndex = Integer.parseInt(answerFieldIndex);
			
			String answerKey = actionRequest.getParameter(ConfigConstants.getAnswerKeyName(pageNum, questionNum, answerIndex));
			String answerTitle = actionRequest.getParameter(ConfigConstants.getAnswerTitleName(pageNum, questionNum, answerIndex));
			
			keyBuffer.append(",");
			keyBuffer.append(answerKey);
			
			titleBuffer.append(",");
			titleBuffer.append(answerTitle);
		}
		questionData.add(keyBuffer.toString().substring(1));
		questionData.add(titleBuffer.toString().substring(1));
		
		String questionScore = actionRequest.getParameter(ConfigConstants.getQuestionScoreName(pageNum, questionNum));
		String questionAnswer = actionRequest.getParameter(ConfigConstants.getQuestionAnswerName(pageNum, questionNum));
		
		int score = 0;
		try {
			score = Integer.parseInt(questionScore);
		} catch (Exception e) {
			// Do nothing.
		}
		
		examEvaluatorLogic.addCorrectAnswer(targetPageNum + "", targetQuestionNum + "", questionAnswer, score);
	}
}