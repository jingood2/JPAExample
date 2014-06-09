package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by admin on 2014. 5. 27..
 */
@Entity
@Table(name = "EVENT", schema = "", catalog = "spring")
public class EventEntity {
    private int eventId;
    private String name;
    private Timestamp date;

    @Id
    @Column(name = "EVENT_ID")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DATE")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (eventId != that.eventId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    private Set<TicketEntity> tickets;

    @OneToMany(mappedBy = "event")
    public Set<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    private Set<RankEntity> ranks;

    @OneToMany(mappedBy = "event")
    public Set<RankEntity> getRanks() {
        return ranks;
    }

    public void setRanks(Set<RankEntity> ranks) {
        this.ranks = ranks;
    }
}
