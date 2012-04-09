package hu.advancedweb.lms.portlet;

public class ConfigConstants {
	public static final String CMD_ADD_PAGE = "add";
	public static final String CMD_ADD_QUESTION = "add_question";
	public static final String CMD_ADD_ANSWER = "add_answer";
	public static final String CMD_UPDATE = "update";
	public static final String CMD_CHANGE_EXAM = "change-exam";
	
	public static final String CP_PAGE_INDEX = "page-index";
	public static final String CP_QUESTION_INDEX = "question-index";
	
	public static final String RA_PAGE_INDEX = "lms-page-index-param";
	public static final String RA_QUESTION_INDEX = "lms-question-index-param";
	public static final String RA_CONFIGURATION_JSP_PAGEINDEX = "configuration.jsp-pageindex";
	public static final String RA_CONFIGURATION_JSP_QUESTIONINDEX = "configuration.jsp-questionindex";
	public static final String RA_CONFIGURATION_JSP_QUESTIONDATA = "configuration.jsp-questiondata";
	public static final String RA_CONFIGURATION_JSP_EVALUATORSCRIPT = "configuration.jsp-evaluator-script";
	
	public static final String RA_CONFIGURATION_EXAM_CONFIGS = "lms-exam-configs";
	public static final String RA_CONFIGURATION_SELECTED_EXAM_CONFIG = "lms-selected-exam-config";
	public static final String RA_CONFIGURATION_SELECTED_EXAM_TEST = "lms-selected-exam-test";
	
	public static final String PREFERENCE_EXAMID = "examconfigid";
	
	public static final String QP_EXAM_CONFIG_ID = "exam_config_id";
	
	public static final String QP_PAGE_FIELD_INDEXES = "pageFieldIndexes";
	
	public static final String QP_GENERATE_EVALUATOR_LOGIC = "generate_evaluator_logic";
	
	public static final String QP_GENERATE_EVALUATOR_SCRIPT = "generate_evaluator_script";
	
	public static final String QP_FRAGMENT_QUESTION_FIELD_INDEXES = "questionFieldIndexes";
	public static String getQuestionFieldIndexName(int pageIndex) {
		return QP_FRAGMENT_QUESTION_FIELD_INDEXES + "_p" + pageIndex;
	}
	
	public static final String QP_FRAGMENT_ANSWER_FIELD_INDEXES = "answerFieldIndexes";
	public static String getAnswerFieldIndexName(int pageIndex, int questionIndex) {
		return QP_FRAGMENT_ANSWER_FIELD_INDEXES + "_p" + pageIndex + "_q" + questionIndex;
	}
	
	public static final String QP_FRAGMENT_QUESTION_TITLE = "title";
	public static String getQuestionTitleName(int pageIndex, int questionIndex) {
		return QP_FRAGMENT_QUESTION_TITLE + "_p" + pageIndex + "_q" + questionIndex;
	}
	
	public static final String QP_FRAGMENT_QUESTION_TYPE = "type";
	public static String getQuestionTypeName(int pageIndex, int questionIndex) {
		return QP_FRAGMENT_QUESTION_TYPE + "_p" + pageIndex + "_q" + questionIndex;
	}
	
	public static final String QP_FRAGMENT_ANSWER_TITLE = "title";
	public static String getAnswerTitleName(int pageIndex, int questionIndex, int answerIndex) {
		return QP_FRAGMENT_ANSWER_TITLE + "_a" + answerIndex + "_p" + pageIndex + "_q" + questionIndex;
	}
	
	public static final String QP_FRAGMENT_ANSWER_KEY = "key";
	public static String getAnswerKeyName(int pageIndex, int questionIndex, int answerIndex) {
		return QP_FRAGMENT_ANSWER_KEY + "_a" + answerIndex + "_p" + pageIndex + "_q" + questionIndex;
	}
	
	public static final String QP_FRAGMENT_QUESTION_ANSWER = "answer";
	public static String getQuestionAnswerName(int pageIndex, int questionIndex) {
		return QP_FRAGMENT_QUESTION_ANSWER + "_p" + pageIndex + "_q" + questionIndex;
	}
	
	public static final String QP_FRAGMENT_QUESTION_SCORE = "score";
	public static String getQuestionScoreName(int pageIndex, int questionIndex) {
		return QP_FRAGMENT_QUESTION_SCORE + "_p" + pageIndex + "_q" + questionIndex;
	}
	
}
