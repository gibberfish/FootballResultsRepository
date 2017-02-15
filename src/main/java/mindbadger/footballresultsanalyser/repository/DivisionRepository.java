package mindbadger.footballresultsanalyser.repository;

import mindbadger.footballresultsanalyser.domain.Division;

public interface DivisionRepository extends Repository<Division, String> {
	Division findDivisionByName (String name);
}
