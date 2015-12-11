package manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import play.db.jpa.Transactional;
import util.CSVUtil;
import util.Converter;
import util.RefrenceFinder;
import models.Airport;
import models.BaseEntity;
import models.Country;
import models.Runway;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dao.AbstractDAO;
import dao.AirportDAO;
import dao.CountryDAO;
import dao.DAO;
import dao.RunwayDAO;

@Singleton
public class IntializationManager {
	
	@Inject
	private CountryDAO countryDAO;
	@Inject
	private AirportDAO airportDAO;
	@Inject
	private RunwayDAO runwayDAO;
	@Inject
	private CSVUtil csvUtil;
	
	@Transactional
	public void initializeData(){
		
		Map<String, Country> countriesMap = saveCountryRecords();
		saveAirportRecords(countriesMap);
		saveRunwayRecords();
	}
		
	
	private Map<String, Country> saveCountryRecords() {
//		Make a copy of country records for faster lookup
		Map<String, Country> countriesMap = new HashMap<>();
//		Read CSV file to a list of hashmap
		List<Map<String, String>> records = csvUtil.readCsv(this.getClass().getResourceAsStream("/countries.csv"));
		Converter<Country> converter = new Converter<Country>(Country.class);
		
		int i = 0;
		for(Map<String,String> record :records){
			Country entity = converter.convert(record, null);
			entity = countryDAO.create(entity);
//			Flush and clear the DAO 
			i++;
			if ((i % 1000) == 0) {
				countryDAO.flush();
				countryDAO.clear();
		    }
			countriesMap.put(entity.getCode(), entity);
		}
		return countriesMap;
	}
	
	private void saveAirportRecords(Map<String, Country> countriesMap) {
		List<Map<String, String>> records = csvUtil.readCsv(this.getClass().getResourceAsStream("/airports.csv"));
		Converter<Airport> converter = new Converter<Airport>(Airport.class);
		int i = 0;
		for(Map<String,String> record :records){
			Airport entity = converter.convert(record, new RefrenceFinder<BaseEntity>() {
				@Override
				public boolean support(String column) {
					return "iso_country".equals(column);
				}
				@Override
				public String getBeanProperty() {
					return "country";
				}
				@Override
				public BaseEntity getReference(String value) {
					if(value != null && value.trim().length() > 0){
						return countriesMap.get(value.trim());
					}
					return null;
					
				}
			});
			airportDAO.create(entity);
			i++;
			if ((i % 1000) == 0) {
				airportDAO.flush();
				airportDAO.clear();
		    }
			
		}
	}
	
	private void saveRunwayRecords() {

		List<Map<String, String>> records = csvUtil.readCsv(this.getClass().getResourceAsStream("/runways.csv"));
		Converter<Runway> converter = new Converter<Runway>(Runway.class);
		int i = 0;
		for(Map<String,String> record :records){
			Runway entity = converter.convert(record, new RefrenceFinder<BaseEntity>() {
				@Override
				public boolean support(String column) {
					return "airport_ref".equals(column);
				}
				@Override
				public String getBeanProperty() {
					return "airport";
				}
				@Override
				public BaseEntity getReference(String value) {
					if(value != null && value.trim().length() > 0){
						Airport airport = new Airport();
						airport.setId(Long.parseLong(value));
						return airport;
					}
					return null;
					
				}
			});
			runwayDAO.create(entity);
			i++;
			if ((i % 1000) == 0) {
				runwayDAO.flush();
				runwayDAO.clear();
		    }
		}
	}

	
	
	
}
