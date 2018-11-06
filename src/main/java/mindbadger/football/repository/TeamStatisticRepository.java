package mindbadger.football.repository;

import mindbadger.football.domain.SeasonDivisionTeam;
import mindbadger.football.domain.TeamStatistic;

import java.util.Calendar;
import java.util.List;

public interface TeamStatisticRepository extends Repository<TeamStatistic, String> {
    List<TeamStatistic> findTeamStatisticsForSeasonDivisionTeamOnDate(SeasonDivisionTeam seasonDivisionTeam, Calendar fixtureDate);
}
