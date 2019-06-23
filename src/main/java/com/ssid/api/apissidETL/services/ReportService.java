package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.DTO.DataChart;
import com.ssid.api.apissidETL.DTO.RepoTableDTO;
import com.ssid.api.apissidETL.DTO.ResultDTO;

import java.util.List;

public interface ReportService {
    List<DataChart> getChartDataForReport(String startDate, String endDate);

    List<RepoTableDTO> getTableDataForReport(String startDate, String endDate);

    List<ResultDTO> getAmountsIncidentBySeverity();

    List<ResultDTO> getAmountsIncidentByType();
}