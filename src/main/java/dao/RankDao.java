package dao;

import java.util.List;

/**
 * Created by jingood2 on 2014. 5. 22..
 */
public interface RankDao {

    List<Object[]> getRank(Integer eventId);
}
