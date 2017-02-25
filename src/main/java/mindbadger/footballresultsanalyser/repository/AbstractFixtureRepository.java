package mindbadger.footballresultsanalyser.repository;

import mindbadger.footballresultsanalyser.domain.Fixture;

public abstract class AbstractFixtureRepository extends AbstractRepository<Fixture, String> implements FixtureRepository {
	@Override
	public Fixture findMatching(Fixture fixture) {
		return getExistingFixture(fixture.getSeason(), fixture.getHomeTeam(), fixture.getAwayTeam());
	}

	@Override
	public String getIDFor(Fixture fixture) {
		return fixture.getFixtureId();
	}

	@Override
	public Fixture update(Fixture fixtureToUpdate, Fixture fixtureToCopyValuesFrom) {
		fixtureToUpdate.setFixtureDate(fixtureToCopyValuesFrom.getFixtureDate());
		fixtureToUpdate.setDivision(fixtureToCopyValuesFrom.getDivision());
		fixtureToUpdate.setHomeGoals(fixtureToCopyValuesFrom.getHomeGoals());
		fixtureToUpdate.setAwayGoals(fixtureToCopyValuesFrom.getAwayGoals());
		return fixtureToUpdate;
	}

	@Override
	public void validateUpdate(Fixture fixtureToUpdate, Fixture fixtureToCopyValuesFrom) {
		if (fixtureToUpdate.getHomeGoals() != null &&
				fixtureToCopyValuesFrom.getFixtureDate() != null &&
				fixtureToUpdate.getFixtureDate() != null &&
				fixtureToCopyValuesFrom.getFixtureDate().after(fixtureToUpdate.getFixtureDate())) {
			throw new RepositoryException ("Cannot save a playoff");
		}
	}
}
