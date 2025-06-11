package br.ifsp.infection.service;

import br.ifsp.infection.model.Bulletin;
import br.ifsp.infection.persistence.BulletinDAO;

import java.util.NoSuchElementException;

public class RemoveBulletinService {
    private final BulletinDAO<Bulletin, Integer> dao;

    public RemoveBulletinService(BulletinDAO<Bulletin, Integer> dao) {
        this.dao = dao;
    }

    public void remove(int id){
        if(!dao.existsById(id)) throw new NoSuchElementException("Bulletin don't exist. Id:"+ id);
        dao.delete(id);
    }
}
