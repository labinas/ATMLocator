package dians.atmlocator.model;

import javax.persistence.*;

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
    private String addrHouseNumber;
    private String addrPostcode;
    private String openingHours;
    private String wheelchair;

    public Atm() {
    }

    public Atm(Long openStreetId, double lat, double lon, String amenity, String intName, String name, String nameEn, String operator, String addrCity, String addrCityEn, String addrStreet, String addrHouseNumber, String addrPostcode, String openingHours, String wheelchair) {
        this.openStreetId = openStreetId;
        this.lat = lat;
        this.lon = lon;
        this.amenity = amenity;
        this.intName = intName;
        this.name = name;
        this.nameEn = nameEn;
        this.operator = operator;
        this.addrCity = addrCity;
        this.addrCityEn = addrCityEn;
        this.addrStreet = addrStreet;
        this.addrHouseNumber = addrHouseNumber;
        this.addrPostcode = addrPostcode;
        this.openingHours = openingHours;
        this.wheelchair = wheelchair;
    }

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
                ", addrHouseNumber='" + addrHouseNumber + '\'' +
                ", addrPostcode=" + addrPostcode +
                ", openingHours='" + openingHours + '\'' +
                ", wheelchair='" + wheelchair + '\'' +
                '}';
    }
}
