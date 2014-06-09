package models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jingood2 on 2014. 5. 7..
 */
@Entity
@Table(name = "RANK", schema = "", catalog = "spring")
public class RankEntity {

    private static final long serialVersionUID = 1L;

    private int rankId;
    private String name;
    private int price;

    private EventEntity event;
    private Set<TicketEntity> tickets;

    @Id
    @Column(name = "RANK_ID")
    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
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
    @Column(name = "PRICE")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RankEntity that = (RankEntity) o;

        if (price != that.price) return false;
        if (rankId != that.rankId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rankId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }


    public void setTickets(Set<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    @OneToMany
    public Set<TicketEntity> getTickets() {
        return tickets;
    }


    @ManyToOne
    @JoinColumn(name="event_id")
    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }
}
