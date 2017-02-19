package mindbadger.footballresultsanalyser.repository;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;

public interface SeasonRepository extends Repository<Season, Integer> {
	SeasonDivision getSeasonDivision (Season season, Division division);
	SeasonDivisionTeam getSeasonDivisionTeam (SeasonDivision seasonDivision, Team team);
}
