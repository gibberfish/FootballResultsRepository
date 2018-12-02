package mindbadger.football.repository;

import mindbadger.football.domain.TeamStatistic;
import mindbadger.football.domain.TeamStatisticId;

import java.text.SimpleDateFormat;

public abstract class AbstractTeamStatisticRepository extends AbstractRepository<TeamStatistic, TeamStatisticId> implements TeamStatisticRepository {
	@Override
	public TeamStatistic findMatching(TeamStatistic team) {
		//return findTeamStatisticByUniqueKey(team.getSeasonDivisionTeam(), team.getFixtureDate());
		throw new IllegalArgumentException("NOT IMPLEMENTED");
	}

//	@Override
//	public TeamStatisticId getIDFor(TeamStatistic teamStatistic) {
//		SimpleDateFormat fixtureDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//		String fixtureDate = fixtureDateFormatter.format(teamStatistic.getFixtureDate().getTime());
//
//		return teamStatistic.getSeasonDivisionTeam().getSeasonDivision().getSeason().getSeason() + "_" +
//				teamStatistic.getSeasonDivisionTeam().getSeasonDivision().getDivision().getDivision() + "_" +
//				teamStatistic.getSeasonDivisionTeam().getTeam().getTeam() + "_" +
//				fixtureDate + "_" +
//				teamStatistic.getStatistic();
//	}

	@Override
	public TeamStatistic update(TeamStatistic teamStatisticToUpdate, TeamStatistic teamStatisticToCopyValuesFrom) {
		teamStatisticToUpdate.setSeason(teamStatisticToCopyValuesFrom.getSeason());
		teamStatisticToUpdate.setDivision(teamStatisticToCopyValuesFrom.getDivision());
		teamStatisticToUpdate.setTeam(teamStatisticToCopyValuesFrom.getTeam());
		teamStatisticToUpdate.setFixtureDate(teamStatisticToCopyValuesFrom.getFixtureDate());
		teamStatisticToUpdate.setStatistic(teamStatisticToCopyValuesFrom.getStatistic());
		teamStatisticToUpdate.setValue(teamStatisticToCopyValuesFrom.getValue());

		return teamStatisticToUpdate;
	}

	@Override
	public void validateUpdate(TeamStatistic teamStatisticToUpdate, TeamStatistic teamStatisticToCopyValuesFrom) {
	}
}
