package mindbadger.football.repository;

import java.io.Serializable;

public abstract class AbstractRepository<T, ID extends Serializable> implements Repository<T, ID> {
	@Override
	public T createOrUpdate (T object) {
		if (object == null) {
			throw new RepositoryException("Object to create or update cannot be null");
		}
		
		ID idForObjectPassedIn = getIDFor(object);
		T matchById = null;
		if (idForObjectPassedIn != null) {
			matchById = findOne(idForObjectPassedIn);
			if (matchById == null) {
				throw new RepositoryException("Cannot update object with ID " + idForObjectPassedIn + " because it doesn't already exist. To create a new object do not specify an ID");
			}
		}
		
		T matchByUnique = findMatching(object);
		if (matchByUnique != null) {
			ID idForUniqueObjectFound = getIDFor(matchByUnique);
			if (idForObjectPassedIn != null && !idForObjectPassedIn.equals(idForUniqueObjectFound)) {
				throw new RepositoryException("Cannot update object with ID " + idForObjectPassedIn + " because the values specified already exist for another object with ID " + idForUniqueObjectFound);
			}
		}
		
		if (idForObjectPassedIn != null || (idForObjectPassedIn == null && matchByUnique == null)) {
			return save (object);
		} else {
			validateUpdate(matchByUnique, withValuesFrom(object));
			T updatedObject = update (matchByUnique, withValuesFrom(object));
			return save (updatedObject);
		}
	}
	
	public abstract ID getIDFor (T object);
	public abstract T update (T objectToUpdate, T objectToCopyValuesFrom);
	public abstract void validateUpdate (T objectToUpdate, T objectToCopyValuesFrom);
	
	private T withValuesFrom (T object) {
		return object;
	}
}
