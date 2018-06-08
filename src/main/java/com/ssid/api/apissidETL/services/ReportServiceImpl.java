package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.dto.RepoChartDTO;
import com.ssid.api.apissidETL.dto.RepoTableDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RepoChartDTO> getChartDataForReport(Date startDate, Date endDate) {
        List<RepoChartDTO> res = new ArrayList<>();

        //TODO: agregar mapeo de los sp
        return res;
    }

    @Override
    public List<RepoTableDTO> getTableDataForReport(Date startDate, Date endDate) {
        List<RepoTableDTO> res = new ArrayList<>();

        //TODO: agregar mapeo de los sp
        return res;
    }
}