package br.ifsp.infection.model;

import br.ifsp.infection.exceptions.EntityAlreadyExists;
import br.ifsp.infection.persistence.BulletinDAO;

public class RemoveBulletinService {
    private final BulletinDAO dao;

    RemoveBulletinService(BulletinDAO dao) {
        this.dao = dao;
    }

    void remove(int id){
        if (dao.existsById(id)) throw new EntityAlreadyExists("Bulletin with this Id already exists. Id: "+id);
        dao.delete(id);
    }
}
