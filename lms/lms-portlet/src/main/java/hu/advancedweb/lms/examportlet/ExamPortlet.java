package hu.advancedweb.lms.examportlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
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
        
        
        // TODO usernek beeallitjuk a kovetkezo oldalra a megtekintesi jogosultsagot
        User user = themeDisplay.getUser();
        // ...

        
        // TODO: ezt valami utilba kiemelni és jspből hívni, nem pedig itt beletenni, 
        // hogy az oldal betoltesekor is lehessen vizsgálni, hogy az user számára megjelenhet-e a következő oldal
        // sztem az alapján kellene kitenni a linket, hogy van-e joga a következő oldalt megnézni.
        Layout parent = LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
        int nextPageIndex = parent.getChildren().indexOf(themeDisplay.getLayout()) + 1;
        
        if (nextPageIndex < parent.getChildren().size()) {
        	request.setAttribute("nextpage", parent.getChildren().get(nextPageIndex).getFriendlyURL());
        }
    }
}
