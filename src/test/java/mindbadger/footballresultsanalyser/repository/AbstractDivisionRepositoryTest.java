package mindbadger.footballresultsanalyser.repository;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import mindbadger.footballresultsanalyser.domain.Division;

public class AbstractDivisionRepositoryTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldFindMatchingDivision() {
		// Given
		
		AbstractDivisionRepository objectUnderTest = new AbstractDivisionRepository() {
			@Override public Division findDivisionByName(String name) {return null;}
			@Override public Division save(Division object) {return null;}
			@Override public Division findOne(String id) {return null;}
			@Override public void delete(Division object) {}
			@Override public Iterable<Division> findAll() {return null;}
		};
		
		// When
		Division divisionFound = objectUnderTest.findMatching(null);
		
		// Then
		
	}
	
	@Test
	public void shouldNotFindMatchingDivision() {
		fail ("Not implemented yet");
	}

	@Test
	public void shouldGetIdForDivision () {
		fail ("Not implemented yet");
	}

	@Test
	public void shouldUpdateDivision () {
		fail ("Not implemented yet");
	}

	@Test
	public void shouldValidateDivision () {
		fail ("Not implemented yet");
	}
}
