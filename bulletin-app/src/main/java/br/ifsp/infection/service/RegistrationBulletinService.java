package br.ifsp.infection.service;

import br.ifsp.infection.persistence.EntityAlreadyExists;
import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.BulletinDAO;

import java.util.Objects;

public class RegistrationBulletinService {
    private final BulletinDAO<Bulletin, Integer> dao;

    public RegistrationBulletinService(BulletinDAO<Bulletin, Integer> dao) {
        this.dao = dao;
    }

    public void register(Bulletin bulletin){
        Objects.requireNonNull(bulletin, "Bulletin must not be null");
        int id = bulletin.getId();
        if(dao.existsById(id)) throw new EntityAlreadyExists("Bulletin with this Id already in registered. Id:"+ id);

        dao.insert(bulletin);
    }
}
