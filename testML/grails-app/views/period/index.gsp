
<%@ page import="com.testML.Period" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'period.label', default: 'Period')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-period" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-period" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			
		
			
			
			
			
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="day" title="${message(code: 'period.day.label', default: 'Day')}" />
					
						<g:sortableColumn property="periodType" title="${message(code: 'period.periodType.label', default: 'Period Type')}" />
					
						<g:sortableColumn property="rainIntensity" title="${message(code: 'period.rainIntensity.label', default: 'Rain Intensity')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${periodInstanceList}" status="i" var="periodInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${periodInstance.id}">${fieldValue(bean: periodInstance, field: "day")}</g:link></td>
					
						<td>${fieldValue(bean: periodInstance, field: "periodType")}</td>
					
						<td>${fieldValue(bean: periodInstance, field: "rainIntensity")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${periodInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
