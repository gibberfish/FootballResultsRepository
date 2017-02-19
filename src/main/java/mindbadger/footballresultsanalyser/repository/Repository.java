package mindbadger.footballresultsanalyser.repository;

import java.io.Serializable;

public interface Repository<T, ID extends Serializable> {
	T save(T object);
	T findOne(ID id);
	void delete(T object);
	Iterable<T> findAll();
	
	T findMatching(T object);
}
