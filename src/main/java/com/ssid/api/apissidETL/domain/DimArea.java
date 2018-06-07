package com.ssid.api.apissidETL.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "DimArea")
public class DimArea {
//    @Id
//    @Column(name = "AreaID")
    private long id;

//    @Column(name = "AreaName")
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
