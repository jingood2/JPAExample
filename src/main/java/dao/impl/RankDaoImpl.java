package dao.impl;

import dao.RankDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by jingood2 on 2014. 5. 22..
 */
public class RankDaoImpl implements RankDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> getRank(Integer eventId) {
        return em.createQuery("Select rank.rank_id, rank.name, rank.price, COUNT(*)"
                            + "FROM Rank As rank INNER JOIN rank.tickets AS ticket"
                            + "LEFT OUTER JOIN ticket.reservation"
                            + "WHERE rank.event.eventId = :eventId AND reservation IS NULL GROUP BY rank.rankId").setParameter("eventId",eventId).getResultList();

    }
}
