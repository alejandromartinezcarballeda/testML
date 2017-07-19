package com.testML.model;

public enum WeatherType {
	
	RAIN("rain"),DRY("dry"),OPTIMAL("optimal"),NONE("none");
	
	String weather;
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	WeatherType(String weather){
		this.weather = weather;
	}
	
	

}
