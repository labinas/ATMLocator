package dians.atmlocator.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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
    @OneToMany(mappedBy = "atm", fetch = FetchType.EAGER)
    private List<Review> reviews;

    public Atm() {
    }

    public Atm(Long openStreetId, double lat, double lon, String amenity, String intName, String name, String nameEn, String operator, String addrCity, String addrCityEn, String addrStreet, String addrHousenumber, String addrPostcode, String openingHours, String wheelchair) {
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
        this.addrHousenumber = addrHousenumber;
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
                ", addrHousenumber='" + addrHousenumber + '\'' +
                ", addrPostcode=" + addrPostcode +
                ", openingHours='" + openingHours + '\'' +
                ", wheelchair='" + wheelchair + '\'' +
                '}';
    }

    @JsonManagedReference
    public List<Review> getReviews() {
        return reviews;
    }
}
