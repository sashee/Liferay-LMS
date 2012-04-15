package hu.advancedweb.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ExamConfigSoap implements Serializable {
    private long _id;
    private long _groupId;
    private long _companyId;
    private String _questions;
    private String _evaluator;

    public ExamConfigSoap() {
    }

    public static ExamConfigSoap toSoapModel(ExamConfig model) {
        ExamConfigSoap soapModel = new ExamConfigSoap();

        soapModel.setId(model.getId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setQuestions(model.getQuestions());
        soapModel.setEvaluator(model.getEvaluator());

        return soapModel;
    }

    public static ExamConfigSoap[] toSoapModels(ExamConfig[] models) {
        ExamConfigSoap[] soapModels = new ExamConfigSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ExamConfigSoap[][] toSoapModels(ExamConfig[][] models) {
        ExamConfigSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ExamConfigSoap[models.length][models[0].length];
        } else {
            soapModels = new ExamConfigSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ExamConfigSoap[] toSoapModels(List<ExamConfig> models) {
        List<ExamConfigSoap> soapModels = new ArrayList<ExamConfigSoap>(models.size());

        for (ExamConfig model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ExamConfigSoap[soapModels.size()]);
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
}
