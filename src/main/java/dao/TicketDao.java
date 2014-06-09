package dao;

import models.TicketEntity;

import java.util.List;

/**
 * Created by jingood2 on 2014. 5. 22..
 */
public interface TicketDao {

    public List<TicketEntity> getBookedTicketList(Integer userId );
}
