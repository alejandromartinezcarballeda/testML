package com.testML.utils.weather

import com.testML.Planet
import com.testML.geom.StraighLine;
import com.testML.geom.Triangle;
import java.awt.geom.Point2D

class WeatherUtil {
	
	private static Triangle triangle;
	private static StraighLine straighLine;
	private static Point2D.Double SUN = new Point2D.Double(0,0);
	
	public static boolean isDryWeather(List<Planet> planets) {
		
		straighLine = new StraighLine(planets);
		// agregar constantes
		if (straighLine.areThreePlanetsAligned() && straighLine.isSunAligned(SUN) ){
			return true;
		}
		return false;
		
	}
	
	public static boolean isRainyWeather(List<Planet> planets){
		triangle = new Triangle(planets);
		// as when 4 points are aligned, the sun is still considered to be inside the triangle, dry weather it can not be a rainy weather
		if (isDryWeather(planets)){
			return false;
		}
		return triangle.isSunInsideTriangle(SUN);
	}
	
	public static double getRainIntensity(List<Planet> planets){
		triangle = new Triangle(planets);
		return triangle.getPerimeter();
	}
	
	public static boolean isOptimalCondWeather(List<Planet> planets){
		straighLine = new StraighLine(planets);
		if (straighLine.areThreePlanetsAligned() && !straighLine.isSunAligned(SUN) ){
			return true;
		}
		return false;
	}
	
	

}
