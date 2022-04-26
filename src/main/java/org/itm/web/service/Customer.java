package org.itm.web.service;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
public class Customer extends PanacheEntity{

    @Column(length = 40, unique = true)
    public String first_name;
    public String last_name;
    public String email;

    public Customer() {
    }

    public Customer(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }
}