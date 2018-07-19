package com.ssid.api.apissidETL.DTO;

import java.util.List;

public class DataChart {
    private String name;
    private List<DataSerie> series;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataSerie> getSeries() {
        return series;
    }

    public void setSeries(List<DataSerie> series) {
        this.series = series;
    }
}
