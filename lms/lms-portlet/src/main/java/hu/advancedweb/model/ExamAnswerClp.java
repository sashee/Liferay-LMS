package hu.advancedweb.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import hu.advancedweb.service.ExamAnswerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;


public class ExamAnswerClp extends BaseModelImpl<ExamAnswer>
    implements ExamAnswer {
    private long _id;
    private long _groupId;
    private long _companyId;
    private Long _userId;
    private String _answers;
    private Date _date;
    private Long _examConfigId;

    public ExamAnswerClp() {
    }

    public Class<?> getModelClass() {
        return ExamAnswer.class;
    }

    public String getModelClassName() {
        return ExamAnswer.class.getName();
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

    public Long getUserId() {
        return _userId;
    }

    public void setUserId(Long userId) {
        _userId = userId;
    }

    public String getAnswers() {
        return _answers;
    }

    public void setAnswers(String answers) {
        _answers = answers;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        _date = date;
    }

    public Long getExamConfigId() {
        return _examConfigId;
    }

    public void setExamConfigId(Long examConfigId) {
        _examConfigId = examConfigId;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            ExamAnswerLocalServiceUtil.addExamAnswer(this);
        } else {
            ExamAnswerLocalServiceUtil.updateExamAnswer(this);
        }
    }

    @Override
    public ExamAnswer toEscapedModel() {
        return (ExamAnswer) Proxy.newProxyInstance(ExamAnswer.class.getClassLoader(),
            new Class[] { ExamAnswer.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ExamAnswerClp clone = new ExamAnswerClp();

        clone.setId(getId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setAnswers(getAnswers());
        clone.setDate(getDate());
        clone.setExamConfigId(getExamConfigId());

        return clone;
    }

    public int compareTo(ExamAnswer examAnswer) {
        long primaryKey = examAnswer.getPrimaryKey();

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

        ExamAnswerClp examAnswer = null;

        try {
            examAnswer = (ExamAnswerClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = examAnswer.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", answers=");
        sb.append(getAnswers());
        sb.append(", date=");
        sb.append(getDate());
        sb.append(", examConfigId=");
        sb.append(getExamConfigId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("hu.advancedweb.model.ExamAnswer");
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
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answers</column-name><column-value><![CDATA[");
        sb.append(getAnswers());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>date</column-name><column-value><![CDATA[");
        sb.append(getDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>examConfigId</column-name><column-value><![CDATA[");
        sb.append(getExamConfigId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
