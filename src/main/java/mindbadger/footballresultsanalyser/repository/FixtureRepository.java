package mindbadger.footballresultsanalyser.repository;

import java.util.List;

import mindbadger.footballresultsanalyser.domain.Fixture;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.Team;

public interface FixtureRepository extends Repository<Fixture, String>{
	List<Fixture> getFixturesWithNoFixtureDate();
	List<Fixture> getFixturesForTeamInDivisionInSeason(SeasonDivision seasonDivision, Team team);
	List<Fixture> getFixturesForDivisionInSeason(SeasonDivision seasonDivision);
	List<Fixture> getUnplayedFixturesBeforeToday();
	Fixture getExistingFixture(Season season, Team homeTeam, Team awayTeam);
}
