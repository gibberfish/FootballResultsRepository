package mindbadger.football.repository;

import mindbadger.football.domain.Division;

public interface DivisionRepository extends Repository<Division, String> {
	Division findDivisionByName (String name);
}
