package com.testML.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import com.testML.Planet;
import com.testML.Weather;
import com.testML.utils.weather.WeatherUtil;


public class Galaxy {
	
	Planet ferengi = new Planet("Ferengi",1,500);
	
	Planet vulcano = new Planet ("Vulcano",-5,1000);
	
	Planet betasoide = new Planet ("Betasoide",3,2000);
	
	private List<Planet> planets = new ArrayList<Planet>();
	
	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	Point2D.Double SUN = new Point2D.Double(0,0);
	
	public Galaxy (){
		planets.add(ferengi);
		planets.add(vulcano);
		planets.add(betasoide);
	}
	
//	Galaxy (List<Planet> planets) {
//		this.planets = planets;
//	}
	
	public void moveGalaxy(int days){
		for (Planet planet: planets) {
			planet.movePlanet(days);
		}
	}
	
	public Weather getWeather(int day){
		
		String weather = "none";
		
		double rainIntensity = 0d;
		if (WeatherUtil.isRainyWeather(planets)){
			weather = "rain";
			rainIntensity = WeatherUtil.getRainIntensity(planets);
		}
		
		if (WeatherUtil.isDryWeather(planets)){
			weather = "dry";
		}

		if (WeatherUtil.isOptimalCondWeather(planets)){
			weather = "optimal";
		}
		return new Weather(day, weather, rainIntensity);
	}
	
	

}
