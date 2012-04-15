package hu.advancedweb.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import hu.advancedweb.model.ExamConfig;

/**
 * The persistence interface for the exam config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamConfigPersistenceImpl
 * @see ExamConfigUtil
 * @generated
 */
public interface ExamConfigPersistence extends BasePersistence<ExamConfig> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ExamConfigUtil} to access the exam config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the exam config in the entity cache if it is enabled.
    *
    * @param examConfig the exam config
    */
    public void cacheResult(hu.advancedweb.model.ExamConfig examConfig);

    /**
    * Caches the exam configs in the entity cache if it is enabled.
    *
    * @param examConfigs the exam configs
    */
    public void cacheResult(
        java.util.List<hu.advancedweb.model.ExamConfig> examConfigs);

    /**
    * Creates a new exam config with the primary key. Does not add the exam config to the database.
    *
    * @param id the primary key for the new exam config
    * @return the new exam config
    */
    public hu.advancedweb.model.ExamConfig create(long id);

    /**
    * Removes the exam config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam config
    * @return the exam config that was removed
    * @throws hu.advancedweb.NoSuchExamConfigException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamConfigException;

    public hu.advancedweb.model.ExamConfig updateImpl(
        hu.advancedweb.model.ExamConfig examConfig, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the exam config with the primary key or throws a {@link hu.advancedweb.NoSuchExamConfigException} if it could not be found.
    *
    * @param id the primary key of the exam config
    * @return the exam config
    * @throws hu.advancedweb.NoSuchExamConfigException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig findByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamConfigException;

    /**
    * Returns the exam config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the exam config
    * @return the exam config, or <code>null</code> if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamConfig fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the exam configs.
    *
    * @return the exam configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<hu.advancedweb.model.ExamConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<hu.advancedweb.model.ExamConfig> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the exam configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of exam configs
    * @param end the upper bound of the range of exam configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of exam configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<hu.advancedweb.model.ExamConfig> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the exam configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of exam configs.
    *
    * @return the number of exam configs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
