package mindbadger.football.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T, ID extends Serializable> {
	T findOne(ID id);
	T findMatching(T object);

	T save(T object);
	T createOrUpdate(T object);

	void delete(T object);

	List<? extends T> findAll();
	List<? extends T> saveAll(List<? extends T> objects);
}
