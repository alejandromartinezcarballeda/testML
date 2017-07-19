class UrlMappings {

	static mappings = {
		
		
		
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"application")
        "500"(view:'/error')
		
		"/weather/$day?"(controller:"weather", method:"GET", action:"getWeatherByDay")
	}
}
