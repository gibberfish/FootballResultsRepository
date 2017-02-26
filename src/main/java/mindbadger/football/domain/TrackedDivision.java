package mindbadger.football.domain;

import java.io.Serializable;

public interface TrackedDivision extends Serializable{
	public String getDialect();
	public void setDialect(String dialect);
	
	public Integer getSourceId();
	public void setSourceId(Integer sourceId);
}
