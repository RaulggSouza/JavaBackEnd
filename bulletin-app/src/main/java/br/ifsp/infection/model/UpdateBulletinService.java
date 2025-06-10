package br.ifsp.infection.model;

import br.ifsp.infection.persistence.BulletinDAO;

import java.util.NoSuchElementException;
import java.util.Objects;

public class UpdateBulletinService {
    private final BulletinDAO dao;

    UpdateBulletinService(BulletinDAO dao) {
        this.dao = dao;
    }

    void update(Bulletin bulletin){
        Objects.requireNonNull(bulletin, "Bulletin must not be null");
        if (dao.existsById(bulletin.getId())) throw new NoSuchElementException(
                "No bulletin with this Id already registered. Id: "+ bulletin.getId());
        dao.update(bulletin.toDTO());
    }
}
