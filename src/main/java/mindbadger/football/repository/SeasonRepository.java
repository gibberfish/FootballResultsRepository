package mindbadger.football.repository;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonDivision;
import mindbadger.football.domain.SeasonDivisionTeam;
import mindbadger.football.domain.Team;

public interface SeasonRepository extends Repository<Season, Integer> {
	SeasonDivision getSeasonDivision (Season season, Division division);
	SeasonDivisionTeam getSeasonDivisionTeam (SeasonDivision seasonDivision, Team team);
}
