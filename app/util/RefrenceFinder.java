package util;

import models.BaseEntity;

public interface RefrenceFinder<T extends BaseEntity> {
	boolean support(String column);
	String getBeanProperty();
	T getReference(String value);
}
