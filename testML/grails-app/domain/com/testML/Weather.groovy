package com.testML

import grails.rest.Resource

@Resource(uri='/weather')
class Weather {
	
	private Integer day
	private Double rainIntensity
	private String weatherCondition
	
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Double getRainIntensity() {
		return rainIntensity;
	}
	public void setRainIntensity(Double rainIntensity) {
		this.rainIntensity = rainIntensity;
	}
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	
	

	public Weather(){}
	
	public Weather(String weatherCondition, double rainIntensity){

		this.rainIntensity = rainIntensity;
		this.weatherCondition = weatherCondition;
	}
	
	public Weather(int day, String weatherCondition, double rainIntensity){
		this.day = day;
		this.rainIntensity = rainIntensity;
		this.weatherCondition = weatherCondition;
	}

}
