package hu.advancedweb.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import hu.advancedweb.NoSuchExamConfigException;

import hu.advancedweb.model.ExamConfig;
import hu.advancedweb.model.impl.ExamConfigImpl;
import hu.advancedweb.model.impl.ExamConfigModelImpl;

import hu.advancedweb.service.persistence.ExamAnswerPersistence;
import hu.advancedweb.service.persistence.ExamConfigPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the exam config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamConfigPersistence
 * @see ExamConfigUtil
 * @generated
 */
public class ExamConfigPersistenceImpl extends BasePersistenceImpl<ExamConfig>
    implements ExamConfigPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ExamConfigUtil} to access the exam config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ExamConfigImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
            ExamConfigModelImpl.FINDER_CACHE_ENABLED, ExamConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
            ExamConfigModelImpl.FINDER_CACHE_ENABLED, ExamConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
            ExamConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_EXAMCONFIG = "SELECT examConfig FROM ExamConfig examConfig";
    private static final String _SQL_COUNT_EXAMCONFIG = "SELECT COUNT(examConfig) FROM ExamConfig examConfig";
    private static final String _ORDER_BY_ENTITY_ALIAS = "examConfig.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExamConfig exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ExamConfigPersistenceImpl.class);
    private static ExamConfig _nullExamConfig = new ExamConfigImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ExamConfig> toCacheModel() {
                return _nullExamConfigCacheModel;
            }
        };

    private static CacheModel<ExamConfig> _nullExamConfigCacheModel = new CacheModel<ExamConfig>() {
            public ExamConfig toEntityModel() {
                return _nullExamConfig;
            }
        };

    @BeanReference(type = ExamAnswerPersistence.class)
    protected ExamAnswerPersistence examAnswerPersistence;
    @BeanReference(type = ExamConfigPersistence.class)
    protected ExamConfigPersistence examConfigPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the exam config in the entity cache if it is enabled.
     *
     * @param examConfig the exam config
     */
    public void cacheResult(ExamConfig examConfig) {
        EntityCacheUtil.putResult(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
            ExamConfigImpl.class, examConfig.getPrimaryKey(), examConfig);

        examConfig.resetOriginalValues();
    }

    /**
     * Caches the exam configs in the entity cache if it is enabled.
     *
     * @param examConfigs the exam configs
     */
    public void cacheResult(List<ExamConfig> examConfigs) {
        for (ExamConfig examConfig : examConfigs) {
            if (EntityCacheUtil.getResult(
                        ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
                        ExamConfigImpl.class, examConfig.getPrimaryKey()) == null) {
                cacheResult(examConfig);
            } else {
                examConfig.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all exam configs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ExamConfigImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ExamConfigImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the exam config.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ExamConfig examConfig) {
        EntityCacheUtil.removeResult(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
            ExamConfigImpl.class, examConfig.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ExamConfig> examConfigs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ExamConfig examConfig : examConfigs) {
            EntityCacheUtil.removeResult(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
                ExamConfigImpl.class, examConfig.getPrimaryKey());
        }
    }

    /**
     * Creates a new exam config with the primary key. Does not add the exam config to the database.
     *
     * @param id the primary key for the new exam config
     * @return the new exam config
     */
    public ExamConfig create(long id) {
        ExamConfig examConfig = new ExamConfigImpl();

        examConfig.setNew(true);
        examConfig.setPrimaryKey(id);

        return examConfig;
    }

    /**
     * Removes the exam config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the exam config
     * @return the exam config that was removed
     * @throws hu.advancedweb.NoSuchExamConfigException if a exam config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamConfig remove(long id)
        throws NoSuchExamConfigException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the exam config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the exam config
     * @return the exam config that was removed
     * @throws hu.advancedweb.NoSuchExamConfigException if a exam config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExamConfig remove(Serializable primaryKey)
        throws NoSuchExamConfigException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ExamConfig examConfig = (ExamConfig) session.get(ExamConfigImpl.class,
                    primaryKey);

            if (examConfig == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchExamConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(examConfig);
        } catch (NoSuchExamConfigException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ExamConfig removeImpl(ExamConfig examConfig)
        throws SystemException {
        examConfig = toUnwrappedModel(examConfig);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, examConfig);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(examConfig);

        return examConfig;
    }

    @Override
    public ExamConfig updateImpl(hu.advancedweb.model.ExamConfig examConfig,
        boolean merge) throws SystemException {
        examConfig = toUnwrappedModel(examConfig);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, examConfig, merge);

            examConfig.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        EntityCacheUtil.putResult(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
            ExamConfigImpl.class, examConfig.getPrimaryKey(), examConfig);

        return examConfig;
    }

    protected ExamConfig toUnwrappedModel(ExamConfig examConfig) {
        if (examConfig instanceof ExamConfigImpl) {
            return examConfig;
        }

        ExamConfigImpl examConfigImpl = new ExamConfigImpl();

        examConfigImpl.setNew(examConfig.isNew());
        examConfigImpl.setPrimaryKey(examConfig.getPrimaryKey());

        examConfigImpl.setId(examConfig.getId());
        examConfigImpl.setGroupId(examConfig.getGroupId());
        examConfigImpl.setCompanyId(examConfig.getCompanyId());
        examConfigImpl.setQuestions(examConfig.getQuestions());
        examConfigImpl.setEvaluator(examConfig.getEvaluator());

        return examConfigImpl;
    }

    /**
     * Returns the exam config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the exam config
     * @return the exam config
     * @throws com.liferay.portal.NoSuchModelException if a exam config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExamConfig findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the exam config with the primary key or throws a {@link hu.advancedweb.NoSuchExamConfigException} if it could not be found.
     *
     * @param id the primary key of the exam config
     * @return the exam config
     * @throws hu.advancedweb.NoSuchExamConfigException if a exam config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamConfig findByPrimaryKey(long id)
        throws NoSuchExamConfigException, SystemException {
        ExamConfig examConfig = fetchByPrimaryKey(id);

        if (examConfig == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchExamConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return examConfig;
    }

    /**
     * Returns the exam config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the exam config
     * @return the exam config, or <code>null</code> if a exam config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExamConfig fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the exam config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the exam config
     * @return the exam config, or <code>null</code> if a exam config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamConfig fetchByPrimaryKey(long id) throws SystemException {
        ExamConfig examConfig = (ExamConfig) EntityCacheUtil.getResult(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
                ExamConfigImpl.class, id);

        if (examConfig == _nullExamConfig) {
            return null;
        }

        if (examConfig == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                examConfig = (ExamConfig) session.get(ExamConfigImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (examConfig != null) {
                    cacheResult(examConfig);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ExamConfigModelImpl.ENTITY_CACHE_ENABLED,
                        ExamConfigImpl.class, id, _nullExamConfig);
                }

                closeSession(session);
            }
        }

        return examConfig;
    }

    /**
     * Returns all the exam configs.
     *
     * @return the exam configs
     * @throws SystemException if a system exception occurred
     */
    public List<ExamConfig> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<ExamConfig> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<ExamConfig> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<ExamConfig> list = (List<ExamConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EXAMCONFIG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EXAMCONFIG;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ExamConfig>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ExamConfig>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the exam configs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ExamConfig examConfig : findAll()) {
            remove(examConfig);
        }
    }

    /**
     * Returns the number of exam configs.
     *
     * @return the number of exam configs
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_EXAMCONFIG);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the exam config persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.hu.advancedweb.model.ExamConfig")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ExamConfig>> listenersList = new ArrayList<ModelListener<ExamConfig>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ExamConfig>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ExamConfigImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
