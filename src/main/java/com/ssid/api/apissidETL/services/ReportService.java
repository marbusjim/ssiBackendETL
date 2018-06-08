package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.dto.RepoChartDTO;
import com.ssid.api.apissidETL.dto.RepoTableDTO;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<RepoChartDTO> getChartDataForReport(Date startDate, Date endDate);

    List<RepoTableDTO> getTableDataForReport(Date startDate, Date endDate);
}