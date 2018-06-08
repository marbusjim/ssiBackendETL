package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.DTO.RepoTableDTO;
import com.ssid.api.apissidETL.DTO.ResultDTO;
import com.ssid.api.apissidETL.dto.RepoChartDTO;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
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

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("GetIncidentByArea");
        query.setParameter("STARTDATE", startDate);
        query.setParameter("ENDDATE", endDate);

        query.execute();

        res = mapearRepoChart(query.getResultList());

        return  res;
    }

    @Override
    public List<RepoTableDTO> getTableDataForReport(Date startDate, Date endDate) {
        List<RepoTableDTO> res = new ArrayList<>();

        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("GetIncidentDetails");
        query.setParameter("STARTDATE", startDate);
        query.setParameter("ENDDATE", endDate);
        query.execute();

        res = mapearRepoTable(query.getResultList());

        return res;
    }

    private List<RepoChartDTO> mapearRepoChart(List<Object[]> resultList) {
        List<RepoChartDTO> result = new ArrayList<>();

        if(resultList != null) {
            for (Object[] res : resultList) {
                RepoChartDTO data = new RepoChartDTO();
                data.setNumIncidents((int)res[0]);
                data.setType((String)res[1]);
                data.setAreaName((String)res[2]);
                result.add(data);
            }
        }

        return result;
    }

    private List<RepoTableDTO> mapearRepoTable(List<Object[]> resultList) {
        List<RepoTableDTO> result = new ArrayList<>();

        if(resultList != null) {
            for (Object[] res : resultList) {
                RepoTableDTO data = new RepoTableDTO();
                data.setIncidentDate((Date)res[0]);
                data.setPersonalFullName((String)res[1]);
                data.setPersonalStatus((String)res[2]);
                data.setPersonalAge((int)res[3]);
                data.setType((String)res[4]);
                data.setAreaName((String)res[5]);
                data.setIncidentDetail((String)res[6]);
                data.setIncidentSeverity((String)res[7]);
                data.setIncidentReportedBy((String)res[8]);
                data.setPositionName((String)res[9]);
                data.setPositionParent((String)res[10]);
                result.add(data);
            }
        }

        return result;
    }

    @Override
    public List<ResultDTO> getAmountsIncidentBySeverity() {
        List<ResultDTO> res = new ArrayList<>();

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("GetAmountIncidentBySeverity");
        query.execute();

        res = mapResults(query.getResultList());
        return  res;
    }

    @Override
    public List<ResultDTO> getAmountsIncidentByType() {
        List<ResultDTO> res = new ArrayList<>();

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("GetAmountIncidentByType");
        query.execute();

        res = mapResults(query.getResultList());
        return  res;
    }

    private List<ResultDTO> mapResults(List<Object[]> resultList) {
        List<ResultDTO> result = new ArrayList<>();

        if(resultList != null) {
            for (Object[] res : resultList) {
                ResultDTO data = new ResultDTO();
                data.setDescription((String)res[0]);
                data.setAmount((int)res[1]);
                result.add(data);
            }
        }

        return result;
    }
}