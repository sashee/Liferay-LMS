package hu.advancedweb.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ExamAnswerSoap implements Serializable {
    private long _id;
    private long _groupId;
    private long _companyId;
    private Long _userId;
    private String _answers;
    private Date _date;
    private Long _examConfigId;

    public ExamAnswerSoap() {
    }

    public static ExamAnswerSoap toSoapModel(ExamAnswer model) {
        ExamAnswerSoap soapModel = new ExamAnswerSoap();

        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setAnswers(model.getAnswers());
        soapModel.setDate(model.getDate());
        soapModel.setExamConfigId(model.getExamConfigId());

        return soapModel;
    }

    public static ExamAnswerSoap[] toSoapModels(ExamAnswer[] models) {
        ExamAnswerSoap[] soapModels = new ExamAnswerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ExamAnswerSoap[][] toSoapModels(ExamAnswer[][] models) {
        ExamAnswerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ExamAnswerSoap[models.length][models[0].length];
        } else {
            soapModels = new ExamAnswerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ExamAnswerSoap[] toSoapModels(List<ExamAnswer> models) {
        List<ExamAnswerSoap> soapModels = new ArrayList<ExamAnswerSoap>(models.size());

        for (ExamAnswer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ExamAnswerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
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
}
