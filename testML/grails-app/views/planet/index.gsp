
<%@ page import="com.testML.Planet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'planet.label', default: 'Planet')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-planet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-planet" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'planet.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="coord" title="${message(code: 'planet.coord.label', default: 'Coord')}" />
					
						<g:sortableColumn property="sunDistance" title="${message(code: 'planet.sunDistance.label', default: 'Sun Distance')}" />
					
						<g:sortableColumn property="velAng" title="${message(code: 'planet.velAng.label', default: 'Vel Ang')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${planetInstanceList}" status="i" var="planetInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${planetInstance.id}">${fieldValue(bean: planetInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: planetInstance, field: "coord")}</td>
					
						<td>${fieldValue(bean: planetInstance, field: "sunDistance")}</td>
					
						<td>${fieldValue(bean: planetInstance, field: "velAng")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${planetInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
