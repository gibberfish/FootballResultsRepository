package mindbadger.footballresultsanalyser.repository;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Team;

public class AbstractTeamRepositoryTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldFindMatchingDivision() {
		// Given
		
		AbstractTeamRepository objectUnderTest = new AbstractTeamRepository() {
			@Override public Team findTeamByName(String name) {return null;}
			@Override public Team save(Team object) {return null;}
			@Override public Team findOne(String id) {return null;}
			@Override public void delete(Team object) {}
			@Override public Iterable<Team> findAll() {return null;}
		};
		
		// When
		Team teamFound = objectUnderTest.findMatching(null);
		
		// Then
		
	}
	
	@Test
	public void shouldNotFindMatchingTeam() {
		fail ("Not implemented yet");
	}

	@Test
	public void shouldGetIdForTeam () {
		fail ("Not implemented yet");
	}

	@Test
	public void shouldUpdateTeam () {
		fail ("Not implemented yet");
	}

	@Test
	public void shouldValidateTeam () {
		fail ("Not implemented yet");
	}
}
