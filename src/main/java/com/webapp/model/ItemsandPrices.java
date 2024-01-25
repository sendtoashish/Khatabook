package com.webapp.model;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name="itemDetails")
@Transactional
public class ItemsandPrices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private int price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }
}
