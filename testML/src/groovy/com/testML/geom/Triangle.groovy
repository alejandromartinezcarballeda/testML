package com.testML.geom

import com.testML.Planet

import java.awt.Polygon
import java.awt.Rectangle
import java.awt.geom.Area
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zale
 *
 */
public class Triangle {

	List<Planet> planets
	Path2D.Double trianglePath
	Area triangleArea

	/**
	 * @param planets
	 */
	public Triangle(List<Planet> planets) {
		
		this.planets = planets
		trianglePath = new Path2D.Double();
		
		trianglePath.moveTo(
			planets.get(0).getCoord().getX(), 
			planets.get(0).getCoord().getY());
		
		trianglePath.lineTo(
			planets.get(1).getCoord().getX(),
			planets.get(1).getCoord().getY());
		
		trianglePath.lineTo(
			planets.get(2).getCoord().getX(),
			planets.get(2).getCoord().getY());
		
		trianglePath.closePath();
		triangleArea = new Area(trianglePath);
		
	}
	
	
	public boolean isSunInsideTriangle(Point2D.Double pointToEvaluate){
		return triangleArea.contains(pointToEvaluate);
	}
	
	
	/**
	 * 
	 * if
	 * 
	 * @return double
	 */
	public double getPerimeter() {
		
		double perimeter = 0d
		for (int i=0;i < planets.size()-1;i++){
			perimeter += planets.get(i).getCoord().distance(planets.get(i+1).getCoord());
		}
		
		return perimeter;
	}
	
	
}