package dians.atmlocator.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    ApplicationUser user;
    String reviewText;
    int rating;
    @ManyToOne
    Atm atm;
}
