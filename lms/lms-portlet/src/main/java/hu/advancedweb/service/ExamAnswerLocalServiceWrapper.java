package hu.advancedweb.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExamAnswerLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExamAnswerLocalService
 * @generated
 */
public class ExamAnswerLocalServiceWrapper implements ExamAnswerLocalService,
    ServiceWrapper<ExamAnswerLocalService> {
    private ExamAnswerLocalService _examAnswerLocalService;

    public ExamAnswerLocalServiceWrapper(
        ExamAnswerLocalService examAnswerLocalService) {
        _examAnswerLocalService = examAnswerLocalService;
    }

    /**
    * Adds the exam answer to the database. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @return the exam answer that was added
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamAnswer addExamAnswer(
        hu.advancedweb.model.ExamAnswer examAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.addExamAnswer(examAnswer);
    }

    /**
    * Creates a new exam answer with the primary key. Does not add the exam answer to the database.
    *
    * @param id the primary key for the new exam answer
    * @return the new exam answer
    */
    public hu.advancedweb.model.ExamAnswer createExamAnswer(long id) {
        return _examAnswerLocalService.createExamAnswer(id);
    }

    /**
    * Deletes the exam answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam answer
    * @throws PortalException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteExamAnswer(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _examAnswerLocalService.deleteExamAnswer(id);
    }

    /**
    * Deletes the exam answer from the database. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @throws SystemException if a system exception occurred
    */
    public void deleteExamAnswer(hu.advancedweb.model.ExamAnswer examAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        _examAnswerLocalService.deleteExamAnswer(examAnswer);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.dynamicQuery(dynamicQuery);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.dynamicQuery(dynamicQuery, start, end);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.dynamicQueryCount(dynamicQuery);
    }

    public hu.advancedweb.model.ExamAnswer fetchExamAnswer(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.fetchExamAnswer(id);
    }

    /**
    * Returns the exam answer with the primary key.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer
    * @throws PortalException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamAnswer getExamAnswer(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.getExamAnswer(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<hu.advancedweb.model.ExamAnswer> getExamAnswers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.getExamAnswers(start, end);
    }

    /**
    * Returns the number of exam answers.
    *
    * @return the number of exam answers
    * @throws SystemException if a system exception occurred
    */
    public int getExamAnswersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.getExamAnswersCount();
    }

    /**
    * Updates the exam answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @return the exam answer that was updated
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamAnswer updateExamAnswer(
        hu.advancedweb.model.ExamAnswer examAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.updateExamAnswer(examAnswer);
    }

    /**
    * Updates the exam answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param examAnswer the exam answer
    * @param merge whether to merge the exam answer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the exam answer that was updated
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamAnswer updateExamAnswer(
        hu.advancedweb.model.ExamAnswer examAnswer, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.updateExamAnswer(examAnswer, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _examAnswerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _examAnswerLocalService.setBeanIdentifier(beanIdentifier);
    }

    public hu.advancedweb.model.ExamAnswer createExamAnswer(long companyId,
        long groupId, long userId, java.lang.String answers,
        java.util.Date date, long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.createExamAnswer(companyId, groupId,
            userId, answers, date, examConfigId);
    }

    public hu.advancedweb.model.ExamAnswer getExamAnswer(long companyId,
        long groupId, long userId, long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.getExamAnswer(companyId, groupId,
            userId, examConfigId);
    }

    /**
    * Appends the user's answers to the already persisted object (if present, if not, then create it)
    */
    public void appendAnswers(long companyId, long groupId, long userId,
        long examConfigId, java.lang.String pageName,
        java.util.Map<java.lang.String, java.lang.String> newAnswers)
        throws com.liferay.portal.kernel.exception.SystemException {
        _examAnswerLocalService.appendAnswers(companyId, groupId, userId,
            examConfigId, pageName, newAnswers);
    }

    /**
    * Returns true if the user already answered the exams on the given page
    */
    public boolean isPageAnswered(long companyId, long groupId, long userId,
        long examConfigId, java.lang.String pageName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.isPageAnswered(companyId, groupId,
            userId, examConfigId, pageName);
    }

    /**
    * Returns the answers for the exam given by a user
    */
    public hu.advancedweb.lms.evaluation.ExamAnswers getExamAnswers(
        long companyId, long groupId, long userId, long examConfigId,
        java.lang.String pageName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.getExamAnswers(companyId, groupId,
            userId, examConfigId, pageName);
    }

    /**
    * Returns the evaluation for a given test and a user
    */
    public hu.advancedweb.lms.evaluation.ExamValidationResult evaluate(
        long companyId, long groupId, long userId, long examConfigId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.evaluate(companyId, groupId, userId,
            examConfigId);
    }

    public boolean hasConfigBeenAnswered(long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examAnswerLocalService.hasConfigBeenAnswered(examConfigId);
    }

    public void deleteAnswers(long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        _examAnswerLocalService.deleteAnswers(examConfigId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ExamAnswerLocalService getWrappedExamAnswerLocalService() {
        return _examAnswerLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedExamAnswerLocalService(
        ExamAnswerLocalService examAnswerLocalService) {
        _examAnswerLocalService = examAnswerLocalService;
    }

    public ExamAnswerLocalService getWrappedService() {
        return _examAnswerLocalService;
    }

    public void setWrappedService(ExamAnswerLocalService examAnswerLocalService) {
        _examAnswerLocalService = examAnswerLocalService;
    }
}
