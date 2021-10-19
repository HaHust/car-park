package com.h2s.carpark.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "bookingoffice")
@Getter
@Setter
public class Bookingoffice {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "office_id")
    private String officeId;

    @Column(name = "endContract_deadline")
    private java.sql.Date endContractDeadline;

    @Column(name = "office_name")
    private String officeName;

    @Column(name = "office_phone")
    private String officePhone;

    @Column(name = "office_place")
    private String officePlace;

    @Column(name = "office_price")
    private Long officePrice;

    @Column(name = "start_contract_deadline")
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
