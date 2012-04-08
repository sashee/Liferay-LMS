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

<%@ include file="/init.jsp" %>

<div class="aui-field-row field-row">

	<% 
		int parentPageIndex = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-pageindex"))); 
		
		int questionIndex = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-questionindex"))); 
		int questionIndexParam = GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-questionindex"));
		
		if (questionIndexParam != 0) {
			questionIndex = questionIndexParam;
		}
		
		if (request.getAttribute("lms-page-index-param") != null && !((String)request.getAttribute("lms-page-index-param")).isEmpty()) {
			parentPageIndex = GetterUtil.getInteger((String)request.getAttribute("lms-page-index-param"));
		}
		
		String fieldIdSuffix = "_p" + parentPageIndex + "_q" + questionIndex;
	%>

	<div class="field-title">
		<span class="field-label">Question <%=questionIndex%> of <%= parentPageIndex %></span>
	</div>
	
	<aui:input type="hidden" name='<%= "_field" + questionIndex %>' />
	
	<div id="examQuestion<%=questionIndex%>">
		<aui:fieldset cssClass="rows-container examQuestion">
		
			<div>
				<aui:input label="title" name='<%= "title" + fieldIdSuffix %>' type="text" value="" />
				<aui:input label="key" name='<%= "key" + fieldIdSuffix %>' type="text" value="" />
				<div style="clear:both;"></div>
				<aui:select label="type" name='<%= "type" + fieldIdSuffix %>'>
					<aui:option selected='<%= true %>' value="text"><liferay-ui:message key="text" /></aui:option>
					<aui:option selected='<%= false %>' value="checkbox"><liferay-ui:message key="checkbox" /></aui:option>
					<aui:option selected='<%= false %>' value="radio"><liferay-ui:message key="radio" /></aui:option>
				</aui:select>
				<aui:input label="answer" name='<%= "answer" + fieldIdSuffix %>' type="text" value="" />
				<aui:input label="point" name='<%= "point" + fieldIdSuffix %>' type="text" value="" />
				<div style="clear: both;"></div>
			</div>
		
			<%
				// TODO: valódi content indexek
				int[] answerFieldIndexes = new int[3];
				answerFieldIndexes[0] = 0;
				answerFieldIndexes[1] = 1;
				answerFieldIndexes[2] = 2;
	
				int answerIndex = 1;
				for (int answerFieldIndex : answerFieldIndexes) {
					request.setAttribute("configuration.jsp-answerindex", String.valueOf(answerIndex));
					request.setAttribute("configuration.jsp-answerFieldIndex", String.valueOf(answerFieldIndex));
					
					String answerFieldIdSuffix = "_a" + answerIndex + "_p" + parentPageIndex + "_q" + questionIndex;
					%>
					
					<div class="lfr-form-row" id="<portlet:namespace/>answerfieldset<%=answerFieldIndex%>">
						<div class="row-fields">
							<div class="field-title">
								<span class="field-label">Answer <%=answerIndex%> of Question <%=questionIndex%> of <%= parentPageIndex %></span>
							</div>
							<aui:input type="hidden" name='<%= "_field" + answerIndex  %>' />
							<div>
								<aui:input label="title" name='<%= "title" + answerFieldIdSuffix %>' type="text" value="" />
								<aui:input label="key" name='<%= "key" + answerFieldIdSuffix %>' type="text" value="" />
								<div style="clear:both;"></div>
							</div>
						</div>
					</div>
					
					<%
					answerIndex++;
				}
				%> 
		</aui:fieldset>
		<br/>
		<br/>
	</div>
</div>


<aui:script use="aui-base,liferay-auto-fields">
	
	var examQuestion = A.one('#examPage<%=parentPageIndex%> #examQuestion<%=questionIndex%>');
	
	<% String pageIndexString = parentPageIndex + ""; %>
	<% String questionIndexString = questionIndex + ""; %>
	
	<liferay-portlet:renderURL portletConfiguration="true" var="editPageURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="<%= Constants.CMD %>" value="add_answer" /> <!-- TODO: ExamConstants-ba kivinni -->
		<portlet:param name="page-index" value="<%=pageIndexString%>" />
		<portlet:param name="question-index" value="<%=questionIndexString%>" />
	</liferay-portlet:renderURL>
	
	new Liferay.AutoFields(
		{
			contentBox: examQuestion,
			fieldIndexes: '<portlet:namespace />answerFieldIndexes_p<%=parentPageIndex%>_q<%=questionIndex%>',
			sortable: true,
			sortableHandle: '.field-label',
			url: '<%= editPageURL %>'
		}
	).render();
</aui:script>
