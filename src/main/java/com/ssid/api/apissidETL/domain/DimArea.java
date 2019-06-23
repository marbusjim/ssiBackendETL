package com.ssid.api.apissidETL.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_area")
public class DimArea {
    @Id
    @Column(name = "area_id")
    private long id;

    @Column(name = "area_name", length = 50)
    private String Name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
