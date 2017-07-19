<%@ page import="com.testML.Period" %>



<div class="fieldcontain ${hasErrors(bean: periodInstance, field: 'day', 'error')} required">
	<label for="day">
		<g:message code="period.day.label" default="Day" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="day" type="number" value="${periodInstance.day}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: periodInstance, field: 'periodType', 'error')} required">
	<label for="periodType">
		<g:message code="period.periodType.label" default="Period Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="periodType" required="" value="${periodInstance?.periodType}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: periodInstance, field: 'rainIntensity', 'error')} required">
	<label for="rainIntensity">
		<g:message code="period.rainIntensity.label" default="Rain Intensity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rainIntensity" value="${fieldValue(bean: periodInstance, field: 'rainIntensity')}" required=""/>

</div>

