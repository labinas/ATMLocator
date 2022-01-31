package com.atmlocator.userservice.model;/*
    Created by Labina on 29-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserAtms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long atmId;

    public AppUserAtms(Long atmId) {
        this.atmId = atmId;
    }
}
