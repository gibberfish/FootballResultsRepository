package mindbadger.football.repository;

import mindbadger.football.domain.Division;
import mindbadger.football.domain.Season;
import mindbadger.football.domain.SeasonDivision;
import mindbadger.football.domain.SeasonDivisionTeam;
import mindbadger.football.domain.Team;

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
	
	@Override
	public Season createOrUpdate (Season season) {
		return this.save(season);
	}
	
}
