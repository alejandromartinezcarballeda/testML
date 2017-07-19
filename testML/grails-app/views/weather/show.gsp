
<%@ page import="com.testML.Weather" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'weather.label', default: 'Weather')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-weather" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-weather" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list weather">
			
				<g:if test="${weatherInstance?.day}">
				<li class="fieldcontain">
					<span id="day-label" class="property-label"><g:message code="weather.day.label" default="Day" /></span>
					
						<span class="property-value" aria-labelledby="day-label"><g:fieldValue bean="${weatherInstance}" field="day"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${weatherInstance?.rainIntensity}">
				<li class="fieldcontain">
					<span id="rainIntensity-label" class="property-label"><g:message code="weather.rainIntensity.label" default="Rain Intensity" /></span>
					
						<span class="property-value" aria-labelledby="rainIntensity-label"><g:fieldValue bean="${weatherInstance}" field="rainIntensity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${weatherInstance?.weatherCondition}">
				<li class="fieldcontain">
					<span id="weatherCondition-label" class="property-label"><g:message code="weather.weatherCondition.label" default="Weather Condition" /></span>
					
						<span class="property-value" aria-labelledby="weatherCondition-label"><g:fieldValue bean="${weatherInstance}" field="weatherCondition"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:weatherInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${weatherInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
