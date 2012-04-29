package hu.advancedweb.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import hu.advancedweb.NoSuchExamAnswerException;

import hu.advancedweb.model.ExamAnswer;
import hu.advancedweb.model.impl.ExamAnswerImpl;
import hu.advancedweb.model.impl.ExamAnswerModelImpl;

import hu.advancedweb.service.persistence.ExamAnswerPersistence;
import hu.advancedweb.service.persistence.ExamConfigPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the exam answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamAnswerPersistence
 * @see ExamAnswerUtil
 * @generated
 */
public class ExamAnswerPersistenceImpl extends BasePersistenceImpl<ExamAnswer>
    implements ExamAnswerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ExamAnswerUtil} to access the exam answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ExamAnswerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID =
        new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, ExamAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyId_GroupId_UserId_ExamConfigId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID =
        new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, ExamAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyId_GroupId_UserId_ExamConfigId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                Long.class.getName()
            },
            ExamAnswerModelImpl.COMPANYID_COLUMN_BITMASK |
            ExamAnswerModelImpl.GROUPID_COLUMN_BITMASK |
            ExamAnswerModelImpl.USERID_COLUMN_BITMASK |
            ExamAnswerModelImpl.EXAMCONFIGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID =
        new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyId_GroupId_UserId_ExamConfigId",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                Long.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMCONFIGID =
        new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, ExamAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExamConfigId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMCONFIGID =
        new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, ExamAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExamConfigId",
            new String[] { Long.class.getName() },
            ExamAnswerModelImpl.EXAMCONFIGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EXAMCONFIGID = new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExamConfigId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, ExamAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, ExamAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_EXAMANSWER = "SELECT examAnswer FROM ExamAnswer examAnswer";
    private static final String _SQL_SELECT_EXAMANSWER_WHERE = "SELECT examAnswer FROM ExamAnswer examAnswer WHERE ";
    private static final String _SQL_COUNT_EXAMANSWER = "SELECT COUNT(examAnswer) FROM ExamAnswer examAnswer";
    private static final String _SQL_COUNT_EXAMANSWER_WHERE = "SELECT COUNT(examAnswer) FROM ExamAnswer examAnswer WHERE ";
    private static final String _FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_COMPANYID_2 =
        "examAnswer.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_GROUPID_2 =
        "examAnswer.groupId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_USERID_2 =
        "examAnswer.userId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_EXAMCONFIGID_2 =
        "examAnswer.examConfigId = ?";
    private static final String _FINDER_COLUMN_EXAMCONFIGID_EXAMCONFIGID_2 = "examAnswer.examConfigId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "examAnswer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExamAnswer exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExamAnswer exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ExamAnswerPersistenceImpl.class);
    private static ExamAnswer _nullExamAnswer = new ExamAnswerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ExamAnswer> toCacheModel() {
                return _nullExamAnswerCacheModel;
            }
        };

    private static CacheModel<ExamAnswer> _nullExamAnswerCacheModel = new CacheModel<ExamAnswer>() {
            public ExamAnswer toEntityModel() {
                return _nullExamAnswer;
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
     * Caches the exam answer in the entity cache if it is enabled.
     *
     * @param examAnswer the exam answer
     */
    public void cacheResult(ExamAnswer examAnswer) {
        EntityCacheUtil.putResult(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerImpl.class, examAnswer.getPrimaryKey(), examAnswer);

        examAnswer.resetOriginalValues();
    }

    /**
     * Caches the exam answers in the entity cache if it is enabled.
     *
     * @param examAnswers the exam answers
     */
    public void cacheResult(List<ExamAnswer> examAnswers) {
        for (ExamAnswer examAnswer : examAnswers) {
            if (EntityCacheUtil.getResult(
                        ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
                        ExamAnswerImpl.class, examAnswer.getPrimaryKey()) == null) {
                cacheResult(examAnswer);
            } else {
                examAnswer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all exam answers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ExamAnswerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ExamAnswerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the exam answer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ExamAnswer examAnswer) {
        EntityCacheUtil.removeResult(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerImpl.class, examAnswer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ExamAnswer> examAnswers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ExamAnswer examAnswer : examAnswers) {
            EntityCacheUtil.removeResult(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
                ExamAnswerImpl.class, examAnswer.getPrimaryKey());
        }
    }

    /**
     * Creates a new exam answer with the primary key. Does not add the exam answer to the database.
     *
     * @param id the primary key for the new exam answer
     * @return the new exam answer
     */
    public ExamAnswer create(long id) {
        ExamAnswer examAnswer = new ExamAnswerImpl();

        examAnswer.setNew(true);
        examAnswer.setPrimaryKey(id);

        return examAnswer;
    }

    /**
     * Removes the exam answer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the exam answer
     * @return the exam answer that was removed
     * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer remove(long id)
        throws NoSuchExamAnswerException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the exam answer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the exam answer
     * @return the exam answer that was removed
     * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExamAnswer remove(Serializable primaryKey)
        throws NoSuchExamAnswerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ExamAnswer examAnswer = (ExamAnswer) session.get(ExamAnswerImpl.class,
                    primaryKey);

            if (examAnswer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchExamAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(examAnswer);
        } catch (NoSuchExamAnswerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ExamAnswer removeImpl(ExamAnswer examAnswer)
        throws SystemException {
        examAnswer = toUnwrappedModel(examAnswer);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, examAnswer);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(examAnswer);

        return examAnswer;
    }

    @Override
    public ExamAnswer updateImpl(hu.advancedweb.model.ExamAnswer examAnswer,
        boolean merge) throws SystemException {
        examAnswer = toUnwrappedModel(examAnswer);

        boolean isNew = examAnswer.isNew();

        ExamAnswerModelImpl examAnswerModelImpl = (ExamAnswerModelImpl) examAnswer;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, examAnswer, merge);

            examAnswer.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ExamAnswerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((examAnswerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(examAnswerModelImpl.getOriginalCompanyId()),
                        Long.valueOf(examAnswerModelImpl.getOriginalGroupId()),
                        Long.valueOf(examAnswerModelImpl.getOriginalUserId()),
                        Long.valueOf(examAnswerModelImpl.getOriginalExamConfigId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID,
                    args);

                args = new Object[] {
                        Long.valueOf(examAnswerModelImpl.getCompanyId()),
                        Long.valueOf(examAnswerModelImpl.getGroupId()),
                        Long.valueOf(examAnswerModelImpl.getUserId()),
                        Long.valueOf(examAnswerModelImpl.getExamConfigId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID,
                    args);
            }

            if ((examAnswerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMCONFIGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(examAnswerModelImpl.getOriginalExamConfigId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXAMCONFIGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMCONFIGID,
                    args);

                args = new Object[] {
                        Long.valueOf(examAnswerModelImpl.getExamConfigId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXAMCONFIGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMCONFIGID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
            ExamAnswerImpl.class, examAnswer.getPrimaryKey(), examAnswer);

        return examAnswer;
    }

    protected ExamAnswer toUnwrappedModel(ExamAnswer examAnswer) {
        if (examAnswer instanceof ExamAnswerImpl) {
            return examAnswer;
        }

        ExamAnswerImpl examAnswerImpl = new ExamAnswerImpl();

        examAnswerImpl.setNew(examAnswer.isNew());
        examAnswerImpl.setPrimaryKey(examAnswer.getPrimaryKey());

        examAnswerImpl.setId(examAnswer.getId());
        examAnswerImpl.setGroupId(examAnswer.getGroupId());
        examAnswerImpl.setCompanyId(examAnswer.getCompanyId());
        examAnswerImpl.setUserId(examAnswer.getUserId());
        examAnswerImpl.setAnswers(examAnswer.getAnswers());
        examAnswerImpl.setDate(examAnswer.getDate());
        examAnswerImpl.setExamConfigId(examAnswer.getExamConfigId());

        return examAnswerImpl;
    }

    /**
     * Returns the exam answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the exam answer
     * @return the exam answer
     * @throws com.liferay.portal.NoSuchModelException if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExamAnswer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the exam answer with the primary key or throws a {@link hu.advancedweb.NoSuchExamAnswerException} if it could not be found.
     *
     * @param id the primary key of the exam answer
     * @return the exam answer
     * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer findByPrimaryKey(long id)
        throws NoSuchExamAnswerException, SystemException {
        ExamAnswer examAnswer = fetchByPrimaryKey(id);

        if (examAnswer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchExamAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return examAnswer;
    }

    /**
     * Returns the exam answer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the exam answer
     * @return the exam answer, or <code>null</code> if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExamAnswer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the exam answer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the exam answer
     * @return the exam answer, or <code>null</code> if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer fetchByPrimaryKey(long id) throws SystemException {
        ExamAnswer examAnswer = (ExamAnswer) EntityCacheUtil.getResult(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
                ExamAnswerImpl.class, id);

        if (examAnswer == _nullExamAnswer) {
            return null;
        }

        if (examAnswer == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                examAnswer = (ExamAnswer) session.get(ExamAnswerImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (examAnswer != null) {
                    cacheResult(examAnswer);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ExamAnswerModelImpl.ENTITY_CACHE_ENABLED,
                        ExamAnswerImpl.class, id, _nullExamAnswer);
                }

                closeSession(session);
            }
        }

        return examAnswer;
    }

    /**
     * Returns all the exam answers where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @return the matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, Long userId, Long examConfigId)
        throws SystemException {
        return findByCompanyId_GroupId_UserId_ExamConfigId(companyId, groupId,
            userId, examConfigId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the exam answers where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @param start the lower bound of the range of exam answers
     * @param end the upper bound of the range of exam answers (not inclusive)
     * @return the range of matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, Long userId, Long examConfigId,
        int start, int end) throws SystemException {
        return findByCompanyId_GroupId_UserId_ExamConfigId(companyId, groupId,
            userId, examConfigId, start, end, null);
    }

    /**
     * Returns an ordered range of all the exam answers where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @param start the lower bound of the range of exam answers
     * @param end the upper bound of the range of exam answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, Long userId, Long examConfigId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID;
            finderArgs = new Object[] { companyId, groupId, userId, examConfigId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID;
            finderArgs = new Object[] {
                    companyId, groupId, userId, examConfigId,
                    
                    start, end, orderByComparator
                };
        }

        List<ExamAnswer> list = (List<ExamAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(6 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_EXAMANSWER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_GROUPID_2);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_USERID_2);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_EXAMCONFIGID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                qPos.add(userId.longValue());

                qPos.add(examConfigId.longValue());

                list = (List<ExamAnswer>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first exam answer in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching exam answer
     * @throws hu.advancedweb.NoSuchExamAnswerException if a matching exam answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer findByCompanyId_GroupId_UserId_ExamConfigId_First(
        long companyId, long groupId, Long userId, Long examConfigId,
        OrderByComparator orderByComparator)
        throws NoSuchExamAnswerException, SystemException {
        List<ExamAnswer> list = findByCompanyId_GroupId_UserId_ExamConfigId(companyId,
                groupId, userId, examConfigId, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(10);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(", userId=");
            msg.append(userId);

            msg.append(", examConfigId=");
            msg.append(examConfigId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchExamAnswerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Returns the last exam answer in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching exam answer
     * @throws hu.advancedweb.NoSuchExamAnswerException if a matching exam answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer findByCompanyId_GroupId_UserId_ExamConfigId_Last(
        long companyId, long groupId, Long userId, Long examConfigId,
        OrderByComparator orderByComparator)
        throws NoSuchExamAnswerException, SystemException {
        int count = countByCompanyId_GroupId_UserId_ExamConfigId(companyId,
                groupId, userId, examConfigId);

        List<ExamAnswer> list = findByCompanyId_GroupId_UserId_ExamConfigId(companyId,
                groupId, userId, examConfigId, count - 1, count,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(10);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(", userId=");
            msg.append(userId);

            msg.append(", examConfigId=");
            msg.append(examConfigId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchExamAnswerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Returns the exam answers before and after the current exam answer in the ordered set where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current exam answer
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next exam answer
     * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer[] findByCompanyId_GroupId_UserId_ExamConfigId_PrevAndNext(
        long id, long companyId, long groupId, Long userId, Long examConfigId,
        OrderByComparator orderByComparator)
        throws NoSuchExamAnswerException, SystemException {
        ExamAnswer examAnswer = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            ExamAnswer[] array = new ExamAnswerImpl[3];

            array[0] = getByCompanyId_GroupId_UserId_ExamConfigId_PrevAndNext(session,
                    examAnswer, companyId, groupId, userId, examConfigId,
                    orderByComparator, true);

            array[1] = examAnswer;

            array[2] = getByCompanyId_GroupId_UserId_ExamConfigId_PrevAndNext(session,
                    examAnswer, companyId, groupId, userId, examConfigId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ExamAnswer getByCompanyId_GroupId_UserId_ExamConfigId_PrevAndNext(
        Session session, ExamAnswer examAnswer, long companyId, long groupId,
        Long userId, Long examConfigId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EXAMANSWER_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_COMPANYID_2);

        query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_GROUPID_2);

        query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_USERID_2);

        query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_EXAMCONFIGID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        qPos.add(userId.longValue());

        qPos.add(examConfigId.longValue());

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(examAnswer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ExamAnswer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the exam answers where examConfigId = &#63;.
     *
     * @param examConfigId the exam config ID
     * @return the matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findByExamConfigId(Long examConfigId)
        throws SystemException {
        return findByExamConfigId(examConfigId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the exam answers where examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param examConfigId the exam config ID
     * @param start the lower bound of the range of exam answers
     * @param end the upper bound of the range of exam answers (not inclusive)
     * @return the range of matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findByExamConfigId(Long examConfigId, int start,
        int end) throws SystemException {
        return findByExamConfigId(examConfigId, start, end, null);
    }

    /**
     * Returns an ordered range of all the exam answers where examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param examConfigId the exam config ID
     * @param start the lower bound of the range of exam answers
     * @param end the upper bound of the range of exam answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findByExamConfigId(Long examConfigId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EXAMCONFIGID;
            finderArgs = new Object[] { examConfigId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EXAMCONFIGID;
            finderArgs = new Object[] {
                    examConfigId,
                    
                    start, end, orderByComparator
                };
        }

        List<ExamAnswer> list = (List<ExamAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_EXAMANSWER_WHERE);

            query.append(_FINDER_COLUMN_EXAMCONFIGID_EXAMCONFIGID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(examConfigId.longValue());

                list = (List<ExamAnswer>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first exam answer in the ordered set where examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param examConfigId the exam config ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching exam answer
     * @throws hu.advancedweb.NoSuchExamAnswerException if a matching exam answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer findByExamConfigId_First(Long examConfigId,
        OrderByComparator orderByComparator)
        throws NoSuchExamAnswerException, SystemException {
        List<ExamAnswer> list = findByExamConfigId(examConfigId, 0, 1,
                orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("examConfigId=");
            msg.append(examConfigId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchExamAnswerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Returns the last exam answer in the ordered set where examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param examConfigId the exam config ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching exam answer
     * @throws hu.advancedweb.NoSuchExamAnswerException if a matching exam answer could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer findByExamConfigId_Last(Long examConfigId,
        OrderByComparator orderByComparator)
        throws NoSuchExamAnswerException, SystemException {
        int count = countByExamConfigId(examConfigId);

        List<ExamAnswer> list = findByExamConfigId(examConfigId, count - 1,
                count, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("examConfigId=");
            msg.append(examConfigId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchExamAnswerException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    /**
     * Returns the exam answers before and after the current exam answer in the ordered set where examConfigId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param id the primary key of the current exam answer
     * @param examConfigId the exam config ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next exam answer
     * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public ExamAnswer[] findByExamConfigId_PrevAndNext(long id,
        Long examConfigId, OrderByComparator orderByComparator)
        throws NoSuchExamAnswerException, SystemException {
        ExamAnswer examAnswer = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            ExamAnswer[] array = new ExamAnswerImpl[3];

            array[0] = getByExamConfigId_PrevAndNext(session, examAnswer,
                    examConfigId, orderByComparator, true);

            array[1] = examAnswer;

            array[2] = getByExamConfigId_PrevAndNext(session, examAnswer,
                    examConfigId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ExamAnswer getByExamConfigId_PrevAndNext(Session session,
        ExamAnswer examAnswer, Long examConfigId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EXAMANSWER_WHERE);

        query.append(_FINDER_COLUMN_EXAMCONFIGID_EXAMCONFIGID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(examConfigId.longValue());

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(examAnswer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ExamAnswer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the exam answers.
     *
     * @return the exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<ExamAnswer> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the exam answers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of exam answers
     * @param end the upper bound of the range of exam answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of exam answers
     * @throws SystemException if a system exception occurred
     */
    public List<ExamAnswer> findAll(int start, int end,
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

        List<ExamAnswer> list = (List<ExamAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EXAMANSWER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EXAMANSWER;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<ExamAnswer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ExamAnswer>) QueryUtil.list(q, getDialect(),
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
     * Removes all the exam answers where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCompanyId_GroupId_UserId_ExamConfigId(long companyId,
        long groupId, Long userId, Long examConfigId) throws SystemException {
        for (ExamAnswer examAnswer : findByCompanyId_GroupId_UserId_ExamConfigId(
                companyId, groupId, userId, examConfigId)) {
            remove(examAnswer);
        }
    }

    /**
     * Removes all the exam answers where examConfigId = &#63; from the database.
     *
     * @param examConfigId the exam config ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByExamConfigId(Long examConfigId)
        throws SystemException {
        for (ExamAnswer examAnswer : findByExamConfigId(examConfigId)) {
            remove(examAnswer);
        }
    }

    /**
     * Removes all the exam answers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (ExamAnswer examAnswer : findAll()) {
            remove(examAnswer);
        }
    }

    /**
     * Returns the number of exam answers where companyId = &#63; and groupId = &#63; and userId = &#63; and examConfigId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param userId the user ID
     * @param examConfigId the exam config ID
     * @return the number of matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public int countByCompanyId_GroupId_UserId_ExamConfigId(long companyId,
        long groupId, Long userId, Long examConfigId) throws SystemException {
        Object[] finderArgs = new Object[] {
                companyId, groupId, userId, examConfigId
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_COUNT_EXAMANSWER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_GROUPID_2);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_USERID_2);

            query.append(_FINDER_COLUMN_COMPANYID_GROUPID_USERID_EXAMCONFIGID_EXAMCONFIGID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                qPos.add(userId.longValue());

                qPos.add(examConfigId.longValue());

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID_GROUPID_USERID_EXAMCONFIGID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of exam answers where examConfigId = &#63;.
     *
     * @param examConfigId the exam config ID
     * @return the number of matching exam answers
     * @throws SystemException if a system exception occurred
     */
    public int countByExamConfigId(Long examConfigId) throws SystemException {
        Object[] finderArgs = new Object[] { examConfigId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EXAMCONFIGID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EXAMANSWER_WHERE);

            query.append(_FINDER_COLUMN_EXAMCONFIGID_EXAMCONFIGID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(examConfigId.longValue());

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EXAMCONFIGID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of exam answers.
     *
     * @return the number of exam answers
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_EXAMANSWER);

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
     * Initializes the exam answer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.hu.advancedweb.model.ExamAnswer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ExamAnswer>> listenersList = new ArrayList<ModelListener<ExamAnswer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ExamAnswer>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ExamAnswerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
