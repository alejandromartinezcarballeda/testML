package com.testML

import java.awt.geom.Point2D

class Planet {
	
	// is it necesary for planet to be a domain class ?
	
	private String name
	private Integer velAng
	private Integer anglePosition
	private Integer sunDistance
	private Point2D.Double coord
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVelAng() {
		return velAng;
	}

	public void setVelAng(Integer velAng) {
		this.velAng = velAng;
	}

	public Integer getSunDistance() {
		return sunDistance;
	}

	public void setSunDistance(Integer sunDistance) {
		this.sunDistance = sunDistance;
	}

	public Point2D.Double getCoord() {
		return coord;
	}

	public void setCoord(Point2D.Double coord) {
		this.coord = coord;
	}
	
	

	Planet (name, velAng, sunDistance){
		this.name = name
		this.velAng = velAng
		this.sunDistance = sunDistance
		this.anglePosition = 0;
		// asuming planets "starts" on value 0 of y axis
		setCoord(new Point2D.Double(0, sunDistance));
	}
	
	// return new position ?
	public void movePlanet(int days){
		
		//anglePosition = anglePosition + (velAng * days)
		anglePosition = (velAng * days)
		// move planet and update its position
		double positionX = Math.cos(Math.toRadians(anglePosition)) * sunDistance
		double positionY = Math.sin(Math.toRadians(anglePosition)) * sunDistance
		
		setCoord(new Point2D.Double(positionX, positionY));
		
		//System.out.println(toString());
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + " is on position: ");
		sb.append("\nX: " + getCoord().getX());
		sb.append("\nY: " + getCoord().getY());
		sb.append("\nAngle: "+ this.anglePosition);
		sb.append("\n");
	}

	static constraints = {
		coord (nullable:true)
		name (nullable:false)
		
		
    }
}