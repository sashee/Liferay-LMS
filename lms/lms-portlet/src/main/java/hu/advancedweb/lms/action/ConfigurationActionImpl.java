package hu.advancedweb.lms.action;

import hu.advancedweb.lms.evaluation.ExamTest;
import hu.advancedweb.lms.portlet.ConfigConstants;
import hu.advancedweb.model.ExamConfig;
import hu.advancedweb.service.ExamConfigLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		
		
		String cmd = actionRequest.getParameter(Constants.CMD);
		
		if (cmd.equals(ConfigConstants.CMD_CHANGE_EXAM)) {
			preferences.setValue(ConfigConstants.PREFERENCE_EXAMID, actionRequest.getParameter(ConfigConstants.QP_EXAM_CONFIG_ID));
		} else if (cmd.equals(ConfigConstants.CMD_UPDATE)) {
			// TODo
			
		} else {
			// todo: unknown command
		}
		
		
		Enumeration<?> parms = actionRequest.getParameterNames ();
		
		List<String> a = new ArrayList<String>();
		
		String parmname;
	    String parmval;
		while (parms.hasMoreElements ()) {
	        parmname = (String) parms.nextElement ();
	        parmval = actionRequest.getParameter (parmname);
	        a.add(parmname + " : " + parmval);
	    }
		
		Collections.sort(a);
		
		for (String string : a) {
			System.out.println(string);
		}
		
		System.out.println("----------------------");
		
		
		preferences.store();
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		
		PortletPreferences preferences = renderRequest.getPreferences();
		
		// Render Command
		String cmd = ParamUtil.getString(renderRequest, Constants.CMD);
		
		// Render Command Params
		String pageIndexParam = ParamUtil.getString(renderRequest, ConfigConstants.CP_PAGE_INDEX);
		if (pageIndexParam != null) {
			renderRequest.setAttribute(ConfigConstants.RA_PAGE_INDEX, pageIndexParam + "");
		}
		String questionIndexParam = ParamUtil.getString(renderRequest, ConfigConstants.CP_QUESTION_INDEX);
		if (questionIndexParam != null) {
			renderRequest.setAttribute(ConfigConstants.RA_QUESTION_INDEX, questionIndexParam + "");
		}
		
		if (cmd.equals(ConfigConstants.CMD_ADD_PAGE)) {
			// Render page fragment
			return "/edit_page.jsp";
		} else if (cmd.equals(ConfigConstants.CMD_ADD_QUESTION)) {
			// Render question fragment
			return "/edit_question.jsp";
		} else if (cmd.equals(ConfigConstants.CMD_ADD_ANSWER)) {
			// Render answer fragment
			return "/edit_answer.jsp";
		} else {
			// Render whole config page
			
			//  Selected Exam config
			long examConfigId = GetterUtil.getLong(preferences.getValue(ConfigConstants.PREFERENCE_EXAMID, "-1"));
			ExamConfig selectedExamConfig = null;
			boolean examConfigIdFound = false;
			
			//  Exam configs
			List<ExamConfig> examConfigs = ExamConfigLocalServiceUtil.getExamConfigs(0, ExamConfigLocalServiceUtil.getExamConfigsCount());
			List<Long> examConfigIds = new ArrayList<Long>();
			for (ExamConfig examConfig : examConfigs) {
				if (examConfig.getId() == examConfigId) {
					examConfigIdFound = true;
					selectedExamConfig = examConfig;
				}
				examConfigIds.add(examConfig.getId());
			}
			Collections.sort(examConfigIds);
			
			renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_EXAM_CONFIGS, examConfigIds);
			
			if (examConfigIdFound) {
				renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_CONFIG, examConfigId);
				renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_TEST, new ExamTest(selectedExamConfig.getQuestions()));
			} else {
				renderRequest.setAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_CONFIG, -1L);
			}
			
			return "/configuration.jsp";
		}
	}
}