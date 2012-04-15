package hu.advancedweb.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import hu.advancedweb.model.ExamConfig;

import java.io.Serializable;

/**
 * The cache model class for representing ExamConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ExamConfig
 * @generated
 */
public class ExamConfigCacheModel implements CacheModel<ExamConfig>,
    Serializable {
    public long id;
    public long groupId;
    public long companyId;
    public String questions;
    public String evaluator;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", questions=");
        sb.append(questions);
        sb.append(", evaluator=");
        sb.append(evaluator);
        sb.append("}");

        return sb.toString();
    }

    public ExamConfig toEntityModel() {
        ExamConfigImpl examConfigImpl = new ExamConfigImpl();

        examConfigImpl.setId(id);
        examConfigImpl.setGroupId(groupId);
        examConfigImpl.setCompanyId(companyId);

        if (questions == null) {
            examConfigImpl.setQuestions(StringPool.BLANK);
        } else {
            examConfigImpl.setQuestions(questions);
        }

        if (evaluator == null) {
            examConfigImpl.setEvaluator(StringPool.BLANK);
        } else {
            examConfigImpl.setEvaluator(evaluator);
        }

        examConfigImpl.resetOriginalValues();

        return examConfigImpl;
    }
}
