package dao.impl;

import dao.TicketDao;
import models.TicketEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by jingood2 on 2014. 5. 22..
 */
public class TicketDaoImpl implements TicketDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<TicketEntity> getBookedTicketList(Integer userId ) {

        return em.createQuery(" FROM TicketEntity AS ticket INNER JOIN FETCH ticket.event AS event INNER JOIN FETCH ticket.rank AS rank WHERE ticket.reservation.user.userId = :userId",
                TicketEntity.class).setParameter("userId",userId).getResultList();
    }
}
