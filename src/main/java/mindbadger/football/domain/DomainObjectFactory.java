package mindbadger.football.domain;

import java.util.Calendar;

public interface DomainObjectFactory {
    public Season createSeason ();
    public Season createSeason (Integer seasonNumber);

    public Division createDivision ();
    public Division createDivision (String divisionName);

    public Team createTeam ();
    public Team createTeam (String teamName);

    public Fixture createFixture ();
    public Fixture createFixture (Season season, Team homeTeam, Team awayTeam);

    public SeasonDivision createSeasonDivision ();
    public SeasonDivision createSeasonDivision (Season season, Division division, int position);

    public SeasonDivisionTeam createSeasonDivisionTeam ();
    public SeasonDivisionTeam createSeasonDivisionTeam (SeasonDivision seasonDivision, Team team);

    public TeamStatistic createTeamStatistic ();
    public TeamStatistic createTeamStatistic (SeasonDivisionTeam seasonDivisionTeam, Calendar fixtureDate);

    public TrackedDivision createTrackedDivision (String dialect, Integer sourceId);
    public DivisionMapping createDivisionMapping (String dialect, Integer sourceId, Integer fraId);
    public TeamMapping createTeamMapping (String dialect, Integer sourceId, Integer fraId);
}
