package hu.advancedweb.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import hu.advancedweb.service.ExamConfigLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class ExamConfigClp extends BaseModelImpl<ExamConfig>
    implements ExamConfig {
    private long _id;
    private long _groupId;
    private long _companyId;
    private String _questions;
    private String _evaluator;

    public ExamConfigClp() {
    }

    public Class<?> getModelClass() {
        return ExamConfig.class;
    }

    public String getModelClassName() {
        return ExamConfig.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public String getQuestions() {
        return _questions;
    }

    public void setQuestions(String questions) {
        _questions = questions;
    }

    public String getEvaluator() {
        return _evaluator;
    }

    public void setEvaluator(String evaluator) {
        _evaluator = evaluator;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ExamConfigLocalServiceUtil.addExamConfig(this);
        } else {
            ExamConfigLocalServiceUtil.updateExamConfig(this);
        }
    }

    @Override
    public ExamConfig toEscapedModel() {
        return (ExamConfig) Proxy.newProxyInstance(ExamConfig.class.getClassLoader(),
            new Class[] { ExamConfig.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ExamConfigClp clone = new ExamConfigClp();

        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setQuestions(getQuestions());
        clone.setEvaluator(getEvaluator());

        return clone;
    }

    public int compareTo(ExamConfig examConfig) {
        long primaryKey = examConfig.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        ExamConfigClp examConfig = null;

        try {
            examConfig = (ExamConfigClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = examConfig.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", questions=");
        sb.append(getQuestions());
        sb.append(", evaluator=");
        sb.append(getEvaluator());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("hu.advancedweb.model.ExamConfig");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>questions</column-name><column-value><![CDATA[");
        sb.append(getQuestions());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>evaluator</column-name><column-value><![CDATA[");
        sb.append(getEvaluator());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
