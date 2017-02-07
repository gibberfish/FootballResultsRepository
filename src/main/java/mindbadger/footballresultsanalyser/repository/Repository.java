package mindbadger.footballresultsanalyser.repository;

import java.util.List;

public interface Repository<T> {
	void addOrUpdate (T repositoryItem);
	void remove (T repositoryItem);
	List<T> query (Specification<T> specification);
}
