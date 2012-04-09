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
if (!ExamPortlet.isPageAnswered(request)) {
%>
	<!-- Exam form.  -->
	<aui:form name="fm" action="<%= actionUrl.toString() %>" method="post">
		<aui:fieldset>
		
			<%
				Map<String, List<String>> questions = ExamPortlet.getQuestionData(renderRequest, preferences);
				String pageNumber = (ExamPortlet.getPageNumber(themeDisplay) + 1) + "";
				
				if (questions != null) {
					for(String key : questions.keySet()) {
						List<String> question = questions.get(key);
						
						String type = question.get(0);
						String title = question.get(1);
						String answerKeys = question.get(2);
						String answerTitles = question.get(3);
						
						if (type.equals("text")) {
						%>
							<aui:input type="text" label="<%= title %>" name="<%= key %>" />
						<%
						} else if (type.equals("radio") || type.equals("checkbox")) {
						%>
							<span><%= title %></span>
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
						}
					}
				} else {
					%>
						<div>Nincs kérdés definiálva erre az oldalra!</div>
					<%
				}
			%>
			<aui:button-row>
				<aui:button type="submit" name="submit"/>
			</aui:button-row>
		</aui:fieldset>
	</aui:form>
<% } else {
		Map<String, List<String>> questions = ExamPortlet.getQuestionData(renderRequest, preferences);
		String pageNumber = (ExamPortlet.getPageNumber(themeDisplay) + 1) + "";
		
		if (questions != null) {
			for(String key : questions.keySet()) {
				List<String> question = questions.get(key);
				
				String type = question.get(0);
				String title = question.get(1);
				String answerKeys = question.get(2);
				String answerTitles = question.get(3);
				
				%>
				<div><%= key %></div>
				<div><%= title %></div>
				<%
			}
		} else {
			%>
				<div>Nincs kérdés definiálva erre az oldalra!</div>
			<%
		}
		
		if (ExamPortlet.canUserViewNextPage(renderRequest)) { %>
			<% 
			String nextPageUrl = ExamPortlet.getNextPageUrl(renderRequest);
			if (nextPageUrl != null) { %>
				<a href="<%= nextPageUrl %>">Következő oldal</a>
			<% 
			} 
		}
	} 
%>