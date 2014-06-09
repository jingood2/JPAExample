package models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created by jingood2 on 2014. 5. 7..
 */
@Entity
@Table(name = "reservation", schema = "", catalog = "spring")
public class ReservationEntity implements Serializable {
    private int reservationId;
    private Timestamp reservedTs;

    private UserEntity user;

    @Id
    @Column(name = "reservation_id")
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Basic
    @Column(name = "reserved_ts")
    public Timestamp getReservedTs() {
        return reservedTs;
    }

    public void setReservedTs(Timestamp reservedTs) {

        this.reservedTs = reservedTs;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (reservationId != that.reservationId) return false;
        if (reservedTs != null ? !reservedTs.equals(that.reservedTs) : that.reservedTs != null) return false;

        return true;

    }

    @Override
    public int hashCode() {
        int result = reservationId;
        result = 31 * result + (reservedTs != null ? reservedTs.hashCode() : 0);
        return result;
    }

    private TicketEntity ticket;

    @OneToOne
    @JoinColumn(name="reservation_id")
    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }
}
