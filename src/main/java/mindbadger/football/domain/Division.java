package mindbadger.football.domain;

import java.io.Serializable;

public interface Division extends Serializable {
    public String getDivisionId();
    public void setDivisionId(String divisionId);
    
    public String getDivisionName();
    public void setDivisionName(String divisionName);    
}
