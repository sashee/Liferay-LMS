package hu.advancedweb.lms.portlet;


/**
 * TODO konténere a teszt kiértékelésének dbben tároljuk majd, vagy mindig on the fly az aktuális oldal eredményét adjuk az usernek?
 */
public class ExamValidationResponse {
	private String responseText;

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	
	
}
