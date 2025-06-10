package br.ifsp.infection.model;

import java.util.List;

public class StatisticsService {
    StatisticsData createStatistics(List<Bulletin> bulletins){
        int infected = bulletins.stream()
                .mapToInt(Bulletin::getInfected)
                .reduce(0, Integer::sum);

        int dead = bulletins.stream()
                .mapToInt(Bulletin::getDeaths)
                .reduce(0, Integer::sum);

        double occupied = bulletins.stream()
                .mapToDouble(Bulletin::getIcuRatio)
                .reduce(0, Double::sum) / bulletins.size();

        return new StatisticsData(infected, dead, occupied);
    }
}
