
<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

<%@ include file="/init.jsp"%>

<div class="aui-field-row field-row">
	<%
		int parentPageIndex = GetterUtil.getInteger((String)request.getAttribute(JspConstants.RA_PAGE_INDEX));
			int questionIndex = GetterUtil.getInteger((String)request.getAttribute(JspConstants.RA_QUESTION_INDEX));
			int answerIndex = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute(JspConstants.RA_CONFIGURATION_JSP_QUESTIONINDEX)));
	%>

	<div class="field-title">
<%-- 		<span class="field-label">Answer <%=answerIndex%> of Question <%=questionIndex%> of <%= parentPageIndex %></span> --%>
		<span class="field-label"><liferay-ui:message key="exam-answer" /></span>
	</div>
	<aui:input type="hidden" name='<%= "_field" + answerIndex  %>' />
	<div>
		<aui:input label="exam-answer-title" name='<%= JspConstants.getAnswerTitleName(parentPageIndex, questionIndex, answerIndex) %>' type="text" value="" />
		<aui:input label="exam-answer-key" name='<%= JspConstants.getAnswerKeyName(parentPageIndex, questionIndex, answerIndex) %>' type="text" value="" />
		<div style="clear: both;"></div>
	</div>
</div>



