package br.ifsp.infection.model;

import br.ifsp.infection.persistence.BulletinDAO;

import java.time.LocalDate;
import java.util.List;

public class FilterBulletinService {
    private final BulletinDAO dao;

    FilterBulletinService(BulletinDAO dao) {
        this.dao = dao;
    }

    List<Bulletin> filter(Bulletin bulletin){
        return List.of();
    }

    List<Bulletin> filter(String city, State state, LocalDate start, LocalDate end){
        return List.of();
    }
}
