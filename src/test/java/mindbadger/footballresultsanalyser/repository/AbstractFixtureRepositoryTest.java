package mindbadger.footballresultsanalyser.repository;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.Team;

public class AbstractFixtureRepositoryTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldFindMatchingFixture() {
		// Given
		
		AbstractFixtureRepository objectUnderTest = new AbstractFixtureRepository() {
			@Override public List<Fixture> getFixturesWithNoFixtureDate() {return null;}
			@Override public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {return null;}
			@Override public List<Fixture> getUnplayedFixturesBeforeToday() { return null; }
			@Override public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {return null;}
			@Override public Fixture save(Fixture object) {return null;}
			@Override public Fixture findOne(String id) { return null;}
			@Override public void delete(Fixture object) {}
			@Override public Iterable<Fixture> findAll() { return null;}
		};
		
		// When
		Fixture fixtureFound = objectUnderTest.findMatching(null);
		
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
