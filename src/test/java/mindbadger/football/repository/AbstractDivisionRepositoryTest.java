package mindbadger.football.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mindbadger.football.domain.Division;
import mindbadger.football.repository.AbstractDivisionRepository;

public class AbstractDivisionRepositoryTest {
	private static final String DIV_ID1 = "DIV1";
	private static final String DIV_NAME1 = "Premier";
	private static final String DIV_ID2 = "DIV2";
	private static final String DIV_NAME2 = "Championship";
	
	@Mock Division mockDivision1;
	@Mock Division mockDivision2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		when (mockDivision1.getDivisionId()).thenReturn(DIV_ID1);
		when (mockDivision1.getDivisionName()).thenReturn(DIV_NAME1);
		when (mockDivision2.getDivisionId()).thenReturn(DIV_ID2);
		when (mockDivision2.getDivisionName()).thenReturn(DIV_NAME2);
	}
	
	@Test
	public void shouldFindMatchingDivision() {
		// Given
		AbstractDivisionRepository objectUnderTest = new AbstractDivisionRepository() {
			@Override public Division findDivisionByName(String name) {
				if (DIV_NAME1.equals(name)) {
					return mockDivision1;
				} else {
					return null;
				}
			}
			@Override public Division save(Division object) {return null;}
			@Override public Division findOne(String id) {return null;}
			@Override public void delete(Division object) {}
			@Override public Iterable<Division> findAll() {return null;}
		};
		
		// When
		Division divisionFound = objectUnderTest.findMatching(mockDivision1);
		
		// Then
		assertEquals (mockDivision1, divisionFound);
	}
	
	@Test
	public void shouldNotFindMatchingDivision() {
		// Given
		AbstractDivisionRepository objectUnderTest = new AbstractDivisionRepository() {
			@Override public Division findDivisionByName(String name) {
				if (!DIV_NAME1.equals(name)) {
					return mockDivision1;
				} else {
					return null;
				}
			}
			@Override public Division save(Division object) {return null;}
			@Override public Division findOne(String id) {return null;}
			@Override public void delete(Division object) {}
			@Override public Iterable<Division> findAll() {return null;}
		};
		
		// When
		Division divisionFound = objectUnderTest.findMatching(mockDivision1);
		
		// Then
		assertNull(divisionFound);
	}

	@Test
	public void shouldGetIdForDivision () {
		// Given
		AbstractDivisionRepository objectUnderTest = new AbstractDivisionRepository() {
			@Override public Division findDivisionByName(String name) {
				if (!DIV_NAME1.equals(name)) {
					return mockDivision1;
				} else {
					return null;
				}
			}
			@Override public Division save(Division object) {return null;}
			@Override public Division findOne(String id) {return null;}
			@Override public void delete(Division object) {}
			@Override public Iterable<Division> findAll() {return null;}
		};
		
		// When
		String idFound = objectUnderTest.getIDFor(mockDivision1);
		
		// Then
		assertEquals (DIV_ID1, idFound);
	}

	@Test
	public void shouldUpdateDivision () {
		// Given
		AbstractDivisionRepository objectUnderTest = new AbstractDivisionRepository() {
			@Override public Division findDivisionByName(String name) {return null;}
			@Override public Division save(Division object) {return null;}
			@Override public Division findOne(String id) {return null;}
			@Override public void delete(Division object) {}
			@Override public Iterable<Division> findAll() {return null;}
		};
		
		// When
		Division divisionReturned = objectUnderTest.update(mockDivision1, mockDivision2);
		
		// Then
		assertEquals(mockDivision1, divisionReturned);
		verify(mockDivision1, times(1)).setDivisionName(DIV_NAME2);
	}

	@Test
	public void shouldValidateDivision () {
		// Given
		AbstractDivisionRepository objectUnderTest = new AbstractDivisionRepository() {
			@Override public Division findDivisionByName(String name) {return null;}
			@Override public Division save(Division object) {return null;}
			@Override public Division findOne(String id) {return null;}
			@Override public void delete(Division object) {}
			@Override public Iterable<Division> findAll() {return null;}
		};
		
		// When
		objectUnderTest.validateUpdate(mockDivision1, mockDivision2);
		
		// Then
		// No exception is thrown
	}
}
