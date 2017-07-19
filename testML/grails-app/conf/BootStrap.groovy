import com.testML.Planet
import com.testML.Weather
import com.testML.geom.StraighLine
import com.testML.geom.Triangle
import com.testML.model.Galaxy;

import java.awt.geom.Point2D

class BootStrap {
	
	def reportService

    def init = { servletContext ->
		try {

			Galaxy galaxia = new Galaxy();
			
			reportService.setGalaxy(galaxia);
			reportService.predictXXYears(10);

		} catch(Exception e) {
			println "error"
			e.printStackTrace();
		}
    }
    def destroy = {
    }
}
