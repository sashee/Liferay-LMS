package hu.advancedweb.lms.examportlet;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import com.liferay.portal.NoSuchRoleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
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

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        
        // TODO: teszt automatikus validalasa, eredm�ny beallitasa parameterkent / eltarolni / valami
        String answer = ParamUtil.getString(request, "answer");
        
        ExamValidationResponse examValidationResponse = new ExamValidationResponse();
        
        if (answer.equals("5")) {
        	examValidationResponse.setResponseText("1 pont");
        } else {
        	examValidationResponse.setResponseText("0 pont");
        }
            
        SessionMessages.add(request, "exampagevalidated");
        request.setAttribute("validationResponse", examValidationResponse);
        
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
}
