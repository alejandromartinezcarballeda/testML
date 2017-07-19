package com.testML

import grails.converters.JSON
import grails.plugin.quartz2.SimpleJobDetail
import org.quartz.JobDetail
import org.quartz.ObjectAlreadyExistsException
import org.quartz.Trigger

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.DateBuilder.IntervalUnit


class ApplicationController {

	def quartzScheduler
		
	/**
	 * Deletes all information (Weather and Periods) and schedules a Job to be executed
	 * 1 minute after the delete.
	 * 
	 * 
	 * @return
	 */
	def deleteAllWeather(){
		
		try {
			
			def allWeather = Weather.findAll();
			if (allWeather.size() > 0) {
				allWeather*.delete()
				def allPeriods = Period.findAll();
				allPeriods*.delete()
				
				// After delete is done, schedule is configured to trigger a Job
				try {
					
					Calendar fiveMinutesFuture = new GregorianCalendar();
					fiveMinutesFuture.setTime(new Date());
					fiveMinutesFuture.add(Calendar.MINUTE, 1);

					Trigger trigger = newTrigger()
						.startAt(fiveMinutesFuture.getTime())
						.build();
					
					WeatherJob.schedule(trigger)
					
				} catch(ObjectAlreadyExistsException oae){
					flash.message = "Job is already scheduled, please wait."
				}
				
				
				flash.message = "Database deleted, check list of periods or weather by day."
			} else {
				flash.message = "The database is empty, execute job now or wait for it to be executed automatically."
			}
			
		} catch(Exception e){
			println e;
		}
		redirect(controller:"application",action:"index")
	}
	
    def index() {
		
	}
	
	
	def jobToExecute(){

		// if weather count is higher than 0, then its not necesary to execute
		if (Weather.count() > 0){
		  flash.message = "The database is not empty. Please delete database before executing the job."
	    } else {
			WeatherJob.triggerNow();
			flash.message = "Job Executed! Periods and weather data are available now."
	    } 
		redirect(controller:"application",action:"index")
	}
	

}
