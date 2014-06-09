package dao;

import models.EventEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2014. 5. 28..
 */
public interface EventDao {

    List<EventEntity> getEventList(Date start, Date end);
}
