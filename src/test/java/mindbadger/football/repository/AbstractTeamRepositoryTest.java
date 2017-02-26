package mindbadger.football.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mindbadger.football.domain.Team;
import mindbadger.football.repository.AbstractTeamRepository;

public class AbstractTeamRepositoryTest {
	private static final String TEAM_ID1 = "TEAM1";
	private static final String TEAM_NAME1 = "Pompey";
	private static final String TEAM_ID2 = "TEAM2";
	private static final String TEAM_NAME2 = "Arsenal";
	
	@Mock Team mockTeam1;
	@Mock Team mockTeam2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		when (mockTeam1.getTeamId()).thenReturn(TEAM_ID1);
		when (mockTeam1.getTeamName()).thenReturn(TEAM_NAME1);
		when (mockTeam2.getTeamId()).thenReturn(TEAM_ID2);
		when (mockTeam2.getTeamName()).thenReturn(TEAM_NAME2);
	}
	
	@Test
	public void shouldFindMatchingTeam() {
		// Given
		AbstractTeamRepository objectUnderTest = new AbstractTeamRepository() {
			@Override public Team findTeamByName(String name) {
				if (TEAM_NAME1.equals(name)) {
					return mockTeam1;
				} else {
					return null;
				}
			}
			@Override public Team save(Team object) {return null;}
			@Override public Team findOne(String id) {return null;}
			@Override public void delete(Team object) {}
			@Override public Iterable<Team> findAll() {return null;}
		};
		
		// When
		Team TeamFound = objectUnderTest.findMatching(mockTeam1);
		
		// Then
		assertEquals (mockTeam1, TeamFound);
	}
	
	@Test
	public void shouldNotFindMatchingTeam() {
		// Given
		AbstractTeamRepository objectUnderTest = new AbstractTeamRepository() {
			@Override public Team findTeamByName(String name) {
				if (!TEAM_NAME1.equals(name)) {
					return mockTeam1;
				} else {
					return null;
				}
			}
			@Override public Team save(Team object) {return null;}
			@Override public Team findOne(String id) {return null;}
			@Override public void delete(Team object) {}
			@Override public Iterable<Team> findAll() {return null;}
		};
		
		// When
		Team TeamFound = objectUnderTest.findMatching(mockTeam1);
		
		// Then
		assertNull(TeamFound);
	}

	@Test
	public void shouldGetIdForTeam () {
		// Given
		AbstractTeamRepository objectUnderTest = new AbstractTeamRepository() {
			@Override public Team findTeamByName(String name) {
				if (!TEAM_NAME1.equals(name)) {
					return mockTeam1;
				} else {
					return null;
				}
			}
			@Override public Team save(Team object) {return null;}
			@Override public Team findOne(String id) {return null;}
			@Override public void delete(Team object) {}
			@Override public Iterable<Team> findAll() {return null;}
		};
		
		// When
		String idFound = objectUnderTest.getIDFor(mockTeam1);
		
		// Then
		assertEquals (TEAM_ID1, idFound);
	}

	@Test
	public void shouldUpdateTeam () {
		// Given
		AbstractTeamRepository objectUnderTest = new AbstractTeamRepository() {
			@Override public Team findTeamByName(String name) {return null;}
			@Override public Team save(Team object) {return null;}
			@Override public Team findOne(String id) {return null;}
			@Override public void delete(Team object) {}
			@Override public Iterable<Team> findAll() {return null;}
		};
		
		// When
		Team TeamReturned = objectUnderTest.update(mockTeam1, mockTeam2);
		
		// Then
		assertEquals(mockTeam1, TeamReturned);
		verify(mockTeam1, times(1)).setTeamName(TEAM_NAME2);
	}

	@Test
	public void shouldValidateTeam () {
		// Given
		AbstractTeamRepository objectUnderTest = new AbstractTeamRepository() {
			@Override public Team findTeamByName(String name) {return null;}
			@Override public Team save(Team object) {return null;}
			@Override public Team findOne(String id) {return null;}
			@Override public void delete(Team object) {}
			@Override public Iterable<Team> findAll() {return null;}
		};
		
		// When
		objectUnderTest.validateUpdate(mockTeam1, mockTeam2);
		
		// Then
		// No exception is thrown
	}
}
