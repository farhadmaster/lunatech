package dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import models.Country;

import com.google.inject.Singleton;

@Singleton
public class CountryDAO extends AbstractDAO<Country>{

	public Country findByCode(String code) {
		CriteriaBuilder builder = getCurrentEntityManager().getCriteriaBuilder();
		CriteriaQuery<Country> query = builder.createQuery(Country.class);
		query.where(builder.equal(query.from(Country.class).get("code"), code));
		return getCurrentEntityManager().createQuery(query).getSingleResult();
	}
}
