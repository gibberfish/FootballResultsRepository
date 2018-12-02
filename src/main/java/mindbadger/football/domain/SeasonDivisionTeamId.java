package mindbadger.football.domain;

import java.io.Serializable;
import java.util.Objects;

public class SeasonDivisionTeamId implements Serializable {
	private static final long serialVersionUID = 7195048183491291063L;

	private String team;
	private SeasonDivisionId seasonDivision;
	
	public SeasonDivisionTeamId () {}
	public SeasonDivisionTeamId (SeasonDivisionId seasonDivision, String team) {
		this.seasonDivision = seasonDivision;
		this.team = team;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(seasonDivision, team);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof SeasonDivisionTeamId)) return false;
		SeasonDivisionTeamId seasonDivisionTeamId = (SeasonDivisionTeamId) obj;
		
		boolean seasonDivisionEqual = seasonDivision.equals(seasonDivisionTeamId.seasonDivision);
		boolean teamEqual = team.equals(seasonDivisionTeamId.team);
		
		return (seasonDivisionEqual && teamEqual);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public SeasonDivisionId getSeasonDivision() {
		return seasonDivision;
	}

	public void setSeasonDivision(SeasonDivisionId seasonDivision) {
		this.seasonDivision = seasonDivision;
	}
}
