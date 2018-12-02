package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Objects;

public class SeasonDivisionId implements Serializable {
	private static final long serialVersionUID = 8013910648038828574L;

	private Integer season;
	private String division;

	public SeasonDivisionId () {}
	public SeasonDivisionId (Integer season, String division) {
		this.season = season;
		this.division = division;
	}

	@Override
	public int hashCode() {
		return Objects.hash(season, division);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionId)) return false;
		SeasonDivisionId seasonDivsionId = (SeasonDivisionId) obj;
		
		boolean seasonIdEqual = (season.equals(seasonDivsionId.season));
		boolean divisionIdEqual = division.equals(seasonDivsionId.division);
		
		return (seasonIdEqual && divisionIdEqual);
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
}
