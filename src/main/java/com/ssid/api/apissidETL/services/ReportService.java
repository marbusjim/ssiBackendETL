package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.DTO.RepoTableDTO;
import com.ssid.api.apissidETL.DTO.ResultDTO;
import com.ssid.api.apissidETL.dto.DataChart;
import com.ssid.api.apissidETL.dto.RepoChartDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ReportService {
    List<DataChart> getChartDataForReport(String startDate, String endDate);

    List<RepoTableDTO> getTableDataForReport(String startDate, String endDate);

    List<ResultDTO> getAmountsIncidentBySeverity();

    List<ResultDTO> getAmountsIncidentByType();
}