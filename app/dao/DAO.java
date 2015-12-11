package dao;

import models.BaseEntity;

public interface DAO<T extends BaseEntity> {


	T create(T entity);
	
	void delete(Long id);

	T find(Long id);

	T update(T entity);
	
	void flush();
	
	void clear();

}
