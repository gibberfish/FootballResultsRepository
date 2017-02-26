package mindbadger.football.repository;

import mindbadger.football.domain.Team;

public abstract class AbstractTeamRepository extends AbstractRepository<Team, String> implements TeamRepository {
	@Override
	public Team findMatching(Team team) {
		return findTeamByName(team.getTeamName());
	}

	@Override
	public String getIDFor(Team team) {
		return team.getTeamId();
	}

	@Override
	public Team update(Team teamToUpdate, Team teamToCopyValuesFrom) {
		teamToUpdate.setTeamName(teamToCopyValuesFrom.getTeamName());
		teamToUpdate.setTeamShortName(teamToCopyValuesFrom.getTeamShortName());
		return teamToUpdate;
	}

	@Override
	public void validateUpdate(Team teamToUpdate, Team teamToCopyValuesFrom) {
	}
}
