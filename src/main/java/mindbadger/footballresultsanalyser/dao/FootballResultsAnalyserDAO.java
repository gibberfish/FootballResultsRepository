package mindbadger.footballresultsanalyser.dao;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;

public interface FootballResultsAnalyserDAO {
	// Season
	public List<Season> getSeasons ();
	public Season getSeason (Integer seasonNum);
	public Season addSeason (Integer seasonNum);
    
    // Division
	public Map<String, Division> getAllDivisions ();
	public Division addDivision (String divisionName);
	public Division getDivision(String divId);
    
    // Teams
	public Map<String, Team> getAllTeams ();
	public Team addTeam (String teamName);
	public Team getTeam(String teamId);
    
    // Fixture
	public Fixture addFixture (Season season, Calendar fixtureDate, Division division, Team homeTeam, Team awayTeam, Integer homeGoals, Integer awayGoals);
	public List<Fixture> getUnplayedFixturesBeforeToday();
	public List<Fixture> getFixturesWithNoFixtureDate ();
	public Fixture getFixture (String fixtureId);
    //public Fixture getFixture (Season season, Division division, Team homeTeam, Team awayTeam);
    public List<Fixture> getFixtures ();
    public List<Fixture> getFixturesForDivisionInSeason (SeasonDivision seasonDivision);
    public List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team);

    // Season Shape
	public SeasonDivision addSeasonDivision (Season season, Division division, int position);
	public SeasonDivisionTeam addSeasonDivisionTeam (SeasonDivision seasonDivision, Team team);
	public List<SeasonDivision> getDivisionsForSeason (Season season);
	public List<SeasonDivisionTeam> getTeamsForDivisionInSeason(SeasonDivision seasonDivision);
	public SeasonDivision getSeasonDivision (Season season, Division division);
	
    // Housekeeping
    public void startSession ();
    public void closeSession ();
}
