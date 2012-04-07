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

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	String titleXml = LocalizationUtil.getLocalizationXmlFromPreferences(preferences, renderRequest, "title");
	String descriptionXml = LocalizationUtil.getLocalizationXmlFromPreferences(preferences, renderRequest, "description");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" cssClass="lmsConfiguration">
	
	<aui:select label="id" name='exam_config_id'>
		<aui:option selected='<%= true %>' value="text"><liferay-ui:message key="new" /></aui:option>
		<aui:option selected='<%= false %>' value="1">1</aui:option>
		<aui:option selected='<%= false %>' value="2">2</aui:option>
	</aui:select>

	<liferay-ui:panel collapsible="<%= false %>" extended="<%= true %>" id="exam_fields" persistState="<%= true %>" title="form-fields">
		<aui:fieldset cssClass="rows-container examPages">
		
			<div>
				<aui:input name="title" type="text" value="" />
				<aui:input name="key" type="text" value="" />
				<div style="clear:both;"></div><!-- TODO: ezeket kiszedni -->
			</div>
		
			<%
				// TODO: valódi content indexek
				int[] formFieldsIndexes = new int[3];
				formFieldsIndexes[0] = 0;
				formFieldsIndexes[1] = 1;
				formFieldsIndexes[2] = 2;

				int index = 1;
				for (int formFieldsIndex : formFieldsIndexes) {
					request.setAttribute("configuration.jsp-pageindex", String.valueOf(index));
					%>
					
					<div class="lfr-form-row" id="<portlet:namespace/>fieldset<%=index%>">
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
		<aui:input type="checkbox" name="generate_evaluation_logic" label="autogenerate-code"/>
		<aui:button type="submit" /> 
	</aui:button-row>
</aui:form>



<aui:script use="aui-base,liferay-auto-fields">
	var examPages = A.one('.examPages');

	<liferay-portlet:renderURL portletConfiguration="true" var="editFieldURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
	</liferay-portlet:renderURL>
	
	window.myautofields = new Liferay.AutoFields(
		{
			contentBox: examPages,
			fieldIndexes: '<portlet:namespace />pageFieldIndexes',
			sortable: true,
			sortableHandle: '.field-label',
			url: '<%= editFieldURL %>'
		}
	).render();

</aui:script>

