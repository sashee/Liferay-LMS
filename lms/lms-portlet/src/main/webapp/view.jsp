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

<!-- Vizsga form.  -->
<aui:form name="fm" action="<%= actionUrl.toString() %>" method="post">
	<aui:fieldset>
		Mennyi 2+3?
		<aui:input name="answer" size="2" />
		<aui:button-row>
			<aui:button type="submit" name="submit"/>
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<!-- Vizsga kiertekeles. -->
<div style="background:lightBlue;">
	<%
		ExamValidationResponse examValidationResponse = (ExamValidationResponse)request.getAttribute("validationResponse");
		if (examValidationResponse != null) { 
	%>
			<div style="color:red; border-bottom:1px solid black;"><%= examValidationResponse.getResponseText() %></div>
	<%
		}
	%>
	
	
	<% if (ExamPortlet.canUserViewNextPage(renderRequest)) { %>
	
		<% 
		String nextPageUrl = ExamPortlet.getNextPageUrl(renderRequest);
		if (nextPageUrl != null) { %>
		<a href="<%= nextPageUrl %>">Következő oldal</a>
		<% } %>
	
	<% } %>
</div> 