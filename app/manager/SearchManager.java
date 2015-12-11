package manager;

import java.util.List;
import util.ReportType;
import com.google.inject.Inject;
import dao.AirportDAO;
import models.Airport;
import models.Runway;

public class SearchManager {
	@Inject
	private AirportDAO airportDAO;
	
	public List<Runway>  intitializeQuery(String countryName, String countryCode) {
		List<Runway>  result = airportDAO.searchRunway(countryName,countryCode);
		return result;
	}

	public List<Airport> getReport(ReportType queryType) {
		List<Airport>  result = airportDAO.getReport(queryType);
		return result;
	}
	public List<Airport> getReport() {
		List<Airport>  result = airportDAO.getReport();
		return result;
	}
	
}
