package br.ifsp.infection.persistence;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.model.State;

import java.time.LocalDate;

public record BulletinDTO(int id, String city, State state, int infected, int deaths, double icuRatio, LocalDate date) {
    Bulletin fromDTO(BulletinDTO dto){
        return new Bulletin(dto.id(), dto.city(), dto.state(), dto.infected(), dto.deaths(), dto.icuRatio(), dto.date());
    }
}
