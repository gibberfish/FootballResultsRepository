package mindbadger.football.repository;

import mindbadger.football.domain.Fixture;

public abstract class AbstractFixtureRepository extends AbstractRepository<Fixture, String> implements FixtureRepository {
	@Override
	public Fixture findMatching(Fixture fixture) {
		return getExistingFixture(fixture.getSeasonDivision(), fixture.getHomeTeam(), fixture.getAwayTeam());
	}

	@Override
	public String getIDFor(Fixture fixture) {
		return fixture.getFixtureId();
	}

	@Override
	public Fixture update(Fixture fixtureToUpdate, Fixture fixtureToCopyValuesFrom) {
		fixtureToUpdate.setFixtureDate(fixtureToCopyValuesFrom.getFixtureDate());
		fixtureToUpdate.setSeasonDivision(fixtureToCopyValuesFrom.getSeasonDivision());
		fixtureToUpdate.setHomeGoals(fixtureToCopyValuesFrom.getHomeGoals());
		fixtureToUpdate.setAwayGoals(fixtureToCopyValuesFrom.getAwayGoals());
		return fixtureToUpdate;
	}

	@Override
	public void validateUpdate(Fixture fixtureToUpdate, Fixture fixtureToCopyValuesFrom) {
		/*
		 * The fixture we're trying to update is a result (has date and score) and the fixture we're updating from
		 * is also a result, but has a later date. In this case, we assume this is a play-off fixture that we don't want to track.
		 */
		if (fixtureIsAResult(fixtureToUpdate) &&
			fixtureIsAResult(fixtureToCopyValuesFrom) &&
			fixtureToCopyFromIsAfterTheFixtureToUpdate (fixtureToUpdate, fixtureToCopyValuesFrom)) {
			throw new RepositoryException ("Cannot save a playoff");
		}
	}
	
	private boolean fixtureIsAResult (Fixture fixture) {
		return (fixture.getFixtureDate() != null && fixture.getHomeGoals() != null);
	}
	
	private boolean fixtureToCopyFromIsAfterTheFixtureToUpdate (Fixture fixtureToUpdate, Fixture fixtureToCopyValuesFrom) {
		return fixtureToCopyValuesFrom.getFixtureDate().after(fixtureToUpdate.getFixtureDate());
	}
}
