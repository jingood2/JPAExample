package dao;

import models.ReservationEntity;

/**
 * Created by jingood2 on 2014. 5. 22..
 */
public interface ReservationDao {

    void cancelReservation(ReservationEntity reservation);
    ReservationEntity getReservation(Integer reservationId);
}
