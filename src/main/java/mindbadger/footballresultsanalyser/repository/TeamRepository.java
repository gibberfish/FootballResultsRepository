package mindbadger.footballresultsanalyser.repository;

import mindbadger.footballresultsanalyser.domain.Team;

public interface TeamRepository extends Repository<Team, String> {
	Team findTeamByName (String name);
}
