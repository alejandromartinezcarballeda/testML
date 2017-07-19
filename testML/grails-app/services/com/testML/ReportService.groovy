package com.testML

import grails.transaction.Transactional

import com.testML.model.Galaxy;
import com.testML.model.WeatherType;
import com.testML.utils.weather.WeatherUtil

@Transactional
class ReportService {
	
    private Galaxy galaxia;
	
	public Galaxy getGalaxy() {
		return galaxia;
	}

	public void setGalaxy(Galaxy galaxia) {
		this.galaxia = galaxia;
	}
	
	public GalaxyService(){	}

	public GalaxyService(Galaxy galaxia){
		this.galaxia = galaxia
	}
	
	
	
	/**
	 * 
	 * Saves Periods and Weather for the quantity of years @param specified
	 * 
	 * @param years quantity of years to predict
	 */
	public void predictXXYears(int years){
		
		int XX_YEARS = 365 * years;
		Period period;

		String lastWeatherCond = "";
		double maxRainIntensity = 0d;
		int dayMaxRainIntensity = 0;

		// not necesary to execute
		if (Weather.count() > 0){
		   return;
	    }
		
		println "creates period";
		
		
		for (int i= 0; i<= XX_YEARS ; i++) {

			galaxia.moveGalaxy(i);
			Weather weather = galaxia.getWeather(i);
			weather.save();

			if (!weather.getWeatherCondition().equals(lastWeatherCond)){
				
				if (!weather.getWeatherCondition().equals(WeatherType.RAIN.getWeather())){
				
					period = new Period(weather.getDay(),weather.getWeatherCondition(), weather.getRainIntensity());
					period.save();
					
					if (lastWeatherCond.equals(WeatherType.RAIN.getWeather())){
						println "creates period";
						period = new Period(dayMaxRainIntensity,WeatherType.RAIN.getWeather(), maxRainIntensity);
						period.save();
						maxRainIntensity = 0d;
					}
					
					lastWeatherCond = weather.getWeatherCondition();
					
				} else {
				
					if (maxRainIntensity < weather.getRainIntensity()){
						maxRainIntensity = weather.getRainIntensity();
						dayMaxRainIntensity = weather.getDay();
					}
					lastWeatherCond = WeatherType.RAIN.getWeather();
				
				}
				
			} else {
			
				if (maxRainIntensity < weather.getRainIntensity()){
					maxRainIntensity = weather.getRainIntensity();
					dayMaxRainIntensity = weather.getDay();
				}
			
			}
		}

	}

	
}
