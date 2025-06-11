package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.State;
import br.ifsp.infection.persistence.BulletinDAO;

import java.time.LocalDate;
import java.util.List;

public class FilterBulletinService {
    private final BulletinDAO<Bulletin, Integer> dao;

    public FilterBulletinService(BulletinDAO<Bulletin, Integer> dao) {
        this.dao = dao;
    }

    public List<Bulletin> filter(
            List<Bulletin> all,
            String city,
            State state,
            LocalDate begin,
            LocalDate end
    ){
        return all.stream()
                .filter(b -> filterByCity(city, b))
                .filter(b -> filterByState(state, b))
                .filter(b -> filterByStart(begin, b))
                .filter(b -> filterByEnd(end, b))
                .toList();
    }

    private static boolean filterByEnd(LocalDate end, Bulletin b) {
        return end == null || !b.getDate().isAfter(end);
    }

    private static boolean filterByStart(LocalDate begin, Bulletin b) {
        return begin == null || !b.getDate().isBefore(begin);
    }

    private static boolean filterByState(State state, Bulletin b) {
        return state == null || b.getState() == state;
    }

    private static boolean filterByCity(String city, Bulletin b) {
        return city == null || b.getCity().toLowerCase().contains(city.toLowerCase());
    }
}
