package hu.advancedweb.lms.examportlet;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
        
		Layout nextLayout = null;
        
        // TODO: ezt valami utilba kiemelni és jspből hívni, nem pedig itt beletenni, 
        // hogy az oldal betoltesekor is lehessen vizsgálni, hogy az user számára megjelenhet-e a következő oldal
        // sztem az alapján kellene kitenni a linket, hogy van-e joga a következő oldalt megnézni.
        Layout parent = LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
        int nextPageIndex = parent.getChildren().indexOf(themeDisplay.getLayout()) + 1;
        
        if (nextPageIndex < parent.getChildren().size()) {
			nextLayout = parent.getChildren().get(nextPageIndex);
		}

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

			request.setAttribute("nextpage", nextLayout.getFriendlyURL());
        }

    }

	private String getRoleNameForLayout(Layout layout) {
		return "ExamViewFor" + layout.getFriendlyURL().substring(layout.getFriendlyURL().lastIndexOf("/") + 1);
	}

	private boolean canUserViewNextPage(long companyId, long userid, Layout nextLayout) throws SystemException, PortalException {
		String roleName = getRoleNameForLayout(nextLayout);
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
}
