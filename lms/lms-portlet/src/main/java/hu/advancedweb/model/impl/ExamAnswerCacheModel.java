package hu.advancedweb.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.advancedweb.model.ExamAnswer;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ExamAnswer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ExamAnswer
 * @generated
 */
public class ExamAnswerCacheModel implements CacheModel<ExamAnswer>,
    Serializable {
    public long id;
    public long groupId;
    public long companyId;
    public Long userId;
    public String answers;
    public long date;
    public Long examConfigId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", answers=");
        sb.append(answers);
        sb.append(", date=");
        sb.append(date);
        sb.append(", examConfigId=");
        sb.append(examConfigId);
        sb.append("}");

        return sb.toString();
    }

    public ExamAnswer toEntityModel() {
        ExamAnswerImpl examAnswerImpl = new ExamAnswerImpl();

        examAnswerImpl.setId(id);
        examAnswerImpl.setGroupId(groupId);
        examAnswerImpl.setCompanyId(companyId);
        examAnswerImpl.setUserId(userId);

        if (answers == null) {
            examAnswerImpl.setAnswers(StringPool.BLANK);
        } else {
            examAnswerImpl.setAnswers(answers);
        }

        if (date == Long.MIN_VALUE) {
            examAnswerImpl.setDate(null);
        } else {
            examAnswerImpl.setDate(new Date(date));
        }

        examAnswerImpl.setExamConfigId(examConfigId);

        examAnswerImpl.resetOriginalValues();

        return examAnswerImpl;
    }
}
