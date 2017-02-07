package mindbadger.footballresultsanalyser.domain;

import java.io.Serializable;

public interface Team extends Serializable {
    public String getTeamId();
    public void setTeamId(String teamId);
    
    public String getTeamName();
    public void setTeamName(String teamName);
    
    public String getTeamShortName();
    public void setTeamShortName(String teamShortName);
}
