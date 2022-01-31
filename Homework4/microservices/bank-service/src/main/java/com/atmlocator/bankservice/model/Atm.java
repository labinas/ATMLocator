package com.atmlocator.bankservice.model;/*
    Created by Labina on 31-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atms")
public class Atm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long openStreetId;
    private double lat;
    private double lon;
    private String amenity;
    private String intName;
    private String name;
    private String nameEn;
    private String operator;
    private String addrCity;
    private String addrCityEn;
    private String addrStreet;
    private String addrHousenumber;
    private String addrPostcode;
    private String openingHours;
    private String wheelchair;
    private Integer rating;
    @OneToMany
    private List<AtmReviews> reviews;

    @Override
    public String toString() {
        return "Atm{" +
                "id=" + id +
                ", openStreetId=" + openStreetId +
                ", lat=" + lat +
                ", lon=" + lon +
                ", amenity='" + amenity + '\'' +
                ", intName='" + intName + '\'' +
                ", name='" + name + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", operator='" + operator + '\'' +
                ", addrCity='" + addrCity + '\'' +
                ", addrCityEn='" + addrCityEn + '\'' +
                ", addrStreet='" + addrStreet + '\'' +
                ", addrHousenumber='" + addrHousenumber + '\'' +
                ", addrPostcode=" + addrPostcode +
                ", openingHours='" + openingHours + '\'' +
                ", wheelchair='" + wheelchair + '\'' +
                '}';
    }
}
