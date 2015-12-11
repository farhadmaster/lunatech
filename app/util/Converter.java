package util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import models.BaseEntity;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class Converter<T> {
	
	Class<T> clazz;
	public Converter(Class<T> clazz){
	  this.clazz = clazz;
	}
	
	public T convert(Map<String,String> record, RefrenceFinder<?> refrenceFinder){
		try {
			T bean = clazz.newInstance();
			for(String column : record.keySet()){
				if(refrenceFinder != null && refrenceFinder.support(column)){
					BaseEntity be = refrenceFinder.getReference(record.get(column));
					BeanUtils.setProperty(bean, refrenceFinder.getBeanProperty(), be);
				}else{
					String prop = columnToProp(column);
					PropertyDescriptor des = PropertyUtils.getPropertyDescriptor(bean, prop);
					if(des != null){
						Object value = convert(record.get(column), des.getPropertyType());
						BeanUtils.setProperty(bean, prop, value);
					}
				}
			}
			return bean;
			
			
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}

	private String columnToProp(String column) {
		String[] splited = column.split("_");
		String prop = "";
		for(String s : splited){
			if(prop.length() > 0){
				s = Character.toUpperCase(s.charAt(0)) + s.substring(1, s.length());
			}
			prop += s;
		}
		return prop;
	}
	
	private Object convert(String val, Class<?> type) {
		if(val == null || val.trim().length() == 0){
			return null;
		}
		if(Long.class.equals(type)){
			return Long.parseLong(val);
		}
		if(Double.class.equals(type)){
			return Double.parseDouble(val);
		}
		if(String.class.equals(type)){
			return val;
		}
		if(Boolean.class.equals(type)){
			if(val.length() == 1){
				return Long.parseLong(val) != 0;
			}
			return val.equalsIgnoreCase("YES");
		}
		return null;
	}
}
