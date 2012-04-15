package hu.advancedweb.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExamAnswer}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExamAnswer
 * @generated
 */
public class ExamAnswerWrapper implements ExamAnswer, ModelWrapper<ExamAnswer> {
    private ExamAnswer _examAnswer;

    public ExamAnswerWrapper(ExamAnswer examAnswer) {
        _examAnswer = examAnswer;
    }

    public Class<?> getModelClass() {
        return ExamAnswer.class;
    }

    public String getModelClassName() {
        return ExamAnswer.class.getName();
    }

    /**
    * Returns the primary key of this exam answer.
    *
    * @return the primary key of this exam answer
    */
    public long getPrimaryKey() {
        return _examAnswer.getPrimaryKey();
    }

    /**
    * Sets the primary key of this exam answer.
    *
    * @param primaryKey the primary key of this exam answer
    */
    public void setPrimaryKey(long primaryKey) {
        _examAnswer.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this exam answer.
    *
    * @return the ID of this exam answer
    */
    public long getId() {
        return _examAnswer.getId();
    }

    /**
    * Sets the ID of this exam answer.
    *
    * @param id the ID of this exam answer
    */
    public void setId(long id) {
        _examAnswer.setId(id);
    }

    /**
    * Returns the group ID of this exam answer.
    *
    * @return the group ID of this exam answer
    */
    public long getGroupId() {
        return _examAnswer.getGroupId();
    }

    /**
    * Sets the group ID of this exam answer.
    *
    * @param groupId the group ID of this exam answer
    */
    public void setGroupId(long groupId) {
        _examAnswer.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this exam answer.
    *
    * @return the company ID of this exam answer
    */
    public long getCompanyId() {
        return _examAnswer.getCompanyId();
    }

    /**
    * Sets the company ID of this exam answer.
    *
    * @param companyId the company ID of this exam answer
    */
    public void setCompanyId(long companyId) {
        _examAnswer.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this exam answer.
    *
    * @return the user ID of this exam answer
    */
    public java.lang.Long getUserId() {
        return _examAnswer.getUserId();
    }

    /**
    * Sets the user ID of this exam answer.
    *
    * @param userId the user ID of this exam answer
    */
    public void setUserId(java.lang.Long userId) {
        _examAnswer.setUserId(userId);
    }

    /**
    * Returns the answers of this exam answer.
    *
    * @return the answers of this exam answer
    */
    public java.lang.String getAnswers() {
        return _examAnswer.getAnswers();
    }

    /**
    * Sets the answers of this exam answer.
    *
    * @param answers the answers of this exam answer
    */
    public void setAnswers(java.lang.String answers) {
        _examAnswer.setAnswers(answers);
    }

    /**
    * Returns the date of this exam answer.
    *
    * @return the date of this exam answer
    */
    public java.util.Date getDate() {
        return _examAnswer.getDate();
    }

    /**
    * Sets the date of this exam answer.
    *
    * @param date the date of this exam answer
    */
    public void setDate(java.util.Date date) {
        _examAnswer.setDate(date);
    }

    /**
    * Returns the exam config ID of this exam answer.
    *
    * @return the exam config ID of this exam answer
    */
    public java.lang.Long getExamConfigId() {
        return _examAnswer.getExamConfigId();
    }

    /**
    * Sets the exam config ID of this exam answer.
    *
    * @param examConfigId the exam config ID of this exam answer
    */
    public void setExamConfigId(java.lang.Long examConfigId) {
        _examAnswer.setExamConfigId(examConfigId);
    }

    public boolean isNew() {
        return _examAnswer.isNew();
    }

    public void setNew(boolean n) {
        _examAnswer.setNew(n);
    }

    public boolean isCachedModel() {
        return _examAnswer.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _examAnswer.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _examAnswer.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _examAnswer.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _examAnswer.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _examAnswer.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _examAnswer.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ExamAnswerWrapper((ExamAnswer) _examAnswer.clone());
    }

    public int compareTo(hu.advancedweb.model.ExamAnswer examAnswer) {
        return _examAnswer.compareTo(examAnswer);
    }

    @Override
    public int hashCode() {
        return _examAnswer.hashCode();
    }

    public com.liferay.portal.model.CacheModel<hu.advancedweb.model.ExamAnswer> toCacheModel() {
        return _examAnswer.toCacheModel();
    }

    public hu.advancedweb.model.ExamAnswer toEscapedModel() {
        return new ExamAnswerWrapper(_examAnswer.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _examAnswer.toString();
    }

    public java.lang.String toXmlString() {
        return _examAnswer.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _examAnswer.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ExamAnswer getWrappedExamAnswer() {
        return _examAnswer;
    }

    public ExamAnswer getWrappedModel() {
        return _examAnswer;
    }

    public void resetOriginalValues() {
        _examAnswer.resetOriginalValues();
    }
}
