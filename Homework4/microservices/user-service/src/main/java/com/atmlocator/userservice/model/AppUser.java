package com.atmlocator.userservice.model;
/*
    Created by Labina on 29-Jan-22
*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "app_users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    String accountRole;
    @OneToMany
    @JsonIgnore
    List<AppUserReviews> reviews;
    @JsonIgnore
    @OneToMany
    List<AppUserAtms> atms;
}
