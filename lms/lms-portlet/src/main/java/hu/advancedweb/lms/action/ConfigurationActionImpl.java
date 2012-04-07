package hu.advancedweb.lms.action;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		System.out.println("ACTION");
		
		Enumeration<?> parms = actionRequest.getParameterNames ();
		
		
		String parmname;
	    String parmval;
		while (parms.hasMoreElements ()) {
	        parmname = (String) parms.nextElement ();
	        parmval = actionRequest.getParameter (parmname);
	       
	        System.out.println(parmname + " : " + parmval);
	    }
		
		System.out.println("----------------------");
		
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		String cmd = ParamUtil.getString(renderRequest, "cmd");
		System.out.println(" -- >  " + cmd);
		
		String pageIndexParam = ParamUtil.getString(renderRequest, "page-index");
		
		if (pageIndexParam != null) {
			renderRequest.setAttribute("lms-page-index-param", pageIndexParam + "");
		}
		
		String questionIndexParam = ParamUtil.getString(renderRequest, "question-index");
		
		if (questionIndexParam != null) {
			renderRequest.setAttribute("lms-question-index-param", questionIndexParam + "");
		}
		
		if (cmd.equals("add")) {
			return "/edit_page.jsp";
		} else if (cmd.equals("add_question")) {
			return "/edit_question.jsp";
		} else if (cmd.equals("add_answer")) {
			return "/edit_answer.jsp";
		} else {
			return "/configuration.jsp";
		}
	}
}