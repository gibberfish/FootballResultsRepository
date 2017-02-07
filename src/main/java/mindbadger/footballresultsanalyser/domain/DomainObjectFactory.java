package mindbadger.footballresultsanalyser.domain;

public interface DomainObjectFactory {
    public Season createSeason (Integer seasonNumber);
    public Division createDivision (String divisionName);
    public Team createTeam (String teamName);
    public Fixture createFixture (Season season, Team homeTeam, Team awayTeam);
    public SeasonDivision createSeasonDivision (Season season, Division division, int position);
    public SeasonDivisionTeam createSeasonDivisionTeam (SeasonDivision seasonDivision, Team team);    
}
