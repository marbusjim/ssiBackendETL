package com.ssid.api.apissidETL.dto;

import java.util.List;

public class RepoChartDTO {
    private int numIncidents;
    private String type;
    private String areaName;

    public int getNumIncidents() {
        return numIncidents;
    }

    public void setNumIncidents(int numIncidents) {
        this.numIncidents = numIncidents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}