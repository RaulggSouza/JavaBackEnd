package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;

import java.util.List;

public class StatisticsService {
    public StatisticsData createStatistics(List<Bulletin> bulletins){
        return new StatisticsData(
                bulletins.stream().mapToInt(Bulletin::getInfected).sum(),
                bulletins.stream().mapToInt(Bulletin::getDeaths).sum(),
                bulletins.stream().mapToDouble(Bulletin::getIcuRatio).average().orElse(0.0)
                );
    }
}
