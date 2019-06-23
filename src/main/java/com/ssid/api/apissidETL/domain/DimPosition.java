package com.ssid.api.apissidETL.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_position")
public class DimPosition {
    @Id
    @Column(name = "position_id")
    private long id;

    @Column(name = "position_name", length = 150)
    private String name;

    @Column(name = "position_parent", length = 150)
    private String parent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
