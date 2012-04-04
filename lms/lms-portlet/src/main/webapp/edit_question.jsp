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
		int parentPageIndex = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-index"))); 
		int index = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-questionindex"))); 
	%>

	<div class="field-title">
		<span class="field-label">Question <%=index%> of <%= parentPageIndex %></span>
	</div>
	
	<div id="examQuestion<%=index%>">
		<aui:fieldset cssClass="rows-container examQuestion">
		
			<div>
				<aui:input name="title" type="text" value="" />
				<aui:input name="key" type="text" value="" />
				<div style="clear:both;"></div>
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
					%>
					
					<div class="lfr-form-row" id="<portlet:namespace/>fieldset<%=answerFieldIndex%>">
						<div class="row-fields">
							<div class="field-title">
								<span class="field-label">Answer <%=answerIndex%></span>
							</div>
							<div>
								<aui:input name="title" type="text" value="" />
								<aui:input name="key" type="text" value="" />
								<div style="clear:both;"></div>
							</div>
							<br/>
							<br/>						
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
	var examQuestion = A.one('#examPage<%=parentPageIndex%> #examQuestion<%=index%>');
	
	<liferay-portlet:renderURL portletConfiguration="true" var="editPageURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="<%= Constants.CMD %>" value="add_answer" /> <!-- TODO: ExamConstants-ba kivinni -->
	</liferay-portlet:renderURL>
	
	new Liferay.AutoFields(
		{
			contentBox: examQuestion,
			fieldIndexes: '<portlet:namespace />questionFieldIndexes',
			sortable: true,
			sortableHandle: '.field-label',
			url: '<%= editPageURL %>'
		}
	).render();
</aui:script>
