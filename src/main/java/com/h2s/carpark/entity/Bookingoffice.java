package com.h2s.carpark.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "bookingoffice")
@Getter
@Setter
public class Bookingoffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officeId")
    private Long officeId;

    @Column(name = "endContractDeadline")
    private java.sql.Date endContractDeadline;

    @Column(name = "officeName")
    private String officeName;

    @Column(name = "officePhone")
    private String officePhone;

    @Column(name = "officePlace")
    private String officePlace;

    @Column(name = "officePrice")
    private Long officePrice;

    @Column(name = "startContractDeadline")
    private java.sql.Date startContractDeadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Override
    public String toString() {
        return "Bookingoffice{" +
                "officeId=" + officeId +
                ", endContractDeadline=" + endContractDeadline +
                ", officeName='" + officeName + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", officePlace='" + officePlace + '\'' +
                ", officePrice=" + officePrice +
                ", startContractDeadline=" + startContractDeadline +
                '}';
    }
}
