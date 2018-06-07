package com.ssid.api.apissidETL.controller;

import com.ssid.api.apissidETL.command.FilterCommand;
import com.ssid.api.apissidETL.services.ReportService;
import com.ssid.api.apissidETL.util.ApiPath;
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
            mapResponse.put("status", "values");
            mapResponse.put("start", startDate);
            mapResponse.put("end", endDate);
        }
        else {
            mapResponse.put("status", "null");
        }
        //mapResponse.put("data", areaService.save(areaCommand.toArea()));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
