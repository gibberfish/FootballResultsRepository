package mindbadger.footballresultsanalyser.domain;

import java.io.Serializable;
import java.util.Set;

public interface SeasonDivision extends Serializable, Comparable<SeasonDivision> {
    public Season getSeason();
    public void setSeason(Season season);
    
    public Division getDivision();
    public void setDivision(Division division);
    
    public int getDivisionPosition();
    public void setDivisionPosition(int divisionPosition);
    
	public Set<SeasonDivisionTeam> getSeasonDivisionTeams();
	public void setSeasonDivisionTeams(Set<SeasonDivisionTeam> seasonDivisionTeams);
}
