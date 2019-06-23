package com.ssid.api.apissidETL.command;

import com.ssid.api.apissidETL.domain.DimArea;

public class DimAreaCommand {

    private long id;

    private String Name;

    public DimAreaCommand(){}

    public DimAreaCommand(DimArea dimArea){
        setId(dimArea.getId());
        setName(dimArea.getName());
    }

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
