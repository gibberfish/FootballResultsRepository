package mindbadger.footballresultsanalyser.repository;

import mindbadger.footballresultsanalyser.domain.Division;
import mindbadger.footballresultsanalyser.domain.Season;
import mindbadger.footballresultsanalyser.domain.SeasonDivision;
import mindbadger.footballresultsanalyser.domain.SeasonDivisionTeam;
import mindbadger.footballresultsanalyser.domain.Team;

public abstract class AbstractSeasonRepository extends AbstractRepository<Season, Integer> implements SeasonRepository {
	@Override
	public Season findMatching(Season season) {
		return findOne(getIDFor(season));
	}

	@Override
	public SeasonDivision getSeasonDivision(Season season, Division division) {
		Season retrievedSeason = findMatching(season);
		for (SeasonDivision seasonDivision : retrievedSeason.getSeasonDivisions()) {
			if (division.getDivisionId().equals(seasonDivision.getDivision().getDivisionId())) {
				return seasonDivision;
			}
		}
		return null;
	}

	@Override
	public SeasonDivisionTeam getSeasonDivisionTeam(SeasonDivision seasonDivision, Team team) {
		for (SeasonDivisionTeam seasonDivisionTeam : seasonDivision.getSeasonDivisionTeams()) {
			if (team.getTeamId().equals(seasonDivisionTeam.getTeam().getTeamId())) {
				return seasonDivisionTeam;
			}
		}
		return null;
	}

	@Override
	public Integer getIDFor(Season season) {
		return season.getSeasonNumber();
	}

	@Override
	public Season update(Season seasonToUpdate, Season seasonToCopyValuesFrom) {
		seasonToUpdate.setSeasonDivisions(seasonToCopyValuesFrom.getSeasonDivisions());
		return seasonToUpdate;
	}

	@Override
	public void validateUpdate(Season seasonToUpdate, Season seasonToCopyValuesFrom) {
	}

}
