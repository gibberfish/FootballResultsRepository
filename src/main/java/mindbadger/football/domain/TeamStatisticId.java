package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class TeamStatisticId implements Serializable {
    private static final long serialVersionUID = 7135048182491291063L;

    private Integer season;
    private String division;
    private String team;
    private Calendar fixtureDate;
    private String statistic;

    public TeamStatisticId() {
    }

    public TeamStatisticId(Integer season,
                           String division,
                           String team,
                           Calendar fixtureDate,
                           String statistic) {
        this.season = season;
        this.division = division;
        this.team = team;
        this.fixtureDate = fixtureDate;
        this.statistic = statistic;
    }

    @Override
    public int hashCode() {
        return Objects.hash(season, division, team, fixtureDate, statistic);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TeamStatisticId)) return false;
        TeamStatisticId teamStatisticId = (TeamStatisticId) obj;


        boolean seasonEqual = season.equals(teamStatisticId.season);
        boolean divisionEqual = division.equals(teamStatisticId.division);
        boolean teamEqual = team.equals(teamStatisticId.team);
        boolean fixtureDateEqual = fixtureDate.equals(teamStatisticId.fixtureDate);
        boolean statisticEqual = fixtureDate.equals(teamStatisticId.statistic);

        return (seasonEqual && divisionEqual && teamEqual && fixtureDateEqual && statisticEqual);
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Calendar getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(Calendar fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }
}
