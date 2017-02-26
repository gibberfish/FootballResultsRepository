package mindbadger.football.repository;

import mindbadger.football.domain.Team;

public interface TeamRepository extends Repository<Team, String> {
	Team findTeamByName (String name);
}
