package cn.com.hystrix.bidinfo.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    @Column(name = "`number`")
    private String number;

    public Address() {
    }

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }
}
