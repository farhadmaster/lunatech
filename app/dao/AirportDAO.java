package dao;

import java.util.ArrayList;
import java.util.List;
import util.ReportType;
import models.Airport;
import models.Country;
import models.Runway;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AirportDAO extends AbstractDAO<Airport> {
	@Inject
	Airport airport;
	@Inject
	Country country;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Runway> searchRunway(String countryName, String code) {
		List q = null;
		if (!code.isEmpty()) {
			q = getCurrentEntityManager()
					.createQuery(
							"SELECT r FROM Runway r JOIN r.airport a JOIN a.country c WHERE c.code = :code")
					.setParameter("code", code).getResultList();
			return q;
		} else if (!countryName.isEmpty()) {
			q = getCurrentEntityManager()
					.createQuery(
							"SELECT r FROM Runway r JOIN r.airport a JOIN a.country c WHERE c.name LIKE :name")
					.setParameter("name", countryName + "%").getResultList();
			return q;
		}
		return null;
	}
	@SuppressWarnings({ "unchecked" })
	public List<Airport> getReport(ReportType reportType) {
		if (reportType == ReportType.Type1) {
			List<Airport> q = getCurrentEntityManager()
					.createQuery(
							"SELECT a,COUNT(a) FROM Airport a JOIN  a.country c GROUP BY c.name ORDER BY COUNT(a) DESC ")
					.setMaxResults(10).getResultList();
			return q;
		}

		if (reportType == ReportType.Type2) {
			List<Airport> q = getCurrentEntityManager()
					.createQuery(
							"SELECT a,COUNT(a) FROM Airport a JOIN  a.country c GROUP BY c.name ORDER BY COUNT(a) ASC ")
					.setMaxResults(10).getResultList();
			return q;
		}
		if (reportType == ReportType.Type3) {
			List<Airport> q = getCurrentEntityManager()
					.createQuery(
							"SELECT r,COUNT(r) as cc FROM Runway r  GROUP BY r.leIdent ORDER BY COUNT(r) DESC")
					.setMaxResults(10).getResultList();
			return q;
		}
		if (reportType == ReportType.Type4) {
			List<Airport> q = getCurrentEntityManager()
					.createQuery(
							"SELECT r FROM Runway r JOIN r.airport a JOIN a.country c GROUP BY r.surface,c.name")
					.getResultList();
			return q;
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Airport> getReport() {

		List<Airport> q1 = getCurrentEntityManager()
				.createQuery(
						"SELECT a,COUNT(a) FROM Airport a JOIN  a.country c GROUP BY c.name ORDER BY COUNT(a) DESC ")
				.setMaxResults(10).getResultList();
		List<Airport> q = new ArrayList<Airport>(q1);
		List<Airport> q2 = getCurrentEntityManager()
				.createQuery(
						"SELECT a,COUNT(a) FROM Airport a JOIN  a.country c GROUP BY c.name ORDER BY COUNT(a) ASC ")
				.setMaxResults(10).getResultList();
		q.addAll(q2);
		List<Airport> q4 = getCurrentEntityManager()
				.createQuery(
						"SELECT r,COUNT(r) as cc FROM Runway r  GROUP BY r.leIdent ORDER BY COUNT(r) DESC")
				.setMaxResults(10).getResultList();
		q.addAll(q4);
		List<Airport> q3 = getCurrentEntityManager()
				.createQuery(
						"SELECT r FROM Runway r JOIN r.airport a JOIN a.country c GROUP BY r.surface,c.name")
				.getResultList();
		q.addAll(q3);

		return q;
	}

}
