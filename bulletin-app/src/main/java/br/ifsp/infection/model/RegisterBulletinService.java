package br.ifsp.infection.model;

import br.ifsp.infection.exceptions.EntityAlreadyExists;
import br.ifsp.infection.persistence.BulletinDAO;

import java.util.Objects;

public class RegisterBulletinService {
    private final BulletinDAO dao;

    RegisterBulletinService(BulletinDAO dao) {
        this.dao = dao;
    }

    public void register(Bulletin bulletin){
        Objects.requireNonNull(bulletin, "Bulletin must not be null");
        if (dao.existsById(bulletin.getId())) throw new EntityAlreadyExists("Bulletin with this Id already exists. Id: "+bulletin.getId());
        dao.insert(bulletin.toDTO());
    }
}
