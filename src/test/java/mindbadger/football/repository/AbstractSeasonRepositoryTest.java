package mindbadger.football.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonDivision;
import mindbadger.football.domain.SeasonDivisionTeam;
import mindbadger.football.domain.Team;
import mindbadger.football.repository.AbstractSeasonRepository;

public class AbstractSeasonRepositoryTest {
	private static final Integer SEASON1 = 2006;
	private static final Integer SEASON2 = 2007;
	private static final String DIV_ID1 = "DIV1";
	private static final String DIV_ID2 = "DIV2";
	private static final String TEAM_ID1 = "TEAM1";
	private static final String TEAM_ID2 = "TEAM2";

	@Mock Season mockSeason1;
	@Mock Season mockSeason2;
	@Mock Division mockDivision1;
	@Mock Division mockDivision2;
	@Mock SeasonDivision mockSeasonDivision1;
	@Mock SeasonDivision mockSeasonDivision2;
	@Mock Team mockTeam1;
	@Mock Team mockTeam2;
	@Mock SeasonDivisionTeam mockSeasonDivisionTeam1;
	@Mock SeasonDivisionTeam mockSeasonDivisionTeam2;

	private Set<SeasonDivision> seasonDivisions;
	private Set<SeasonDivisionTeam> seasonDivisionTeams;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		when (mockSeason1.getSeasonNumber()).thenReturn(SEASON1);
		when (mockSeason2.getSeasonNumber()).thenReturn(SEASON2);
		when (mockDivision1.getDivisionId()).thenReturn(DIV_ID1);
		when (mockDivision2.getDivisionId()).thenReturn(DIV_ID2);
		when (mockTeam1.getTeamId()).thenReturn(TEAM_ID1);
		when (mockTeam2.getTeamId()).thenReturn(TEAM_ID2);
		when (mockSeasonDivision1.getDivision()).thenReturn(mockDivision1);
		when (mockSeasonDivision2.getDivision()).thenReturn(mockDivision2);
		when (mockSeasonDivisionTeam1.getTeam()).thenReturn(mockTeam1);
		when (mockSeasonDivisionTeam2.getTeam()).thenReturn(mockTeam2);
		
		seasonDivisions = new HashSet<SeasonDivision> ();
		seasonDivisionTeams = new HashSet<SeasonDivisionTeam> ();
	}
	
	@Test
	public void shouldFindMatchingSeason() {
		// Given
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {
				if (id == SEASON1) {
					return mockSeason2;
				} else {
					return null;
				}
			}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		Season seasonFound = objectUnderTest.findMatching(mockSeason1);
		
		// Then
		assertEquals (mockSeason2, seasonFound);
	}
	
	@Test
	public void shouldNotFindMatchingSeason() {
		// Given
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {
				if (id != SEASON1) {
					return mockSeason2;
				} else {
					return null;
				}
			}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		Season seasonFound = objectUnderTest.findMatching(mockSeason1);
		
		// Then
		assertNull (seasonFound);
	}

	@Test
	public void shouldGetSeasonDivision () {
		// Given
		seasonDivisions.add(mockSeasonDivision1);
		seasonDivisions.add(mockSeasonDivision2);
		when (mockSeason1.getSeasonDivisions()).thenReturn(seasonDivisions);
			
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {
				if (id == SEASON1) {
					return mockSeason1;
				} else {
					return null;
				}
			}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		SeasonDivision seasonDivisionFound = objectUnderTest.getSeasonDivision(mockSeason1, mockDivision1);
		
		// Then
		assertEquals (mockSeasonDivision1, seasonDivisionFound);
	}

	@Test
	public void shouldNotGetSeasonDivision () {
		// Given
		seasonDivisions.add(mockSeasonDivision2);
		when (mockSeason1.getSeasonDivisions()).thenReturn(seasonDivisions);
		
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {
				if (id == SEASON1) {
					return mockSeason1;
				} else {
					return null;
				}
			}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		SeasonDivision seasonDivisionFound = objectUnderTest.getSeasonDivision(mockSeason1, mockDivision1);
		
		// Then
		assertNull (seasonDivisionFound);
	}

	@Test
	public void shouldGetSeasonDivisionTeam () {
		// Given
		seasonDivisions.add(mockSeasonDivision1);
		when (mockSeason1.getSeasonDivisions()).thenReturn(seasonDivisions);
		
		seasonDivisionTeams.add(mockSeasonDivisionTeam1);
		seasonDivisionTeams.add(mockSeasonDivisionTeam2);
		when (mockSeasonDivision1.getSeasonDivisionTeams()).thenReturn(seasonDivisionTeams);
				
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {
				if (id != SEASON1) {
					return mockSeason1;
				} else {
					return null;
				}
			}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		SeasonDivisionTeam seasonDivisionTeamFound = objectUnderTest.getSeasonDivisionTeam(mockSeasonDivision1, mockTeam1);
		
		// Then
		assertEquals (mockSeasonDivisionTeam1, seasonDivisionTeamFound);
	}

	@Test
	public void shouldNotGetSeasonDivisionTeam () {
		// Given
		seasonDivisions.add(mockSeasonDivision1);
		when (mockSeason1.getSeasonDivisions()).thenReturn(seasonDivisions);
		
		seasonDivisionTeams.add(mockSeasonDivisionTeam2);
		when (mockSeasonDivision1.getSeasonDivisionTeams()).thenReturn(seasonDivisionTeams);
				
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {
				if (id != SEASON1) {
					return mockSeason1;
				} else {
					return null;
				}
			}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		SeasonDivisionTeam seasonDivisionTeamFound = objectUnderTest.getSeasonDivisionTeam(mockSeasonDivision1, mockTeam1);
		
		// Then
		assertNull (seasonDivisionTeamFound);
	}

	@Test
	public void shouldGetIdForSeason () {
		// Given
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {return null;}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		Integer seasonFound = objectUnderTest.getIDFor(mockSeason1);
		
		// Then
		assertEquals (SEASON1, seasonFound);
	}

	@Test
	public void shouldUpdateSeason () {
		// Given
		when (mockSeason2.getSeasonDivisions()).thenReturn(seasonDivisions);
		
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {return null;}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		Season seasonUpdated = objectUnderTest.update(mockSeason1, mockSeason2);
		
		// Then
		assertEquals(mockSeason1, seasonUpdated);
		verify (mockSeason1, times(1)).setSeasonDivisions(seasonDivisions);
	}

	@Test
	public void shouldValidateSeason () {
		// Given
		AbstractSeasonRepository objectUnderTest = new AbstractSeasonRepository () {
			@Override public Season save(Season object) {return null;}
			@Override public Season findOne(Integer id) {
				if (id != SEASON1) {
					return mockSeason2;
				} else {
					return null;
				}
			}
			@Override public void delete(Season object) {}
			@Override public Iterable<Season> findAll() {return null;}
		};
		
		// When
		objectUnderTest.validateUpdate(mockSeason1, mockSeason2);
		
		// Then
		// An exception should not be thrown
	}
}
