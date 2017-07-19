<%@ page import="com.testML.Weather" %>



<div class="fieldcontain ${hasErrors(bean: weatherInstance, field: 'day', 'error')} required">
	<label for="day">
		<g:message code="weather.day.label" default="Day" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="day" type="number" value="${weatherInstance.day}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: weatherInstance, field: 'rainIntensity', 'error')} required">
	<label for="rainIntensity">
		<g:message code="weather.rainIntensity.label" default="Rain Intensity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rainIntensity" type="number" value="${weatherInstance.rainIntensity}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: weatherInstance, field: 'weatherCondition', 'error')} required">
	<label for="weatherCondition">
		<g:message code="weather.weatherCondition.label" default="Weather Condition" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="weatherCondition" required="" value="${weatherInstance?.weatherCondition}"/>

</div>

