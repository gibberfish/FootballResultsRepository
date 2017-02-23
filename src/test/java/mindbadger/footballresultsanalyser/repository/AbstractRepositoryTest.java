package mindbadger.footballresultsanalyser.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AbstractRepositoryTest {
	private static final int ID_1 = 12;
	private static final int ID_2 = 51;

	@Mock
	Object mockObject1;

	@Mock
	Object mockObject2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldThrowExceptionIfCreateOrUpdateANullObject () {
		// Given
		AbstractRepository<Object, Integer> objectUnderTest = new AbstractRepository<Object, Integer>() {
			@Override public Object save(Object object) {return object;}
			@Override public Object findOne(Integer id) {return null;}
			@Override public Object findMatching(Object object) {return null;}
			@Override public Iterable<Object> findAll() {return null;}
			@Override public void delete(Object object) {}
			@Override public Object update(Object objectToUpdate, Object objectToCopyValuesFrom) {return null;}
			@Override public Integer getIDFor(Object object) {return null;}
		};

		// When
		try {
			objectUnderTest.createOrUpdate(null);
		} catch (IllegalArgumentException e) {
			// Then
			assertEquals ("Object to create or update cannot be null", e.getMessage());
		}
		
		
	}
	
	@Test
	public void shouldThrowAnExceptionTryingToUpdateAnObjectWithIdThatDoesntAlreadyExist () {
		// Given
		AbstractRepository<Object, Integer> objectUnderTest = new AbstractRepository<Object, Integer>() {
			@Override public Object save(Object object) {return object;}
			@Override public Object findOne(Integer id) {return null;}
			@Override public Object findMatching(Object object) {return null;}
			@Override public Iterable<Object> findAll() {return null;}
			@Override public void delete(Object object) {}
			@Override public Object update(Object objectToUpdate, Object objectToCopyValuesFrom) {return null;}
			@Override public Integer getIDFor(Object object) {return ID_1;}
		};
		
		try {
			objectUnderTest.createOrUpdate(mockObject1);
		} catch (IllegalStateException e) {
			// Then
			assertEquals ("Cannot update object with ID " + ID_1 + " because it doesn't already exist. To create a new object do not specify an ID", e.getMessage());
		}
	}

	@Test
	public void shouldThrowAnExceptionTryingToUpdateAnObjectWithUniqueValuesThatExistForADifferentObject () {
		// Given
		AbstractRepository<Object, Integer> objectUnderTest = new AbstractRepository<Object, Integer>() {
			@Override public Object save(Object object) {return object;}
			@Override public Object findOne(Integer id) {
				if (id == ID_1) {
					return mockObject1;
				} else {
					return mockObject2;
				}
			}
			@Override public Object findMatching(Object object) {return mockObject2;}
			@Override public Iterable<Object> findAll() {return null;}
			@Override public void delete(Object object) {}
			@Override public Object update(Object objectToUpdate, Object objectToCopyValuesFrom) {return null;}
			@Override public Integer getIDFor(Object object) {
				if (object == mockObject1) {
					return ID_1;
				} else {
					return ID_2;
				}
			}
		};
		
		try {
			objectUnderTest.createOrUpdate(mockObject1);
		} catch (IllegalStateException e) {
			// Then
			assertEquals ("Cannot update object with ID " + ID_1 + " because the values specified already exist for another object with ID " + ID_2, e.getMessage());
		}
	}

	@Test
	public void shouldSaveUpdatesToAnObjectByID () {
		// Given
		AbstractRepository<Object, Integer> objectUnderTest = new AbstractRepository<Object, Integer>() {
			@Override public Object save(Object object) {return object;}
			@Override public Object findOne(Integer id) {
				if (id == ID_1) {
					return mockObject1;
				} else {
					return mockObject2;
				}
			}
			@Override public Object findMatching(Object object) {return null;}
			@Override public Iterable<Object> findAll() {return null;}
			@Override public void delete(Object object) {}
			@Override public Object update(Object objectToUpdate, Object objectToCopyValuesFrom) {return null;}
			@Override public Integer getIDFor(Object object) {
				return ID_1;
			}
		};
		
		// When
		Object returnedObject = objectUnderTest.createOrUpdate(mockObject1);
		
		// Then
		assertEquals (mockObject1, returnedObject);
	}

	@Test
	public void shouldSaveANewObject () {
		// Given
		AbstractRepository<Object, Integer> objectUnderTest = new AbstractRepository<Object, Integer>() {
			@Override public Object save(Object object) {return object;}
			@Override public Object findOne(Integer id) {return null;}
			@Override public Object findMatching(Object object) {return null;}
			@Override public Iterable<Object> findAll() {return null;}
			@Override public void delete(Object object) {}
			@Override public Object update(Object objectToUpdate, Object objectToCopyValuesFrom) {return null;}
			@Override public Integer getIDFor(Object object) {return null;}
		};
		
		// When
		Object returnedObject = objectUnderTest.createOrUpdate(mockObject1);
		
		// Then
		assertEquals (mockObject1, returnedObject);
	}

	@Test
	public void shouldSaveAnUpdateToAnObjectFoundWithUniqueValues () {
		// Given
		AbstractRepository<Object, Integer> objectUnderTest = new AbstractRepository<Object, Integer>() {
			@Override public Object save(Object object) {return object;}
			@Override public Object findOne(Integer id) {return null;}
			@Override public Object findMatching(Object object) {return mockObject2;}
			@Override public Iterable<Object> findAll() {return null;}
			@Override public void delete(Object object) {}
			@Override public Object update(Object objectToUpdate, Object objectToCopyValuesFrom) {return mockObject2;}
			@Override public Integer getIDFor(Object object) {
				if (object == mockObject1) {
					return null;
				} else {
					return ID_2;
				}
			}
		};
		
		// When
		Object returnedObject = objectUnderTest.createOrUpdate(mockObject1);
		
		// Then
		assertEquals (mockObject2, returnedObject);
	}
}