package com.testML



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PlanetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Planet.list(params), model:[planetInstanceCount: Planet.count()]
    }

    def show(Planet planetInstance) {
        respond planetInstance
    }

    def create() {
        respond new Planet(params)
    }

    @Transactional
    def save(Planet planetInstance) {
        if (planetInstance == null) {
            notFound()
            return
        }

        if (planetInstance.hasErrors()) {
            respond planetInstance.errors, view:'create'
            return
        }

        planetInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'planet.label', default: 'Planet'), planetInstance.id])
                redirect planetInstance
            }
            '*' { respond planetInstance, [status: CREATED] }
        }
    }

    def edit(Planet planetInstance) {
        respond planetInstance
    }

    @Transactional
    def update(Planet planetInstance) {
        if (planetInstance == null) {
            notFound()
            return
        }

        if (planetInstance.hasErrors()) {
            respond planetInstance.errors, view:'edit'
            return
        }

        planetInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Planet.label', default: 'Planet'), planetInstance.id])
                redirect planetInstance
            }
            '*'{ respond planetInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Planet planetInstance) {

        if (planetInstance == null) {
            notFound()
            return
        }

        planetInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Planet.label', default: 'Planet'), planetInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'planet.label', default: 'Planet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
