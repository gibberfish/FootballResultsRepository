package mindbadger.football.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.Fixture;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonDivision;
import mindbadger.football.domain.Team;
import mindbadger.football.repository.AbstractFixtureRepository;
import mindbadger.football.repository.RepositoryException;

public class AbstractFixtureRepositoryTest {

	private static final String FIX_ID1 = "FIX1";
	private static final String FIX_ID2 = "FIX2";
	
	@Mock Fixture mockFixture1;
	@Mock Fixture mockFixture2;
	@Mock Season mockSeason;
	@Mock Division mockDivision;
	@Mock Team mockTeam1;
	@Mock Team mockTeam2;
	@Mock Team mockTeam3;
	@Mock Team mockTeam4;
	@Mock Calendar mockFixtureDate1;
	@Mock Calendar mockFixtureDate2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when (mockFixture1.getSeason()).thenReturn(mockSeason);
		when (mockFixture1.getDivision()).thenReturn(mockDivision);
		when (mockFixture1.getHomeTeam()).thenReturn(mockTeam1);
		when (mockFixture1.getAwayTeam()).thenReturn(mockTeam2);
		when (mockFixture1.getFixtureId()).thenReturn(FIX_ID1);
		when (mockFixture1.getHomeGoals()).thenReturn(5);
		when (mockFixture1.getAwayGoals()).thenReturn(4);
		when (mockFixture1.getFixtureDate()).thenReturn(mockFixtureDate1);
		
		when (mockFixture2.getSeason()).thenReturn(mockSeason);
		when (mockFixture2.getDivision()).thenReturn(mockDivision);
		when (mockFixture2.getHomeTeam()).thenReturn(mockTeam3);
		when (mockFixture2.getAwayTeam()).thenReturn(mockTeam4);
		when (mockFixture2.getFixtureId()).thenReturn(FIX_ID2);
		when (mockFixture2.getHomeGoals()).thenReturn(3);
		when (mockFixture2.getAwayGoals()).thenReturn(2);
		when (mockFixture2.getFixtureDate()).thenReturn(mockFixtureDate2);
		
		when (mockFixtureDate2.after(mockFixtureDate1)).thenReturn(false);
		when (mockFixtureDate1.after(mockFixtureDate2)).thenReturn(true);
	}
	
	@Test
	public void shouldFindMatchingFixture() {
		// Given
		AbstractFixtureRepository objectUnderTest = new AbstractFixtureRepository() {
			@Override public List<Fixture> getFixturesWithNoFixtureDate() {return null;}
			@Override public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate) {return null; }
			@Override public List<Fixture> getUnplayedFixturesBeforeToday() { return null; }
			@Override public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {
				if (mockSeason == season && mockTeam1 == homeTeam && mockTeam2 == awayTeam) {
					return mockFixture1;
				} else {
					return null;
				}
			}
			@Override public Fixture save(Fixture object) {return null;}
			@Override public Fixture findOne(String id) { return null;}
			@Override public void delete(Fixture object) {}
			@Override public Iterable<Fixture> findAll() { return null;}
			@Override public List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate) {return null;}
			@Override public List<Calendar> getFixtureDatesForDivisionInSeason (SeasonDivision seasonDivision) {return null;}
		};
		
		// When
		Fixture fixtureFound = objectUnderTest.findMatching(mockFixture1);
		
		// Then
		assertEquals (mockFixture1, fixtureFound);
	}
	
	@Test
	public void shouldNotFindMatchingFixture() {
		// Given
		AbstractFixtureRepository objectUnderTest = new AbstractFixtureRepository() {
			@Override public List<Fixture> getFixturesWithNoFixtureDate() {return null;}
			@Override public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate) {return null; }
			@Override public List<Fixture> getUnplayedFixturesBeforeToday() { return null; }
			@Override public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {
				if (mockSeason == season && mockTeam1 == homeTeam && mockTeam2 == awayTeam) {
					return null;
				} else {
					return mockFixture1;
				}
			}
			@Override public Fixture save(Fixture object) {return null;}
			@Override public Fixture findOne(String id) { return null;}
			@Override public void delete(Fixture object) {}
			@Override public Iterable<Fixture> findAll() { return null;}
			@Override public List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate) {return null;}
			@Override public List<Calendar> getFixtureDatesForDivisionInSeason (SeasonDivision seasonDivision) {return null;}
		};
		
		// When
		Fixture fixtureFound = objectUnderTest.findMatching(mockFixture1);
		
		// Then
		assertNull(fixtureFound);
	}

	@Test
	public void shouldGetIdForFixture () {
		// Given
		AbstractFixtureRepository objectUnderTest = new AbstractFixtureRepository() {
			@Override public List<Fixture> getFixturesWithNoFixtureDate() {return null;}
			@Override public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate) {return null; }
			@Override public List<Fixture> getUnplayedFixturesBeforeToday() { return null; }
			@Override public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {
				if (mockSeason == season && mockTeam1 == homeTeam && mockTeam2 == awayTeam) {
					return null;
				} else {
					return mockFixture1;
				}
			}
			@Override public Fixture save(Fixture object) {return null;}
			@Override public Fixture findOne(String id) { return null;}
			@Override public void delete(Fixture object) {}
			@Override public Iterable<Fixture> findAll() { return null;}
			@Override public List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate) {return null;}
			@Override public List<Calendar> getFixtureDatesForDivisionInSeason (SeasonDivision seasonDivision) {return null;}
		};
		
		// When
		String fixId = objectUnderTest.getIDFor(mockFixture1);
		
		// When
		assertEquals (FIX_ID1, fixId);
	}

	@Test
	public void shouldUpdateFixture () {
		// Given
		AbstractFixtureRepository objectUnderTest = new AbstractFixtureRepository() {
			@Override public List<Fixture> getFixturesWithNoFixtureDate() {return null;}
			@Override public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate) {return null; }
			@Override public List<Fixture> getUnplayedFixturesBeforeToday() { return null; }
			@Override public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {return null;}
			@Override public Fixture save(Fixture object) {return null;}
			@Override public Fixture findOne(String id) { return null;}
			@Override public void delete(Fixture object) {}
			@Override public Iterable<Fixture> findAll() { return null;}
			@Override public List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate) {return null;}
			@Override public List<Calendar> getFixtureDatesForDivisionInSeason (SeasonDivision seasonDivision) {return null;}
		};
		
		// When
		Fixture retrievedFixture = objectUnderTest.update(mockFixture1, mockFixture2);
		
		// Then
		assertEquals (mockFixture1, retrievedFixture);
		verify (mockFixture1, times(1)).setFixtureDate(mockFixtureDate2);
		verify (mockFixture1, times(1)).setDivision(mockDivision);
		verify (mockFixture1, times(1)).setHomeGoals(3);
		verify (mockFixture1, times(1)).setAwayGoals(2);
	}

	@Test
	public void shouldValidateFixture () {
		// Given
		AbstractFixtureRepository objectUnderTest = new AbstractFixtureRepository() {
			@Override public List<Fixture> getFixturesWithNoFixtureDate() {return null;}
			@Override public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate) {return null; }
			@Override public List<Fixture> getUnplayedFixturesBeforeToday() { return null; }
			@Override public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {return null;}
			@Override public Fixture save(Fixture object) {return null;}
			@Override public Fixture findOne(String id) { return null;}
			@Override public void delete(Fixture object) {}
			@Override public Iterable<Fixture> findAll() { return null;}
			@Override public List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate) {return null;}
			@Override public List<Calendar> getFixtureDatesForDivisionInSeason (SeasonDivision seasonDivision) {return null;}
		};
		
		// When
		objectUnderTest.validateUpdate(mockFixture1, mockFixture2);
		
		// Then
		// No Exception
	}
	
	@Test
	public void shouldFailFixtureValidateForAPlayoff () {
		// Given
		AbstractFixtureRepository objectUnderTest = new AbstractFixtureRepository() {
			@Override public List<Fixture> getFixturesWithNoFixtureDate() {return null;}
			@Override public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team) {return null;}
			@Override public List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision) {return null;}
			@Override public List<Fixture> getUnplayedFixturesBeforeToday() { return null; }
			@Override public List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate) {return null; }
			@Override public Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam) {return null;}
			@Override public Fixture save(Fixture object) {return null;}
			@Override public Fixture findOne(String id) { return null;}
			@Override public void delete(Fixture object) {}
			@Override public Iterable<Fixture> findAll() { return null;}
			@Override public List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate) {return null;}
			@Override public List<Calendar> getFixtureDatesForDivisionInSeason (SeasonDivision seasonDivision) {return null;}
		};
		
		try {
			// When
			objectUnderTest.validateUpdate(mockFixture2, mockFixture1);
			fail("Should throw a RepositoryException for a playoff");
		} catch (RepositoryException e) {
			// Then
			assertEquals ("Cannot save a playoff", e.getMessage());
		}
	}
}
