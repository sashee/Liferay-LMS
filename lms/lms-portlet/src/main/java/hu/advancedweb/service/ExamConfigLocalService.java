package hu.advancedweb.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the exam config local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamConfigLocalServiceUtil
 * @see hu.advancedweb.service.base.ExamConfigLocalServiceBaseImpl
 * @see hu.advancedweb.service.impl.ExamConfigLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface ExamConfigLocalService extends PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ExamConfigLocalServiceUtil} to access the exam config local service. Add custom service methods to {@link hu.advancedweb.service.impl.ExamConfigLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the exam config to the database. Also notifies the appropriate model listeners.
    *
    * @param examConfig the exam config
    * @return the exam config that was added
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig addExamConfig(
        hu.advancedweb.model.ExamConfig examConfig)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new exam config with the primary key. Does not add the exam config to the database.
    *
    * @param id the primary key for the new exam config
    * @return the new exam config
    */
    public hu.advancedweb.model.ExamConfig createExamConfig(long id);

    /**
    * Deletes the exam config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam config
    * @throws PortalException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteExamConfig(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the exam config from the database. Also notifies the appropriate model listeners.
    *
    * @param examConfig the exam config
    * @throws SystemException if a system exception occurred
    */
    public void deleteExamConfig(hu.advancedweb.model.ExamConfig examConfig)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

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
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public hu.advancedweb.model.ExamConfig fetchExamConfig(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the exam config with the primary key.
    *
    * @param id the primary key of the exam config
    * @return the exam config
    * @throws PortalException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public hu.advancedweb.model.ExamConfig getExamConfig(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<hu.advancedweb.model.ExamConfig> getExamConfigs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of exam configs.
    *
    * @return the number of exam configs
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getExamConfigsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the exam config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param examConfig the exam config
    * @return the exam config that was updated
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig updateExamConfig(
        hu.advancedweb.model.ExamConfig examConfig)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    public hu.advancedweb.model.ExamConfig createExamConfig(long companyId,
        long groupId, java.lang.String questions, java.lang.String evaluator)
        throws com.liferay.portal.kernel.exception.SystemException;

    public hu.advancedweb.model.ExamConfig createExamConfig(long companyId,
        long groupId, hu.advancedweb.lms.evaluation.ExamTest test,
        com.google.common.base.Optional<java.lang.String> evaluator,
        com.google.common.base.Optional<hu.advancedweb.lms.evaluation.DefaultExamEvaluatorLogic> evaluatorLogic)
        throws com.liferay.portal.kernel.exception.SystemException;

    public hu.advancedweb.model.ExamConfig updateExamConfig(long id,
        hu.advancedweb.lms.evaluation.ExamTest test,
        com.google.common.base.Optional<java.lang.String> evaluator,
        com.google.common.base.Optional<hu.advancedweb.lms.evaluation.DefaultExamEvaluatorLogic> evaluatorLogic)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
