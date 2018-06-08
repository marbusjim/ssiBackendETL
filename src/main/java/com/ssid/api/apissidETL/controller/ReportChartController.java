package com.ssid.api.apissidETL.controller;

import com.ssid.api.apissidETL.services.ReportService;
import com.ssid.api.apissidETL.util.ApiPath;
import com.ssid.api.apissidETL.util.FormatAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.REPORT_CHART_PATH)
public class ReportChartController {
    private ReportService reportService;

    @Autowired
    public ReportChartController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = {"/incidents/area/{startDate}/{endDate}"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> GetIncidentForArea(@PathVariable String startDate, @PathVariable String endDate) {
        Map<String, Object> mapResponse = new HashMap<>();

        if(startDate != null && endDate != null)
        {
            if (startDate.matches("\\d{4}-\\d{2}-\\d{2}") && startDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                mapResponse.put("status", "OK");
                mapResponse.put("data", reportService.getChartDataForReport(FormatAux.stringToDate(startDate), FormatAux.stringToDate(endDate)));
            }
            else {
                mapResponse.put("status", "ERROR");
                mapResponse.put("errorMessage", "El formato de fecha es incorrecto.");
            }
        }
        else {
            mapResponse.put("status", "ERROR");
            mapResponse.put("errorMessage", "La fecha de inicio y fin es requerido.");
        }

        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}