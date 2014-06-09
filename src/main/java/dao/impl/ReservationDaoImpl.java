package dao.impl;

import dao.ReservationDao;
import models.ReservationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 * Created by jingood2 on 2014. 5. 22..
 */
public class ReservationDaoImpl implements ReservationDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void cancelReservation(ReservationEntity reservation) {

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        reservation = em.merge(reservation);

        // cancel reservation
        em.remove(reservation);

        tx.commit();

    }

    @Override
    public ReservationEntity getReservation(Integer reservationId) {
        return em.find(ReservationEntity.class, reservationId);
    }
}
