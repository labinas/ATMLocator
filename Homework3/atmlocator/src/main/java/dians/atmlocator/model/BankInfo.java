package dians.atmlocator.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bank_info")
public class BankInfo {
    @Id
    Long id;
    String bank;
    String contact;
    String number;

    public BankInfo() {
    }

    public BankInfo(Long id, String bank, String contact, String number) {
        this.id = id;
        this.bank = bank;
        this.contact = contact;
        this.number = number;
    }
}
