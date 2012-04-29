package hu.advancedweb.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the exam answer local service. This utility wraps {@link hu.advancedweb.service.impl.ExamAnswerLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamAnswerLocalService
 * @see hu.advancedweb.service.base.ExamAnswerLocalServiceBaseImpl
 * @see hu.advancedweb.service.impl.ExamAnswerLocalServiceImpl
 * @generated
 */
public class ExamAnswerLocalServiceUtil {
    private static ExamAnswerLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link hu.advancedweb.service.impl.ExamAnswerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the exam answer to the database. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @return the exam answer that was added
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamAnswer addExamAnswer(
        hu.advancedweb.model.ExamAnswer examAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addExamAnswer(examAnswer);
    }

    /**
    * Creates a new exam answer with the primary key. Does not add the exam answer to the database.
    *
    * @param id the primary key for the new exam answer
    * @return the new exam answer
    */
    public static hu.advancedweb.model.ExamAnswer createExamAnswer(long id) {
        return getService().createExamAnswer(id);
    }

    /**
    * Deletes the exam answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam answer
    * @throws PortalException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteExamAnswer(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteExamAnswer(id);
    }

    /**
    * Deletes the exam answer from the database. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @throws SystemException if a system exception occurred
    */
    public static void deleteExamAnswer(
        hu.advancedweb.model.ExamAnswer examAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteExamAnswer(examAnswer);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static hu.advancedweb.model.ExamAnswer fetchExamAnswer(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchExamAnswer(id);
    }

    /**
    * Returns the exam answer with the primary key.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer
    * @throws PortalException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamAnswer getExamAnswer(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getExamAnswer(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the exam answers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of exam answers
    * @param end the upper bound of the range of exam answers (not inclusive)
    * @return the range of exam answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<hu.advancedweb.model.ExamAnswer> getExamAnswers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getExamAnswers(start, end);
    }

    /**
    * Returns the number of exam answers.
    *
    * @return the number of exam answers
    * @throws SystemException if a system exception occurred
    */
    public static int getExamAnswersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getExamAnswersCount();
    }

    /**
    * Updates the exam answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @return the exam answer that was updated
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamAnswer updateExamAnswer(
        hu.advancedweb.model.ExamAnswer examAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateExamAnswer(examAnswer);
    }

    /**
    * Updates the exam answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @param merge whether to merge the exam answer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the exam answer that was updated
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamAnswer updateExamAnswer(
        hu.advancedweb.model.ExamAnswer examAnswer, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateExamAnswer(examAnswer, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static hu.advancedweb.model.ExamAnswer createExamAnswer(
        long companyId, long groupId, long userId, java.lang.String answers,
        java.util.Date date, long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .createExamAnswer(companyId, groupId, userId, answers, date,
            examConfigId);
    }

    public static hu.advancedweb.model.ExamAnswer getExamAnswer(
        long companyId, long groupId, long userId, long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getExamAnswer(companyId, groupId, userId, examConfigId);
    }

    /**
    * Appends the user's answers to the already persisted object (if present, if not, then create it)
    */
    public static void appendAnswers(long companyId, long groupId, long userId,
        long examConfigId, java.lang.String pageName,
        java.util.Map<java.lang.String, java.lang.String> newAnswers)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService()
            .appendAnswers(companyId, groupId, userId, examConfigId, pageName,
            newAnswers);
    }

    /**
    * Returns true if the user already answered the exams on the given page
    */
    public static boolean isPageAnswered(long companyId, long groupId,
        long userId, long examConfigId, java.lang.String pageName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .isPageAnswered(companyId, groupId, userId, examConfigId,
            pageName);
    }

    /**
    * Returns the answers for the exam given by a user
    */
    public static hu.advancedweb.lms.evaluation.ExamAnswers getExamAnswers(
        long companyId, long groupId, long userId, long examConfigId,
        java.lang.String pageName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getExamAnswers(companyId, groupId, userId, examConfigId,
            pageName);
    }

    /**
    * Returns the evaluation for a given test and a user
    */
    public static hu.advancedweb.lms.evaluation.ExamValidationResult evaluate(
        long companyId, long groupId, long userId, long examConfigId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().evaluate(companyId, groupId, userId, examConfigId);
    }

    public static boolean hasConfigBeenAnswered(long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasConfigBeenAnswered(examConfigId);
    }

    public static void deleteAnswers(long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAnswers(examConfigId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ExamAnswerLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ExamAnswerLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    ExamAnswerLocalService.class.getName(), portletClassLoader);

            _service = new ExamAnswerLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(ExamAnswerLocalServiceUtil.class,
                "_service");
            MethodCache.remove(ExamAnswerLocalService.class);
        }

        return _service;
    }

    public void setService(ExamAnswerLocalService service) {
        MethodCache.remove(ExamAnswerLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(ExamAnswerLocalServiceUtil.class,
            "_service");
        MethodCache.remove(ExamAnswerLocalService.class);
    }
}
