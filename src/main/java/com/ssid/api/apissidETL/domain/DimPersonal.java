package com.ssid.api.apissidETL.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "DimPersonal")
public class DimPersonal {
//    @Id
//    @Column(name = "PersonalID")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
