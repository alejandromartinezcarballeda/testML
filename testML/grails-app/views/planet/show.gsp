
<%@ page import="com.testML.Planet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'planet.label', default: 'Planet')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-planet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-planet" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list planet">
			
				<g:if test="${planetInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="planet.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${planetInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${planetInstance?.coord}">
				<li class="fieldcontain">
					<span id="coord-label" class="property-label"><g:message code="planet.coord.label" default="Coord" /></span>
					
						<span class="property-value" aria-labelledby="coord-label"><g:fieldValue bean="${planetInstance}" field="coord"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${planetInstance?.sunDistance}">
				<li class="fieldcontain">
					<span id="sunDistance-label" class="property-label"><g:message code="planet.sunDistance.label" default="Sun Distance" /></span>
					
						<span class="property-value" aria-labelledby="sunDistance-label"><g:fieldValue bean="${planetInstance}" field="sunDistance"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${planetInstance?.velAng}">
				<li class="fieldcontain">
					<span id="velAng-label" class="property-label"><g:message code="planet.velAng.label" default="Vel Ang" /></span>
					
						<span class="property-value" aria-labelledby="velAng-label"><g:fieldValue bean="${planetInstance}" field="velAng"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:planetInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${planetInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
