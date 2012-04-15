package hu.advancedweb.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import hu.advancedweb.service.ClpSerializer;
import hu.advancedweb.service.ExamAnswerLocalServiceUtil;
import hu.advancedweb.service.ExamConfigLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ExamAnswerLocalServiceUtil.clearService();

            ExamConfigLocalServiceUtil.clearService();
        }
    }
}
