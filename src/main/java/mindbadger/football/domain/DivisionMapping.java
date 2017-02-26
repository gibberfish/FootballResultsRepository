package mindbadger.football.domain;

import java.io.Serializable;

public interface DivisionMapping extends Serializable{
	public String getDialect();
	public void setDialect(String dialect);
	
	public Integer getSourceId();
	public void setSourceId(Integer sourceId);
	
	public Integer getFraId();
	public void setFraId(Integer fraId);
}
