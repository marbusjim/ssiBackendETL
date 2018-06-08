package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.DTO.RepoTableDTO;
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

        //TODO: agregar mapeo de los sp
        return res;
    }

    @Override
    public List<RepoTableDTO> getTableDataForReport(Date startDate, Date endDate) {
        List<RepoTableDTO> res = new ArrayList<>();

        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("GetIncidentDetails");
        query.setParameter("STARTDATE", startDate);
        query.setParameter("ENDDATE", endDate);
        query.execute();

        res = mapear(query.getResultList());

        return res;
    }

    private List<RepoTableDTO> mapear(List<Object[]> resultList) {
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
}