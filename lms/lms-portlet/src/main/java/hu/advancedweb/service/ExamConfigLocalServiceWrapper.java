package hu.advancedweb.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExamConfigLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExamConfigLocalService
 * @generated
 */
public class ExamConfigLocalServiceWrapper implements ExamConfigLocalService,
    ServiceWrapper<ExamConfigLocalService> {
    private ExamConfigLocalService _examConfigLocalService;

    public ExamConfigLocalServiceWrapper(
        ExamConfigLocalService examConfigLocalService) {
        _examConfigLocalService = examConfigLocalService;
    }

    /**
    * Adds the exam config to the database. Also notifies the appropriate model listeners.
    *
    * @param examConfig the exam config
    * @return the exam config that was added
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig addExamConfig(
        hu.advancedweb.model.ExamConfig examConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.addExamConfig(examConfig);
    }

    /**
    * Creates a new exam config with the primary key. Does not add the exam config to the database.
    *
    * @param id the primary key for the new exam config
    * @return the new exam config
    */
    public hu.advancedweb.model.ExamConfig createExamConfig(long id) {
        return _examConfigLocalService.createExamConfig(id);
    }

    /**
    * Deletes the exam config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam config
    * @throws PortalException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteExamConfig(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _examConfigLocalService.deleteExamConfig(id);
    }

    /**
    * Deletes the exam config from the database. Also notifies the appropriate model listeners.
    *
    * @param examConfig the exam config
    * @throws SystemException if a system exception occurred
    */
    public void deleteExamConfig(hu.advancedweb.model.ExamConfig examConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        _examConfigLocalService.deleteExamConfig(examConfig);
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
        return _examConfigLocalService.dynamicQuery(dynamicQuery);
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
        return _examConfigLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _examConfigLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _examConfigLocalService.dynamicQueryCount(dynamicQuery);
    }

    public hu.advancedweb.model.ExamConfig fetchExamConfig(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.fetchExamConfig(id);
    }

    /**
    * Returns the exam config with the primary key.
    *
    * @param id the primary key of the exam config
    * @return the exam config
    * @throws PortalException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig getExamConfig(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.getExamConfig(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the exam configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of exam configs
    * @param end the upper bound of the range of exam configs (not inclusive)
    * @return the range of exam configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<hu.advancedweb.model.ExamConfig> getExamConfigs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.getExamConfigs(start, end);
    }

    /**
    * Returns the number of exam configs.
    *
    * @return the number of exam configs
    * @throws SystemException if a system exception occurred
    */
    public int getExamConfigsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.getExamConfigsCount();
    }

    /**
    * Updates the exam config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param examConfig the exam config
    * @return the exam config that was updated
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig updateExamConfig(
        hu.advancedweb.model.ExamConfig examConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.updateExamConfig(examConfig);
    }

    /**
    * Updates the exam config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param examConfig the exam config
    * @param merge whether to merge the exam config with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the exam config that was updated
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig updateExamConfig(
        hu.advancedweb.model.ExamConfig examConfig, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.updateExamConfig(examConfig, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _examConfigLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _examConfigLocalService.setBeanIdentifier(beanIdentifier);
    }

    public hu.advancedweb.model.ExamConfig createExamConfig(long companyId,
        long groupId, java.lang.String questions, java.lang.String evaluator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.createExamConfig(companyId, groupId,
            questions, evaluator);
    }

    public hu.advancedweb.model.ExamConfig createExamConfig(long companyId,
        long groupId, hu.advancedweb.lms.evaluation.ExamTest test,
        com.google.common.base.Optional<java.lang.String> evaluator,
        com.google.common.base.Optional<hu.advancedweb.lms.evaluation.DefaultExamEvaluatorLogic> evaluatorLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.createExamConfig(companyId, groupId,
            test, evaluator, evaluatorLogic);
    }

    /**
    * Updates the config
    */
    public hu.advancedweb.model.ExamConfig updateExamConfig(long id,
        hu.advancedweb.lms.evaluation.ExamTest test,
        com.google.common.base.Optional<java.lang.String> evaluator,
        com.google.common.base.Optional<hu.advancedweb.lms.evaluation.DefaultExamEvaluatorLogic> evaluatorLogic)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _examConfigLocalService.updateExamConfig(id, test, evaluator,
            evaluatorLogic);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public ExamConfigLocalService getWrappedExamConfigLocalService() {
        return _examConfigLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedExamConfigLocalService(
        ExamConfigLocalService examConfigLocalService) {
        _examConfigLocalService = examConfigLocalService;
    }

    public ExamConfigLocalService getWrappedService() {
        return _examConfigLocalService;
    }

    public void setWrappedService(ExamConfigLocalService examConfigLocalService) {
        _examConfigLocalService = examConfigLocalService;
    }
}
