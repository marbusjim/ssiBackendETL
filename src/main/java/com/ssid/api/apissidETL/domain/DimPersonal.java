package com.ssid.api.apissidETL.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_personal")
public class DimPersonal {
    @Id
    @Column(name = "personal_id")
    private long id;

    @Column(name = "personal_full_name", length = 100)
    private String fullName;

    @Column(name = "personal_age")
    private int age;

    @Column(name = "personal_status", length = 10)
    private String status;

    @Column(name = "personal_count_equipa")
    private int countEquipament;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCountEquipament() {
        return countEquipament;
    }

    public void setCountEquipament(int countEquipament) {
        this.countEquipament = countEquipament;
    }
}
