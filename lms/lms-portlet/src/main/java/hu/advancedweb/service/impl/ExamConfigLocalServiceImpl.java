package hu.advancedweb.service.impl;

import hu.advancedweb.model.ExamConfig;
import hu.advancedweb.service.base.ExamConfigLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the exam config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link hu.advancedweb.service.ExamConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see hu.advancedweb.service.base.ExamConfigLocalServiceBaseImpl
 * @see hu.advancedweb.service.ExamConfigLocalServiceUtil
 */
public class ExamConfigLocalServiceImpl extends ExamConfigLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link hu.advancedweb.service.ExamConfigLocalServiceUtil} to access the exam config local service.
     */

	public ExamConfig createExamConfig(long companyId, long groupId, String questions, String evaluator) throws SystemException {
		ExamConfig result = createExamConfig(counterLocalService.increment());
		result.setCompanyId(companyId);
		result.setGroupId(groupId);
		result.setQuestions(questions);
		result.setEvaluator(evaluator);
		result = updateExamConfig(result);
		return result;

	}
}
