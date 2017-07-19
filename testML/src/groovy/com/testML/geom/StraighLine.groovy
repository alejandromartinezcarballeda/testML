package com.testML.geom

import com.testML.Planet
import java.awt.geom.Line2D
import java.awt.geom.Point2D

class StraighLine {
	
	Point2D.Double p0
	Point2D.Double p1
	Point2D.Double p2
	
	Line2D.Double straighLine
	
	public StraighLine(List<Planet> planets){
		p0 = planets.get(0).getCoord();
		p1 = planets.get(1).getCoord();
		p2 = planets.get(2).getCoord();
	}
	
	public boolean areThreePlanetsAligned(){
		straighLine = new Line2D.Double(p0, p1);
		return straighLine.ptLineDist(p2) == 0d ? true: false;
	}
	
	public boolean isSunAligned(Point2D.Double sun){
		if (areThreePlanetsAligned()) {
			return straighLine.ptLineDist(sun) == 0d ? true: false;
		} else { return false; }
	}
	
	

}
