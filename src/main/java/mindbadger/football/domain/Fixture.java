package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Calendar;

public interface Fixture extends Serializable {
    public String getFixtureId();
    public void setFixtureId(String fixtureId);
    
    public SeasonDivision getSeasonDivision();
    public void setSeasonDivision(SeasonDivision season);
    
    public Team getHomeTeam();
    public void setHomeTeam(Team homeTeam);
    
    public Team getAwayTeam();
    public void setAwayTeam(Team awayTeam);
    
    public Calendar getFixtureDate();
    public void setFixtureDate(Calendar fixtureDate);
    
    public Integer getHomeGoals();
    public void setHomeGoals(Integer homeGoals);
    
    public Integer getAwayGoals();
    public void setAwayGoals(Integer awayGoals);
}
