package dao.impl;

import dao.EventDao;
import models.EventEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2014. 5. 28..
 */
public class EventDaoImpl implements EventDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EventEntity> getEventList(Date start, Date end) {
        return em.createQuery("FROM EventEntity as event WHERE event.date >= :start AND event.date <= :end",
                EventEntity.class).setParameter("start",start).setParameter("end",end).getResultList();
    }
}
