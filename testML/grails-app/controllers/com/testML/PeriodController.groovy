package com.testML



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PeriodController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Period.list(params), model:[periodInstanceCount: Period.count()]
    }

    def show(Period periodInstance) {
        respond periodInstance
    }

    def create() {
        respond new Period(params)
    }

    @Transactional
    def save(Period periodInstance) {
        if (periodInstance == null) {
            notFound()
            return
        }

        if (periodInstance.hasErrors()) {
            respond periodInstance.errors, view:'create'
            return
        }

        periodInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'period.label', default: 'Period'), periodInstance.id])
                redirect periodInstance
            }
            '*' { respond periodInstance, [status: CREATED] }
        }
    }
	
	
	def report(){
		
		def listOfDryWeather = Period.createCriteria().list(){
			eq("weatherCondition","dry");
		}

		def listOfOptimalWeather = Period.createCriteria().list(){
			eq("weatherCondition","optimal");
		}

		def listOfRainWeather = Period.createCriteria().list(){
			eq("weatherCondition","rain")
			order("day", "asc")
			
		}
		
		def maxRainIntensity = Period.createCriteria().get {
		    projections {
		        max "rainIntensity"
		    }
		}

		def listOfDaysWithMaxRainIntensity = Period.createCriteria().list(){
			eq("rainIntensity",maxRainIntensity)
			order("day", "asc")
		}

		render(view: "report", model:["cantDry":listOfDryWeather.size(),
			"cantOptimal":listOfOptimalWeather,
			"listOfRainWeather":listOfRainWeather,
			"maxRainIntensity": maxRainIntensity,
			"listOfDaysWithMaxRainIntensity":listOfDaysWithMaxRainIntensity])
		
	}
	
	
	
	
	
	

    def edit(Period periodInstance) {
        respond periodInstance
    }

    @Transactional
    def update(Period periodInstance) {
        if (periodInstance == null) {
            notFound()
            return
        }

        if (periodInstance.hasErrors()) {
            respond periodInstance.errors, view:'edit'
            return
        }

        periodInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Period.label', default: 'Period'), periodInstance.id])
                redirect periodInstance
            }
            '*'{ respond periodInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Period periodInstance) {

        if (periodInstance == null) {
            notFound()
            return
        }

        periodInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Period.label', default: 'Period'), periodInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'period.label', default: 'Period'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
