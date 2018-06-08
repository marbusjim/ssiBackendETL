package com.ssid.api.apissidETL.controller;

import com.ssid.api.apissidETL.services.ReportService;
import com.ssid.api.apissidETL.util.ApiPath;
import com.ssid.api.apissidETL.util.FormatAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.REPORT_TABLE_PATH)
public class ReportTableController {
    private ReportService reportService;

    @Autowired
    public ReportTableController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = {"/incidents/{startDate}/{endDate}"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> GetIncidentForArea(@PathVariable String startDate, @PathVariable String endDate) {
        Map<String, Object> mapResponse = new HashMap<>();


        if(startDate != null && endDate != null)
        {
            if (startDate.matches("\\d{4}-\\d{2}-\\d{2}") && startDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                mapResponse.put("status", "OK");
                mapResponse.put("data", reportService.getTableDataForReport(FormatAux.stringToDate(startDate), FormatAux.stringToDate(endDate)));
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
