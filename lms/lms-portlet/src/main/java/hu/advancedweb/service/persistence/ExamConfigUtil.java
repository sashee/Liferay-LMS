package hu.advancedweb.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.advancedweb.model.ExamConfig;

import java.util.List;

/**
 * The persistence utility for the exam config service. This utility wraps {@link ExamConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamConfigPersistence
 * @see ExamConfigPersistenceImpl
 * @generated
 */
public class ExamConfigUtil {
    private static ExamConfigPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(ExamConfig examConfig) {
        getPersistence().clearCache(examConfig);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<ExamConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ExamConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ExamConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ExamConfig update(ExamConfig examConfig, boolean merge)
        throws SystemException {
        return getPersistence().update(examConfig, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ExamConfig update(ExamConfig examConfig, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(examConfig, merge, serviceContext);
    }

    /**
    * Caches the exam config in the entity cache if it is enabled.
    *
    * @param examConfig the exam config
    */
    public static void cacheResult(hu.advancedweb.model.ExamConfig examConfig) {
        getPersistence().cacheResult(examConfig);
    }

    /**
    * Caches the exam configs in the entity cache if it is enabled.
    *
    * @param examConfigs the exam configs
    */
    public static void cacheResult(
        java.util.List<hu.advancedweb.model.ExamConfig> examConfigs) {
        getPersistence().cacheResult(examConfigs);
    }

    /**
    * Creates a new exam config with the primary key. Does not add the exam config to the database.
    *
    * @param id the primary key for the new exam config
    * @return the new exam config
    */
    public static hu.advancedweb.model.ExamConfig create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the exam config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam config
    * @return the exam config that was removed
    * @throws hu.advancedweb.NoSuchExamConfigException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamConfig remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamConfigException {
        return getPersistence().remove(id);
    }

    public static hu.advancedweb.model.ExamConfig updateImpl(
        hu.advancedweb.model.ExamConfig examConfig, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(examConfig, merge);
    }

    /**
    * Returns the exam config with the primary key or throws a {@link hu.advancedweb.NoSuchExamConfigException} if it could not be found.
    *
    * @param id the primary key of the exam config
    * @return the exam config
    * @throws hu.advancedweb.NoSuchExamConfigException if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamConfig findByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamConfigException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the exam config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the exam config
    * @return the exam config, or <code>null</code> if a exam config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamConfig fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the exam configs.
    *
    * @return the exam configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<hu.advancedweb.model.ExamConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<hu.advancedweb.model.ExamConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<hu.advancedweb.model.ExamConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the exam configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of exam configs.
    *
    * @return the number of exam configs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ExamConfigPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ExamConfigPersistence) PortletBeanLocatorUtil.locate(hu.advancedweb.service.ClpSerializer.getServletContextName(),
                    ExamConfigPersistence.class.getName());

            ReferenceRegistry.registerReference(ExamConfigUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(ExamConfigPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(ExamConfigUtil.class, "_persistence");
    }
}
