package com.iheb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.iheb.entities.Sport;
import com.iheb.util.JPAutil;

public class SportDao {
    private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

    public void ajouter(Sport sport) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(sport);
        tx.commit();
    }

    public void modifier(Sport sport) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(sport);
        tx.commit();
    }

    public void supprimer(Sport sport) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        sport = entityManager.merge(sport);
        entityManager.remove(sport);
        tx.commit();
    }

    public Sport consulter(Long id) {
        return entityManager.find(Sport.class, id);
    }

    public List<Sport> listerTous() {
        List<Sport> sports = entityManager.createQuery("select s from Sport s", Sport.class).getResultList();
        return sports;
    }

    public List<Sport> listerParNom(String nom) {
        List<Sport> sports = entityManager.createQuery("select s from Sport s where s.nomSport like :pnom", Sport.class)
                .setParameter("pnom", "%" + nom + "%").getResultList();

        return sports;
    }
}
