package hu.advancedweb.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ExamConfig}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ExamConfig
 * @generated
 */
public class ExamConfigWrapper implements ExamConfig, ModelWrapper<ExamConfig> {
    private ExamConfig _examConfig;

    public ExamConfigWrapper(ExamConfig examConfig) {
        _examConfig = examConfig;
    }

    public Class<?> getModelClass() {
        return ExamConfig.class;
    }

    public String getModelClassName() {
        return ExamConfig.class.getName();
    }

    /**
    * Returns the primary key of this exam config.
    *
    * @return the primary key of this exam config
    */
    public long getPrimaryKey() {
        return _examConfig.getPrimaryKey();
    }

    /**
    * Sets the primary key of this exam config.
    *
    * @param primaryKey the primary key of this exam config
    */
    public void setPrimaryKey(long primaryKey) {
        _examConfig.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this exam config.
    *
    * @return the ID of this exam config
    */
    public long getId() {
        return _examConfig.getId();
    }

    /**
    * Sets the ID of this exam config.
    *
    * @param id the ID of this exam config
    */
    public void setId(long id) {
        _examConfig.setId(id);
    }

    /**
    * Returns the group ID of this exam config.
    *
    * @return the group ID of this exam config
    */
    public long getGroupId() {
        return _examConfig.getGroupId();
    }

    /**
    * Sets the group ID of this exam config.
    *
    * @param groupId the group ID of this exam config
    */
    public void setGroupId(long groupId) {
        _examConfig.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this exam config.
    *
    * @return the company ID of this exam config
    */
    public long getCompanyId() {
        return _examConfig.getCompanyId();
    }

    /**
    * Sets the company ID of this exam config.
    *
    * @param companyId the company ID of this exam config
    */
    public void setCompanyId(long companyId) {
        _examConfig.setCompanyId(companyId);
    }

    /**
    * Returns the questions of this exam config.
    *
    * @return the questions of this exam config
    */
    public java.lang.String getQuestions() {
        return _examConfig.getQuestions();
    }

    /**
    * Sets the questions of this exam config.
    *
    * @param questions the questions of this exam config
    */
    public void setQuestions(java.lang.String questions) {
        _examConfig.setQuestions(questions);
    }

    /**
    * Returns the evaluator of this exam config.
    *
    * @return the evaluator of this exam config
    */
    public java.lang.String getEvaluator() {
        return _examConfig.getEvaluator();
    }

    /**
    * Sets the evaluator of this exam config.
    *
    * @param evaluator the evaluator of this exam config
    */
    public void setEvaluator(java.lang.String evaluator) {
        _examConfig.setEvaluator(evaluator);
    }

    public boolean isNew() {
        return _examConfig.isNew();
    }

    public void setNew(boolean n) {
        _examConfig.setNew(n);
    }

    public boolean isCachedModel() {
        return _examConfig.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _examConfig.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _examConfig.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _examConfig.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _examConfig.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _examConfig.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _examConfig.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ExamConfigWrapper((ExamConfig) _examConfig.clone());
    }

    public int compareTo(hu.advancedweb.model.ExamConfig examConfig) {
        return _examConfig.compareTo(examConfig);
    }

    @Override
    public int hashCode() {
        return _examConfig.hashCode();
    }

    public com.liferay.portal.model.CacheModel<hu.advancedweb.model.ExamConfig> toCacheModel() {
        return _examConfig.toCacheModel();
    }

    public hu.advancedweb.model.ExamConfig toEscapedModel() {
        return new ExamConfigWrapper(_examConfig.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _examConfig.toString();
    }

    public java.lang.String toXmlString() {
        return _examConfig.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _examConfig.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public ExamConfig getWrappedExamConfig() {
        return _examConfig;
    }

    public ExamConfig getWrappedModel() {
        return _examConfig;
    }

    public void resetOriginalValues() {
        _examConfig.resetOriginalValues();
    }
}
