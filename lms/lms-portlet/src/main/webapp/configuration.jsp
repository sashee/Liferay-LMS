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

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<liferay-portlet:renderURL portletConfiguration="true" var="redirectAfterUrl" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
</liferay-portlet:renderURL>

<aui:form action="<%= configurationURL %>" method="post" name="fm" cssClass="lmsConfiguration">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= ConfigConstants.CMD_UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirectAfterUrl %>" />
	
	<aui:select label="exam-id" name='<%= ConfigConstants.QP_EXAM_CONFIG_ID %>'>
	
		<%
			long examConfigId = GetterUtil.getLong(request.getAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_CONFIG));
		%>
		
		<aui:option selected='<%= examConfigId == -1 %>' value="-1"><liferay-ui:message key="new-exam" /></aui:option>
		
		<%
			List<Long> examConfigIds = (List<Long>)request.getAttribute(ConfigConstants.RA_CONFIGURATION_EXAM_CONFIGS);
			for(long id : examConfigIds) {
				%>
					<aui:option selected='<%= examConfigId == id %>' value="<%= id %>"><%= id %></aui:option>
				<%
			}
		%>
	</aui:select>
	<%
		String changeSubmitScript = renderResponse.getNamespace() + "setSubmitModeAndSubmit('" + ConfigConstants.CMD_CHANGE_EXAM + "');";
	%>
	<aui:button value="exam-id-change" type="submit" name="change_exam_config" onClick='<%= changeSubmitScript %>'/> 
	<br /> <br />
	
	<liferay-ui:panel collapsible="<%= false %>" extended="<%= true %>" id="exam_fields" persistState="<%= true %>" title="exam-fields">
		<aui:fieldset cssClass="rows-container examPages">
			<div class="dummyContainer">
				<aui:input name="pagesetdummy" type="text" value="" />
				<div style="clear:both;"></div>
			</div>
		
			<%
				ExamTest examConfigIds = (ExamTest)request.getAttribute(ConfigConstants.RA_CONFIGURATION_SELECTED_EXAM_TEST);
				
				Set<String> pageKeys;
				
				if (examConfigIds != null) {
					pageKeys = examConfigIds.tests.keySet();
				} else {
					pageKeys = new HashSet<String>();
				}
			
				int index = 1;
				if (!pageKeys.isEmpty()) {
					for (String pageKey : pageKeys) {
						request.setAttribute(ConfigConstants.RA_CONFIGURATION_JSP_PAGEINDEX, String.valueOf(index));
						%>
						
						<div class="lfr-form-row" id="<portlet:namespace/>pagefieldset<%=index%>">
							<div class="row-fields">
								<liferay-util:include page="/edit_page.jsp" servletContext="<%= application %>" />
							</div>
						</div>
						
						<%
						index++;
					}
				} else {
					request.setAttribute(ConfigConstants.RA_CONFIGURATION_JSP_PAGEINDEX, String.valueOf(index));
					%>
					<div class="lfr-form-row" id="<portlet:namespace/>pagefieldset<%=index%>">
						<div class="row-fields">
							<liferay-util:include page="/edit_page.jsp" servletContext="<%= application %>" />
						</div>
					</div>
					<%
					index++;
				}
				%>
		</aui:fieldset>
	</liferay-ui:panel>
	
	<aui:button-row>
		<%
			String jsFunct = renderResponse.getNamespace() + "changeScriptBoxVisibility(this.checked);";
			String evaluatorScript = (String)request.getAttribute(ConfigConstants.RA_CONFIGURATION_JSP_EVALUATORSCRIPT);
		%>
		<aui:input type="checkbox" name="<%= ConfigConstants.QP_GENERATE_EVALUATOR_LOGIC %>" label="exam-autogenerate-code" checked="true" onClick="<%= jsFunct %>"/>
		<div id="<portlet:namespace/>evaluation_logic_script" style="display:none;" class="scriptContainer">
			<aui:input type="textarea" name="<%= ConfigConstants.QP_GENERATE_EVALUATOR_SCRIPT %>" label="exam-code" value="<%= evaluatorScript %>" />
		</div>
		<aui:button type="submit" value="exam-save" /> 
	</aui:button-row>
</aui:form>



<aui:script use="aui-base,liferay-auto-fields">
	var examPages = A.one('.examPages');

	<liferay-portlet:renderURL portletConfiguration="true" var="editFieldURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="<%= Constants.CMD %>" value="<%= ConfigConstants.CMD_ADD_PAGE %>" />
	</liferay-portlet:renderURL>
	
	new Liferay.AutoFields(
		{
			contentBox: examPages,
			fieldIndexes: '<portlet:namespace /><%= ConfigConstants.QP_PAGE_FIELD_INDEXES %>',
			sortable: true,
			sortableHandle: '.field-label',
			url: '<%= editFieldURL %>'
		}
	).render();
</aui:script>

<aui:script>
	function <portlet:namespace />setSubmitModeAndSubmit(mode) {
		if (!mode) {
			 throw "LMS Config: setSubmitModeAndSubmit, no mode set.";
		}
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = mode;
		submitForm(document.<portlet:namespace />fm, '<%= configurationURL.toString() %>');
	}
	
	function <portlet:namespace />changeScriptBoxVisibility(hide) {
		if (hide) {
			document.getElementById('<portlet:namespace/>evaluation_logic_script').style.display = "none";
		} else {
			document.getElementById('<portlet:namespace/>evaluation_logic_script').style.display = "block";
		}
	}
	
	function <portlet:namespace />foldAnswerContainer(id,hide) {
		if (hide) {
			document.getElementById(id).style.zIndex = -1;
			document.getElementById(id).style.opacity = 0;
			document.getElementById(id).style.position = "absolute";
		} else {
			document.getElementById(id).style.zIndex = 1;
			document.getElementById(id).style.opacity = 100;
			document.getElementById(id).style.position = "relative";
		}
	}
</aui:script>
