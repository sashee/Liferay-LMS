package hu.advancedweb.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import hu.advancedweb.model.ExamAnswer;

import java.util.List;

/**
 * The persistence utility for the exam answer service. This utility wraps {@link ExamAnswerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamAnswerPersistence
 * @see ExamAnswerPersistenceImpl
 * @generated
 */
public class ExamAnswerUtil {
    private static ExamAnswerPersistence _persistence;

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
    public static void clearCache(ExamAnswer examAnswer) {
        getPersistence().clearCache(examAnswer);
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
    public static List<ExamAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<ExamAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<ExamAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static ExamAnswer update(ExamAnswer examAnswer, boolean merge)
        throws SystemException {
        return getPersistence().update(examAnswer, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static ExamAnswer update(ExamAnswer examAnswer, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(examAnswer, merge, serviceContext);
    }

    /**
    * Caches the exam answer in the entity cache if it is enabled.
    *
    * @param examAnswer the exam answer
    */
    public static void cacheResult(hu.advancedweb.model.ExamAnswer examAnswer) {
        getPersistence().cacheResult(examAnswer);
    }

    /**
    * Caches the exam answers in the entity cache if it is enabled.
    *
    * @param examAnswers the exam answers
    */
    public static void cacheResult(
        java.util.List<hu.advancedweb.model.ExamAnswer> examAnswers) {
        getPersistence().cacheResult(examAnswers);
    }

    /**
    * Creates a new exam answer with the primary key. Does not add the exam answer to the database.
    *
    * @param id the primary key for the new exam answer
    * @return the new exam answer
    */
    public static hu.advancedweb.model.ExamAnswer create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the exam answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer that was removed
    * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamAnswer remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence().remove(id);
    }

    public static hu.advancedweb.model.ExamAnswer updateImpl(
        hu.advancedweb.model.ExamAnswer examAnswer, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(examAnswer, merge);
    }

    /**
    * Returns the exam answer with the primary key or throws a {@link hu.advancedweb.NoSuchExamAnswerException} if it could not be found.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer
    * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamAnswer findByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the exam answer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer, or <code>null</code> if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static hu.advancedweb.model.ExamAnswer fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
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
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_GroupId_UserId_ExamConfigId(companyId,
            groupId, userId, examConfigId);
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
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_GroupId_UserId_ExamConfigId(companyId,
            groupId, userId, examConfigId, start, end);
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
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId_GroupId_UserId_ExamConfigId(companyId,
            groupId, userId, examConfigId, start, end, orderByComparator);
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
    public static hu.advancedweb.model.ExamAnswer findByCompanyId_GroupId_UserId_ExamConfigId_First(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence()
                   .findByCompanyId_GroupId_UserId_ExamConfigId_First(companyId,
            groupId, userId, examConfigId, orderByComparator);
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
    public static hu.advancedweb.model.ExamAnswer findByCompanyId_GroupId_UserId_ExamConfigId_Last(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence()
                   .findByCompanyId_GroupId_UserId_ExamConfigId_Last(companyId,
            groupId, userId, examConfigId, orderByComparator);
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
    public static hu.advancedweb.model.ExamAnswer[] findByCompanyId_GroupId_UserId_ExamConfigId_PrevAndNext(
        long id, long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence()
                   .findByCompanyId_GroupId_UserId_ExamConfigId_PrevAndNext(id,
            companyId, groupId, userId, examConfigId, orderByComparator);
    }

    /**
    * Returns all the exam answers where examConfigId = &#63;.
    *
    * @param examConfigId the exam config ID
    * @return the matching exam answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findByExamConfigId(
        java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByExamConfigId(examConfigId);
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
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findByExamConfigId(
        java.lang.Long examConfigId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByExamConfigId(examConfigId, start, end);
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
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findByExamConfigId(
        java.lang.Long examConfigId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByExamConfigId(examConfigId, start, end,
            orderByComparator);
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
    public static hu.advancedweb.model.ExamAnswer findByExamConfigId_First(
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence()
                   .findByExamConfigId_First(examConfigId, orderByComparator);
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
    public static hu.advancedweb.model.ExamAnswer findByExamConfigId_Last(
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence()
                   .findByExamConfigId_Last(examConfigId, orderByComparator);
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
    public static hu.advancedweb.model.ExamAnswer[] findByExamConfigId_PrevAndNext(
        long id, java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException {
        return getPersistence()
                   .findByExamConfigId_PrevAndNext(id, examConfigId,
            orderByComparator);
    }

    /**
    * Returns all the exam answers.
    *
    * @return the exam answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<hu.advancedweb.model.ExamAnswer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
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
    public static void removeByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByCompanyId_GroupId_UserId_ExamConfigId(companyId, groupId,
            userId, examConfigId);
    }

    /**
    * Removes all the exam answers where examConfigId = &#63; from the database.
    *
    * @param examConfigId the exam config ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByExamConfigId(java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByExamConfigId(examConfigId);
    }

    /**
    * Removes all the exam answers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
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
    public static int countByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCompanyId_GroupId_UserId_ExamConfigId(companyId,
            groupId, userId, examConfigId);
    }

    /**
    * Returns the number of exam answers where examConfigId = &#63;.
    *
    * @param examConfigId the exam config ID
    * @return the number of matching exam answers
    * @throws SystemException if a system exception occurred
    */
    public static int countByExamConfigId(java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByExamConfigId(examConfigId);
    }

    /**
    * Returns the number of exam answers.
    *
    * @return the number of exam answers
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static ExamAnswerPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (ExamAnswerPersistence) PortletBeanLocatorUtil.locate(hu.advancedweb.service.ClpSerializer.getServletContextName(),
                    ExamAnswerPersistence.class.getName());

            ReferenceRegistry.registerReference(ExamAnswerUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(ExamAnswerPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(ExamAnswerUtil.class, "_persistence");
    }
}
