package hu.advancedweb.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import hu.advancedweb.model.ExamAnswer;

/**
 * The persistence interface for the exam answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExamAnswerPersistenceImpl
 * @see ExamAnswerUtil
 * @generated
 */
public interface ExamAnswerPersistence extends BasePersistence<ExamAnswer> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ExamAnswerUtil} to access the exam answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the exam answer in the entity cache if it is enabled.
    *
    * @param examAnswer the exam answer
    */
    public void cacheResult(hu.advancedweb.model.ExamAnswer examAnswer);

    /**
    * Caches the exam answers in the entity cache if it is enabled.
    *
    * @param examAnswers the exam answers
    */
    public void cacheResult(
        java.util.List<hu.advancedweb.model.ExamAnswer> examAnswers);

    /**
    * Creates a new exam answer with the primary key. Does not add the exam answer to the database.
    *
    * @param id the primary key for the new exam answer
    * @return the new exam answer
    */
    public hu.advancedweb.model.ExamAnswer create(long id);

    /**
    * Removes the exam answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer that was removed
    * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamAnswer remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException;

    public hu.advancedweb.model.ExamAnswer updateImpl(
        hu.advancedweb.model.ExamAnswer examAnswer, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the exam answer with the primary key or throws a {@link hu.advancedweb.NoSuchExamAnswerException} if it could not be found.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer
    * @throws hu.advancedweb.NoSuchExamAnswerException if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamAnswer findByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException;

    /**
    * Returns the exam answer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the exam answer
    * @return the exam answer, or <code>null</code> if a exam answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public hu.advancedweb.model.ExamAnswer fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<hu.advancedweb.model.ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<hu.advancedweb.model.ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<hu.advancedweb.model.ExamAnswer> findByCompanyId_GroupId_UserId_ExamConfigId(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public hu.advancedweb.model.ExamAnswer findByCompanyId_GroupId_UserId_ExamConfigId_First(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException;

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
    public hu.advancedweb.model.ExamAnswer findByCompanyId_GroupId_UserId_ExamConfigId_Last(
        long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException;

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
    public hu.advancedweb.model.ExamAnswer[] findByCompanyId_GroupId_UserId_ExamConfigId_PrevAndNext(
        long id, long companyId, long groupId, java.lang.Long userId,
        java.lang.Long examConfigId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            hu.advancedweb.NoSuchExamAnswerException;

    /**
    * Returns all the exam answers.
    *
    * @return the exam answers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<hu.advancedweb.model.ExamAnswer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<hu.advancedweb.model.ExamAnswer> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<hu.advancedweb.model.ExamAnswer> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
        long groupId, java.lang.Long userId, java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the exam answers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
        long groupId, java.lang.Long userId, java.lang.Long examConfigId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of exam answers.
    *
    * @return the number of exam answers
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
