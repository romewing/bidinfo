package cn.com.hystrix.bidinfo.security.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Address> addresses = new ArrayList<>();

    public Person() {
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}

