package com.testML

import com.testML.model.Galaxy

class WeatherJob {
	
	def reportService
	
    static triggers = {
      //simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    /**
     * Set galaxy to the report service and ask for the report for 10 years
     * 
     * @return
     */
    def execute() {
		
		Galaxy galaxia = new Galaxy();
		
		reportService.setGalaxy(galaxia);
		reportService.predictXXYears(10);

    }

}
