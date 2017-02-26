package mindbadger.football.domain;

public interface DomainObjectFactory {
    public Season createSeason (Integer seasonNumber);
    public Division createDivision (String divisionName);
    public Team createTeam (String teamName);
    public Fixture createFixture (Season season, Team homeTeam, Team awayTeam);
    public SeasonDivision createSeasonDivision (Season season, Division division, int position);
    public SeasonDivisionTeam createSeasonDivisionTeam (SeasonDivision seasonDivision, Team team);
    public TrackedDivision createTrackedDivision (String dialect, Integer sourceId);
    public DivisionMapping createDivisionMapping (String dialect, Integer sourceId, Integer fraId);
    public TeamMapping createTeamMapping (String dialect, Integer sourceId, Integer fraId);
}
