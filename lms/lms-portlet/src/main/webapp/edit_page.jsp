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
		int pageIndex = ParamUtil.getInteger(renderRequest, "index", GetterUtil.getInteger((String)request.getAttribute(JspConstants.RA_CONFIGURATION_JSP_PAGEINDEX)));
	%>

	<div class="field-title">
<%-- 		<span class="field-label">Page <%=pageIndex%></span> --%>
		<span class="field-label"><liferay-ui:message key="exam-page" /></span>
	</div>
	
	<aui:input type="hidden" name='<%= "_field" + pageIndex %>' />
	
	<div id="examPage<%=pageIndex%>">
		<aui:fieldset cssClass="rows-container examPage">
		
			<div class="dummyContainer">
				<aui:input name="questionsetdummy" type="text" value="" />
				<div style="clear:both;"></div>
			</div>
		
			<%
						ExamTest examConfigIds = (ExamTest)request.getAttribute(JspConstants.RA_CONFIGURATION_SELECTED_EXAM_TEST);
							Set<String> questionKeys = new HashSet<String>();
							Map<String, ? extends List<String>> questions = new HashMap<String, List<String>>();
							
							if (examConfigIds != null) {
								questions = examConfigIds.tests.get(pageIndex + "");
								if (questions != null) {
									questionKeys = questions.keySet();
								}
							}
						
							
							int questionIndex = 1;
							
							if (!questionKeys.isEmpty()) {
								for (String questionKey : questionKeys) {
									request.setAttribute(JspConstants.RA_CONFIGURATION_JSP_QUESTIONINDEX, String.valueOf(questionIndex));
									request.setAttribute(JspConstants.RA_CONFIGURATION_JSP_QUESTIONDATA, questions.get(questionKey));
					%>
						
						<div class="lfr-form-row" id="<portlet:namespace/>questionfieldset<%=questionIndex%>">
							<div class="row-fields">
								<liferay-util:include page="/edit_question.jsp" servletContext="<%= application %>" />
							</div>
						</div>
						
						<%
													questionIndex++;
															}
														} else {
															request.setAttribute(JspConstants.RA_CONFIGURATION_JSP_QUESTIONINDEX, String.valueOf(questionIndex));
												%>
					
					<div class="lfr-form-row" id="<portlet:namespace/>questionfieldset<%=questionIndex%>">
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
	</div>
</div>


<aui:script use="aui-base,liferay-auto-fields">
	var examPage = A.one('#examPage<%=pageIndex%>');
	
	<%
	String pageIndexString = pageIndex + "";
%>
	
	<liferay-portlet:renderURL portletConfiguration="true" var="editPageURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="<%= Constants.CMD %>" value="<%= JspConstants.CMD_ADD_QUESTION %>" />
		<portlet:param name="<%= JspConstants.CP_PAGE_INDEX %>" value="<%= pageIndexString %>" />
	</liferay-portlet:renderURL>
	
	new Liferay.AutoFields(
		{
			contentBox: examPage,
			fieldIndexes: '<portlet:namespace /><%=JspConstants.getQuestionFieldIndexName(pageIndex)%>',
			sortable: true,
			sortableHandle: '.field-label',
			url: '<%= editPageURL %>'
		}
	).render();
</aui:script>
