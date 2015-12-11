package controllers;

import java.util.List;
import manager.IntializationManager;
import manager.SearchManager;
import models.Airport;
import models.Runway;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.ReportType;
import views.html.index;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;

public class Application extends Controller {
	
@Inject 
private  IntializationManager  initializationManager;
@Inject 
private  SearchManager  searchManager;
	
    public Result index() {
    	return ok(index.render("Your new application is ready."));
    }
    
    @Transactional
	public Result initializeDB(){
		initializationManager.initializeData();
		return ok();
	}
    @Transactional
    public Result countryQuery(String countryName,String countryCode){
    	List<Runway>  hits = searchManager.intitializeQuery(countryName,countryCode);
		JsonNode json;
		json = Json.toJson(hits);
		Result jsonResult = ok(json);
		return jsonResult;
	}
    
    @Transactional
    public Result report(String queryType){
    	ReportType e = ReportType.valueOf(queryType);
    	List<Airport>  hits = searchManager.getReport(e);
		JsonNode json;
		json = Json.toJson(hits);
		Result jsonResult = ok(json);
		return jsonResult;

	}
    @Transactional
    public Result reports(){
    	
    	List<Airport>  hits = searchManager.getReport();
		JsonNode json;
		json = Json.toJson(hits);
		Result jsonResult = ok(json);
		return jsonResult;

	}
    
    

}
