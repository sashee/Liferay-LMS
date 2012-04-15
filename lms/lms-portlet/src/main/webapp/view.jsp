<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/init.jsp"%>

<liferay-ui:success key="exampagevalidated" message="exampagevalidated" />

<portlet:actionURL name="submitExamPage" var="actionUrl" />
<%
	boolean hasParentPage = true;
	try {
		LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
	} catch (Exception e) {
		hasParentPage = false;
	}
%>
<%
if (!ExamPortlet.isPageAnswered(request, preferences ) && hasParentPage) {
	// exam form
%>
	<h3><liferay-ui:message key="exam-view-exam-form-title" /></h3>
	<!-- Exam form.  -->
	<aui:form name="fm" action="<%= actionUrl.toString() %>" method="post">
		<aui:fieldset>
			<%
				Map<String, List<String>> questions = ExamPortlet.getQuestionData(renderRequest, preferences);

				if (questions != null) {
					int questionNumber = 0;
					for(String key : questions.keySet()) {
						questionNumber = questionNumber + 1;
						List<String> question = questions.get(key);
						
						String type = question.get(0);
						String title = question.get(1);
						String answerKeys = question.get(2);
						String answerTitles = question.get(3);
						
						%><div class="viewQuestionBox">
							
							<div class="lmsViewQuestionTitleRow"><b><%= questionNumber %>. <liferay-ui:message key="exam-view-question-title" /></b><br/><span><%= title %></span></div>
							<div class="lmsViewYourAnswerTitleRow"><i><liferay-ui:message key="exam-view-question-your-answer" /></i></div>
						
							<%
							if (type.equals("text")) {
							%>
								<aui:input type="text" label="" name="<%= key %>" />
							<%
							} else if (type.equals("radio") || type.equals("checkbox")) {
							%>
								<% 
									String[] answerKeysArray = answerKeys.split(",");
									String[] answerTitlesArray = answerTitles.split(",");
									
									for(int i = 0; i<answerKeysArray.length; i++) {
										%>
											<aui:input type="<%= type %>" label="<%= answerTitlesArray[i] %>" name="<%= key %>" value="<%= answerKeysArray[i] %>" />
										<%
									}
								%>
							<%
						%></div><%
						}
					}
					%>
						<aui:button-row>
							<aui:button type="submit" name="submit" value="exam-view-exam-submit"/>
						</aui:button-row>
					<%
				} else {
					%>
						<div><liferay-ui:message key="exam-view-no-exam-configured" /></div>
					<%
				}
			%>
		</aui:fieldset>
	</aui:form>
<% } else if (hasParentPage) {
	%>
		<h3><liferay-ui:message key="exam-view-result-form-title" /></h3>
	<%
	// exam results
	Map<String, List<String>> questions = ExamPortlet.getQuestionData(renderRequest, preferences);
	String pageNumber = (ExamPortlet.getPageNumber(themeDisplay)) + "";
	Map<String,String> answerData = ExamPortlet.getAnswerData(request, preferences);
	ExamValidationResult result = ExamPortlet.getEvaluationData(request, preferences);
	PageValidationResult pageResult = result.pageValidations.get(pageNumber);
	
	int testScore = result.score;
	int pageScore = pageResult.score;
		
	if (questions != null) {
		int questionNumber = 0;
		for(String key : questions.keySet()) {
			questionNumber = questionNumber + 1;
			ExerciseValidationResult questionValidationResult = pageResult.exerciseValidations.get(key);
			int questionScore = questionValidationResult.score;
			String questionCorrectAnswer = questionValidationResult.text;
				
			List<String> question = questions.get(key);
				
			String type = question.get(0);
			String title = question.get(1);
			String answerKeys = question.get(2);
			String answerTitles = question.get(3);
				
			%>
			<div class="viewQuestionBox">
				
				<div class="lmsViewQuestionTitleRow"><b><%= questionNumber %>. <liferay-ui:message key="exam-view-question-title" /></b><br/><span><%= title %></span></div>
				<div class="lmsViewYourAnswerTitleRow"><i><liferay-ui:message key="exam-view-question-your-answer" /></i></div>
				
				<%
					if (type.equals("text")) {
				%>
						<input disabled style="color:black;" type="text" value="<%= answerData.get(key) %>" name="<%= key %>" />
				<%
					} else if (type.equals("radio") || type.equals("checkbox")) {
						String[] answerKeysArray = answerKeys.split(",");
						String[] answerTitlesArray = answerTitles.split(",");
						
						for(int i = 0; i<answerKeysArray.length; i++) {
							%>
								<label><%= answerTitlesArray[i] %></label>
								
								<% if (answerData.get(key).equals(answerKeysArray[i])) { %>
									<input style="color:black;" disabled type="<%= type %>" name="<%= key %>" value="<%= answerKeysArray[i] %>" checked />
								<% } else { %>
									<input style="color:black;" disabled type="<%= type %>" name="<%= key %>" value="<%= answerKeysArray[i] %>" />
								<% } %>
							<%
						}
					%>
				<% } %>
				<br/>
				<div style='color:<%= questionScore == 0 ? "red" : "green"%>;'><b><liferay-ui:message key="exam-view-question-point" /> <i><%= questionScore %></i></b></div>
				<% if(questionScore == 0) { %>
					<div style='color:red;'><b><liferay-ui:message key="exam-view-question-correct-answer" /> <i><%= questionCorrectAnswer %></i></b></div>
				<% } %>
			</div>
			<%
		}
	} else {
		%>
			<div><liferay-ui:message key="exam-view-no-exam-configured" /></div>
		<%
	}
		
	if (ExamPortlet.canUserViewNextPage(renderRequest)) { %>
		<% 
		String nextPageUrl = ExamPortlet.getNextPageUrl(renderRequest);
		if (nextPageUrl != null) { %>
			<a href="<%= nextPageUrl %>"><liferay-ui:message key="exam-view-next-page" /></a>
		<% 
		} 
	}
} else  {
	%>
		<div class="errorMessage"><liferay-ui:message key="exam-view-no-parent-page" /></div>
	<%
}
%>