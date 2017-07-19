package com.testML

import static org.springframework.http.HttpStatus.*

import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.java.util.jar.pack.Package.Class.Method;

import grails.converters.JSON
import grails.rest.RestfulController
import grails.transaction.Transactional


@Transactional(readOnly = true)
class WeatherController extends RestfulController{

	static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Weather.list(params), model:[weatherInstanceCount: Weather.count()]
    }

	
    def show(Weather weatherInstance) {
		println weatherInstance
        respond weatherInstance
    }

	def getWeatherByDay(int day){
		def w = Weather.findByDay(day)
		render w as JSON
	}
	
	
    def create() {
        respond new Weather(params)
    }
	
    @Transactional
    def save(Weather weatherInstance) {
        if (weatherInstance == null) {
            notFound()
            return
        }

        if (weatherInstance.hasErrors()) {
            respond weatherInstance.errors, view:'create'
            return
        }

        weatherInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'weather.label', default: 'Weather'), weatherInstance.id])
                redirect weatherInstance
            }
            '*' { respond weatherInstance, [status: CREATED] }
        }
    }

    def edit(Weather weatherInstance) {
        respond weatherInstance
    }

    @Transactional
    def update(Weather weatherInstance) {
        if (weatherInstance == null) {
            notFound()
            return
        }

        if (weatherInstance.hasErrors()) {
            respond weatherInstance.errors, view:'edit'
            return
        }

        weatherInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Weather.label', default: 'Weather'), weatherInstance.id])
                redirect weatherInstance
            }
            '*'{ respond weatherInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Weather weatherInstance) {

        if (weatherInstance == null) {
            notFound()
            return
        }

        weatherInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Weather.label', default: 'Weather'), weatherInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'weather.label', default: 'Weather'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
