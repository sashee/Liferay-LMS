package hu.advancedweb.pilot.rhino;


import org.mozilla.javascript.ScriptableObject;

public class ExamDataBean extends ScriptableObject {
	private static final long serialVersionUID = 5831489320783762180L;
	
	private String testData; // should be json, map...

	public String getTestData() {
		return testData;
	}

	public void setTestData(String testData) {
		this.testData = testData;
	}
	
	public String jsGet_testData() {
		return testData;
	}
	
	@Override
	public String getClassName() {
		return ExamDataBean.class.getName();
	}
}
