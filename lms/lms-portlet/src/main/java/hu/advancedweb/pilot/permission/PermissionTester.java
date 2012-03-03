package hu.advancedweb.pilot.permission;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class PermissionTester {

	public static void test(HttpServletRequest request) throws Exception {
		System.err.println("TESTER!!!!!!!!!!!");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		System.err.println("title:" + themeDisplay.getLayout().getName());
		System.err.println("children:" + themeDisplay.getLayout().getChildren());
		Layout parent = LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
		System.err.println("parent:" + parent.getName());
		System.err.println("siblings:" + parent.getChildren());

		

//		for (Layout c : parent.getChildren()) {
//			c.getTitle();
//		}

		
		for (Layout c : parent.getChildren()) {
			// Ez a sor a Writer csoportnak ad az adott Page-re VIEW jogot
			ResourcePermissionLocalServiceUtil.setResourcePermissions(c.getCompanyId(), Layout.class.getName(), 4, "" + c.getPrimaryKey(), 11309l, new String[] { "VIEW" });
		}

	}

}
