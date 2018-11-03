package mindbadger.football.repository;

import java.util.Calendar;
import java.util.List;

import mindbadger.football.domain.Fixture;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonDivision;
import mindbadger.football.domain.Team;

public interface FixtureRepository extends Repository<Fixture, String>{
	List<Fixture> getFixturesWithNoFixtureDate();
	List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team);
	List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision);
	List<Fixture> getFixturesForDivisionInSeasonOnDate(SeasonDivision seasonDivision, Calendar fixtureDate);
	List<Fixture> getUnplayedFixturesBeforeToday();
	Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam);
	List<Fixture> getUnplayedFixturesOnDate(Calendar fixtureDate);
}
