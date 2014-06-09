package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * Created by jingood2 on 2014. 5. 7..
 */
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String name;


    private Set<ReservationEntity> reservationEntities;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    public Set<ReservationEntity> getReservationEntities() {
        return reservationEntities;
    }

    public void setReservationEntities(Set<ReservationEntity> reservationEntities) {
        this.reservationEntities = reservationEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
