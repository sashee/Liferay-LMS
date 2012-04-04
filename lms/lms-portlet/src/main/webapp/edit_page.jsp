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
		int index = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute("configuration.jsp-index"))); 
	%>

	<div class="field-title">
		<span class="field-label">Page <%=index%></span>
	</div>
	
	<div id="examPage<%=index%>"> <!-- TODO: id beállítása hasonlóan a fieldsethez -->
		<aui:fieldset cssClass="rows-container examPage">
		
			<div>
				<aui:input name="title" type="text" value="" />
				<aui:input name="key" type="text" value="" />
				<div style="clear:both;"></div>
			</div>
		
			<%
				// TODO: valódi content indexek
				int[] questionFieldIndexes = new int[3];
				questionFieldIndexes[0] = 0;
				questionFieldIndexes[1] = 1;
				questionFieldIndexes[2] = 2;
	
				int questionIndex = 1;
				for (int questionFieldIndex : questionFieldIndexes) {
					request.setAttribute("configuration.jsp-questionindex", String.valueOf(questionIndex));
					request.setAttribute("configuration.jsp-questionFieldIndex", String.valueOf(questionFieldIndex));
					%>
					
					<div class="lfr-form-row" id="<portlet:namespace/>fieldset<%=questionFieldIndex%>">
						<div class="row-fields">
							<liferay-util:include page="/edit_question.jsp" servletContext="<%= application %>" />
						</div>
					</div>
					
					<%
					questionIndex++;
				}
				%>
		</aui:fieldset>
		<br/>
		<br/>
		<br/>
	</div>
	
	
</div>


<aui:script use="aui-base,liferay-auto-fields">
	var examPage = A.one('#examPage<%=index%>');
	
	<liferay-portlet:renderURL portletConfiguration="true" var="editPageURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="<%= Constants.CMD %>" value="add_question" /> <!-- TODO: ExamConstants-ba kivinni -->
	</liferay-portlet:renderURL>
	
	new Liferay.AutoFields(
		{
			contentBox: examPage,
			fieldIndexes: '<portlet:namespace />answerFieldIndexes',
			sortable: true,
			sortableHandle: '.field-label',
			url: '<%= editPageURL %>'
		}
	).render();
</aui:script>
