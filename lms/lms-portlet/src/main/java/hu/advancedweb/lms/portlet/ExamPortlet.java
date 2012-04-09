package hu.advancedweb.lms.portlet;

import hu.advancedweb.lms.evaluation.ExamEvaluator;
import hu.advancedweb.lms.evaluation.ExamTest;
import hu.advancedweb.model.ExamConfig;
import hu.advancedweb.service.ExamConfigLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * TODO
 */
public class ExamPortlet extends MVCPortlet {

	
	/**
	 * Az adott teszt oldalt kuldi be.
	 * Lefut a beallitott automatikus validacio, 
	 * jogosultsagot kap a kovetkezo oldalra, amihez egy link is meg fog jelenni.
	 * 
	 * TODO
	 * 
	 * @param request
	 * @param response
	 */
    public void submitExamPage(ActionRequest request, ActionResponse response) throws Exception {
    	
    	
		// DEBUG
		{
			Enumeration<?> parms = request.getParameterNames ();
			
			List<String> a = new ArrayList<String>();
			
			String parmname;
		    String parmval;
			while (parms.hasMoreElements ()) {
		        parmname = (String) parms.nextElement ();
		        parmval = request.getParameter (parmname);
		        a.add(parmname + " : " + parmval);
		    }
			
			Collections.sort(a);
			
			for (String string : a) {
				System.out.println(string);
			}
			
			System.out.println("----------------------");
		}
		
		
		String portletResource = ParamUtil.getString(request, "portletResource");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
		long examConfigId = GetterUtil.getLong(preferences.getValue(ConfigConstants.PREFERENCE_EXAMID, "-1"));
		
		Map<String,String> answerMap = new HashMap<String, String>();
		
		
		
		ExamConfig examConfig = ExamConfigLocalServiceUtil.getExamConfig(examConfigId);
		ExamTest examTest = new ExamTest(examConfig.getQuestions());
		Map<String, List<String>> pageQuestions = examTest.tests.get(getPageNumber(themeDisplay) + "");
		
		for(String question : pageQuestions.keySet()) {
			String answer = ParamUtil.getString(request, question);
			if (answer == null ) {
				break;
			} else {
				answerMap.put(question, answer);
			}
		}
		
		ExamEvaluator.appendAnswers(PortalUtil.getCompanyId(request), themeDisplay.getLayout().getGroupId(), themeDisplay.getUser().getUserId(), examConfigId, getPageNumber(themeDisplay) + "", answerMap);
    	
    	
    	
    	

       

        
        // TODO: teszt automatikus validalasa, eredm�ny beallitasa parameterkent / eltarolni / valami
        
        ExamValidationResponse examValidationResponse = new ExamValidationResponse();
        examValidationResponse.setResponseText("1 pont TODO");
            
        SessionMessages.add(request, "exampagevalidated");
        request.setAttribute("validationResponse", examValidationResponse);
        
        // TODO
        
        
        
        Layout nextLayout = getNextPage(themeDisplay);

		if (nextLayout != null) {
			// usernek beeallitjuk a kovetkezo oldalra a megtekintesi jogosultsagot

			String roleName = getRoleNameForLayout(nextLayout);

			User user = themeDisplay.getUser();

			Role existing = null;
			try {

				existing = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), roleName);
			} catch (NoSuchRoleException nsre) {
			}
			if (existing == null) {
				// Szerep letrehozasa

				Map<Locale, String> title = new HashMap<Locale, String>();
				title.put(Locale.ENGLISH, roleName);
				
				existing = RoleLocalServiceUtil.addRole(0, themeDisplay.getCompanyId(), roleName, title, title, 1);

				ResourcePermissionLocalServiceUtil.setResourcePermissions(themeDisplay.getCompanyId(), Layout.class.getName(), 4, "" + nextLayout.getPrimaryKey(), existing.getPrimaryKey(), new String[] { "VIEW" });

			}
			UserLocalServiceUtil.addRoleUsers(existing.getPrimaryKey(), new long[] { user.getPrimaryKey() });
        }

    }
    
    
    
    
    
    
    public static Map<String, List<String>> getQuestionData(RenderRequest request, PortletPreferences preferences) {
		long examConfigId = GetterUtil.getLong(preferences.getValue(ConfigConstants.PREFERENCE_EXAMID, "-1"));
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			ExamConfig examConfig = ExamConfigLocalServiceUtil.getExamConfig(examConfigId);
			
			ExamTest examTest = new ExamTest(examConfig.getQuestions());
			
			Map<String, List<String>> pageQuestions = examTest.tests.get(getPageNumber(themeDisplay) + "");
			return pageQuestions;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return null;
	}
    
    public static boolean canUserViewNextPage(RenderRequest request) throws SystemException, PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		long userid = themeDisplay.getUser().getUserId();
		long companyId = themeDisplay.getUser().getCompanyId();
		
		Layout layout = getNextPage(themeDisplay);
		if (layout == null) {
			return false;
		}
		
		String roleName = getRoleNameForLayout(layout);

		try {

			Role existing = RoleLocalServiceUtil.getRole(companyId, roleName);

			for (Role r : RoleLocalServiceUtil.getUserRoles(userid)) {
				if (r.getPrimaryKey() == existing.getPrimaryKey()) {
					return true;
				}
			}
			return false;

		} catch (NoSuchRoleException nsre) {
			return false;
		}
	}

	public static String getNextPageUrl(RenderRequest request) throws SystemException, PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Layout nextPage = getNextPage(themeDisplay);
		return (nextPage == null) ? null : nextPage.getFriendlyURL();
	}

	private static String getRoleNameForLayout(Layout layout) {
		return "ExamViewFor" + layout.getFriendlyURL().substring(layout.getFriendlyURL().lastIndexOf("/") + 1);
	}
	
	private static Layout getNextPage(ThemeDisplay themeDisplay) throws PortalException, SystemException {
		Layout parent = LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
        int nextPageIndex = parent.getChildren().indexOf(themeDisplay.getLayout()) + 1;
        
        if (nextPageIndex < parent.getChildren().size()) {
			return parent.getChildren().get(nextPageIndex);
		} else {
			return null;
		}
	}
	
	public static int getPageNumber(ThemeDisplay themeDisplay) throws PortalException, SystemException {
		Layout parent = LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
        int nextPageIndex = parent.getChildren().indexOf(themeDisplay.getLayout()) + 1;
        return nextPageIndex;
	}
	
	public static boolean isPageAnswered(HttpServletRequest request) {
		try {
			String portletResource = ParamUtil.getString(request, "portletResource");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
			long examConfigId = GetterUtil.getLong(preferences.getValue(ConfigConstants.PREFERENCE_EXAMID, "-1"));
			boolean isPageAnswered = ExamEvaluator.isPageAnswered(PortalUtil.getCompanyId(request), themeDisplay.getLayout().getGroupId(), themeDisplay.getUser().getUserId(), examConfigId, getPageNumber(themeDisplay) + "");
			return isPageAnswered;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
