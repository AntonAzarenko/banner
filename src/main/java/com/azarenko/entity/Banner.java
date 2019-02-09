package com.azarenko.entity;

import javax.persistence.*;

@Entity
@Table(name = "banners")
public class Banner extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Banner() {
    }

    public Banner(String name, String type, User user) {
        this.name = name;
        this.type = type;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
