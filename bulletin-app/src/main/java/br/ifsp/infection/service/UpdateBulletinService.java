package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.BulletinDAO;

import java.util.NoSuchElementException;
import java.util.Objects;

public class UpdateBulletinService {
    private final BulletinDAO<Bulletin, Integer> dao;

    public UpdateBulletinService(BulletinDAO<Bulletin, Integer> dao) {
        this.dao = dao;
    }

    public void update(Bulletin bulletin){
        Objects.requireNonNull(bulletin, "Bulletin must not be null");
        int id = bulletin.getId();
        if(!dao.existsById(id)) throw new NoSuchElementException("Bulletin don't exist. Id:"+ id);

        dao.update(bulletin);
    }
}
