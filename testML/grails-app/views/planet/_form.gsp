<%@ page import="com.testML.Planet" %>



<div class="fieldcontain ${hasErrors(bean: planetInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="planet.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${planetInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: planetInstance, field: 'coord', 'error')} required">
	<label for="coord">
		<g:message code="planet.coord.label" default="Coord" />
		<span class="required-indicator">*</span>
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: planetInstance, field: 'sunDistance', 'error')} required">
	<label for="sunDistance">
		<g:message code="planet.sunDistance.label" default="Sun Distance" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="sunDistance" type="number" value="${planetInstance.sunDistance}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: planetInstance, field: 'velAng', 'error')} required">
	<label for="velAng">
		<g:message code="planet.velAng.label" default="Vel Ang" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="velAng" type="number" value="${planetInstance.velAng}" required=""/>

</div>

