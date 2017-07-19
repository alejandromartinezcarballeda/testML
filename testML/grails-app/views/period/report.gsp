
<%@ page import="com.testML.Period" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'period.label', default: 'Period')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<style>
			#list-period{
				margin-left : 80px;
			}
			#list-period ul{
				margin-left : 40px;
			}
		</style>
	</head>
	<body>
		<a href="#list-period" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

		<div id="list-period" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<h3>Quantity of dry periods: ${cantDry}</h3><br/>
			<h3>Quantity of optimal periods: ${cantOptimal.size()}</h3><br/>
			<h3>Quantity of rain periods: ${listOfRainWeather.size()}</h3><br/>
			
			<h3>Max intensity of each rainy period:</h3>

<%--			<g:set var="dayMaxRainIntensity" value="" />--%>

			<ul>
				<g:each in="${listOfRainWeather}" status="i" var="rainPeriod">
<%--					<g:if test="${maxRainIntensity == rainPeriod.rainIntensity}">--%>
<%--						<g:set var="dayMaxRainIntensity" value="${rainPeriod.day}" />--%>
<%--					</g:if>--%>
<%--					<li><g:formatNumber number="${rainPeriod.rainIntensity}" type="number" maxFractionDigits="4" /> at day ${rainPeriod.day}</li>--%>
					<li>${rainPeriod.rainIntensity} at day ${rainPeriod.day}</li>
				</g:each>
			</ul><br/>
			<h3>Max intensity of all rainy periods: </h3>
				<p>
				<g:each in="${listOfDaysWithMaxRainIntensity}" status="i" var="dayMaxRainIntensity">
					${maxRainIntensity} at day ${dayMaxRainIntensity.day}
				</g:each>
				</p>
		</div>
	</body>
</html>
