package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jingood2 on 2014. 5. 7..
 */
@Entity
@Table(name = "TICKET", schema = "", catalog = "spring")
public class TicketEntity implements Serializable{

    private static final long serialVersionUID = 1L;


    private int ticketId;

    @Id
    @Column(name = "TICKET_ID")
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (ticketId != that.ticketId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ticketId;
    }

    private RankEntity rank;

    @ManyToOne
    @JoinColumn(name="rank_id")
    public RankEntity getRank() {
        return rank;
    }

    public void setRank(RankEntity rank) {
        this.rank = rank;
    }

    private ReservationEntity reservation;

    @OneToOne(mappedBy = "ticket")
    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    private EventEntity event;

    @ManyToOne
    @JoinColumn(name="event_id")
    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }
}
