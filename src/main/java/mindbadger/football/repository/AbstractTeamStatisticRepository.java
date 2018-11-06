package mindbadger.football.repository;

import mindbadger.football.domain.TeamStatistic;

import java.text.SimpleDateFormat;

public abstract class AbstractTeamStatisticRepository extends AbstractRepository<TeamStatistic, String> implements TeamStatisticRepository {
	@Override
	public TeamStatistic findMatching(TeamStatistic team) {
		//return findTeamStatisticByUniqueKey(team.getSeasonDivisionTeam(), team.getFixtureDate());
		throw new IllegalArgumentException("NOT IMPLEMENTED");
	}

	@Override
	public String getIDFor(TeamStatistic teamStatistic) {
		SimpleDateFormat fixtureDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String fixtureDate = fixtureDateFormatter.format(teamStatistic.getFixtureDate().getTime());

		return teamStatistic.getSeasonDivisionTeam().getSeasonDivision().getSeason().getSeasonNumber() + "_" +
				teamStatistic.getSeasonDivisionTeam().getSeasonDivision().getDivision().getDivisionId() + "_" +
				teamStatistic.getSeasonDivisionTeam().getTeam().getTeamId() + "_" +
				fixtureDate + "_" +
				teamStatistic.getStatistic();
	}

	@Override
	public TeamStatistic update(TeamStatistic teamStatisticToUpdate, TeamStatistic teamStatisticToCopyValuesFrom) {
		teamStatisticToUpdate.setSeasonDivisionTeam(teamStatisticToCopyValuesFrom.getSeasonDivisionTeam());
		teamStatisticToUpdate.setFixtureDate(teamStatisticToCopyValuesFrom.getFixtureDate());
		teamStatisticToUpdate.setStatistic(teamStatisticToCopyValuesFrom.getStatistic());
		teamStatisticToUpdate.setValue(teamStatisticToCopyValuesFrom.getValue());

		return teamStatisticToUpdate;
	}

	@Override
	public void validateUpdate(TeamStatistic teamStatisticToUpdate, TeamStatistic teamStatisticToCopyValuesFrom) {
	}
}
