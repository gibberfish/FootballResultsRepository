package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Calendar;

public interface TeamStatistic extends Serializable {

    public SeasonDivisionTeam getSeasonDivisionTeam ();
    public void setSeasonDivisionTeam (SeasonDivisionTeam seasonDivisionTeam);

    public Calendar getFixtureDate();
    public void setFixtureDate(Calendar fixtureDate);
    
    public String getStatistic();
    public void setStatistic(String statistic);

    public Integer getValue();
    public void setValue(Integer value);
}
