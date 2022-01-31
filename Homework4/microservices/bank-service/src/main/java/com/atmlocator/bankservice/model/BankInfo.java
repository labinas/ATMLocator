package com.atmlocator.bankservice.model;/*
    Created by Labina on 31-Jan-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_info")
public class BankInfo {
    @Id
    Long id;
    String bank;
    String contact;
    String number;

}
