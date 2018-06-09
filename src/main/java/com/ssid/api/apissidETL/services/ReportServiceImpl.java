package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.DTO.RepoTableDTO;
import com.ssid.api.apissidETL.DTO.ResultDTO;
import com.ssid.api.apissidETL.dto.DataChart;
import com.ssid.api.apissidETL.dto.DataSerie;
import com.ssid.api.apissidETL.dto.RepoChartDTO;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DataChart> getChartDataForReport(String startDate, String endDate) {
        List<DataChart> res = new ArrayList<>();

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("GetIncidentByArea");
        query.setParameter("STARTDATE", startDate);
        query.setParameter("ENDDATE", endDate);

        query.execute();

        res = mapearRepoChart(query.getResultList());

        return  res;
    }

    @Override
    public List<RepoTableDTO> getTableDataForReport(String startDate, String endDate) {
        List<RepoTableDTO> res = new ArrayList<>();

        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("GetIncidentDetails");
        query.setParameter("STARTDATE", startDate);
        query.setParameter("ENDDATE", endDate);
        query.execute();

        res = mapearRepoTable(query.getResultList());

        return res;
    }

    private List<DataChart> mapearRepoChart(List<Object[]> resultList) {
        List<DataChart> result = new ArrayList<>();

        if(resultList != null) {
            HashMap<String, DataChart> aux = new HashMap<>();

            for (Object[] res : resultList) {
                if(aux.containsKey((String)res[2]))
                {
                    DataChart dcAux = aux.get((String)res[2]);

                    DataSerie ds = new DataSerie();
                    ds.setName((String)res[1]);
                    ds.setValue((int)res[0]);

                    dcAux.getSeries().add(ds);
                }
                else{
                    DataChart data = new DataChart();
                    data.setName((String)res[2]);
                    List<DataSerie> dsl = new ArrayList<>();
                    DataSerie ds = new DataSerie();
                    ds.setName((String)res[1]);
                    ds.setValue((int)res[0]);
                    dsl.add(ds);
                    data.setSeries(dsl);

                    aux.put((String)res[2], data);
                }
            }

            for (DataChart dcaux:
                    aux.values()) {
                result.add(dcaux);
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