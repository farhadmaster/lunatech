package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;
import models.BaseEntity;
import play.db.jpa.JPA;

public abstract class AbstractDAO<T extends BaseEntity> implements DAO<T> {

    private Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
        Type entity = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) entity;
        type = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public T create(final T entity) {
        this.getCurrentEntityManager().persist(entity);
        return entity;
    }

    @Override
    public void delete(final Long id) {
        this.getCurrentEntityManager().remove(this.getCurrentEntityManager().getReference(type, id));
    }

    @Override
    public T find(final Long id) {
        return (T) this.getCurrentEntityManager().find(type, id);
    }

    @Override
    public T update(final T entity) {
        return this.getCurrentEntityManager().merge(entity);    
    }
    
    @Override
    public void flush() {
    	getCurrentEntityManager().flush();	
	}
    
    @Override
    public void clear() {
    	getCurrentEntityManager().clear();
	}
    
    protected EntityManager getCurrentEntityManager(){
    	return JPA.em();
    }
}
