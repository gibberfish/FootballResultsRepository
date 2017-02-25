package mindbadger.footballresultsanalyser.repository;

import mindbadger.footballresultsanalyser.domain.Division;

public abstract class AbstractDivisionRepository extends AbstractRepository<Division, String> implements DivisionRepository {
	@Override
	public Division findMatching(Division division) {
		return findDivisionByName(division.getDivisionName());
	}

	@Override
	public String getIDFor(Division division) {
		return division.getDivisionId();
	}

	@Override
	public Division update(Division divisionToUpdate, Division divisionToCopyValuesFrom) {
		divisionToUpdate.setDivisionName(divisionToCopyValuesFrom.getDivisionName());
		return divisionToUpdate;
	}

	@Override
	public void validateUpdate(Division divisionToUpdate, Division divisionToCopyValuesFrom) {
	}
}
