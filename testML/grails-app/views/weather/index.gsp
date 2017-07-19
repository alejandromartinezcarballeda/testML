
<%@ page import="com.testML.Weather" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'weather.label', default: 'Weather')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-weather" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-weather" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="day" title="${message(code: 'weather.day.label', default: 'Day')}" />
					
						<g:sortableColumn property="rainIntensity" title="${message(code: 'weather.rainIntensity.label', default: 'Rain Intensity')}" />
					
						<g:sortableColumn property="weatherCondition" title="${message(code: 'weather.weatherCondition.label', default: 'Weather Condition')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${weatherInstanceList}" status="i" var="weatherInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${weatherInstance.id}">${fieldValue(bean: weatherInstance, field: "day")}</g:link></td>
					
						<td>${fieldValue(bean: weatherInstance, field: "rainIntensity")}</td>
					
						<td>${fieldValue(bean: weatherInstance, field: "weatherCondition")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${weatherInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
