package com.ssid.api.apissidETL.controller;

import com.ssid.api.apissidETL.services.ReportService;
import com.ssid.api.apissidETL.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiPath.REPORT_CHART_PATH)
public class ReportTableController {
    private ReportService reportService;

    @Autowired
    public ReportTableController(ReportService reportService) {
        this.reportService = reportService;
    }
}
