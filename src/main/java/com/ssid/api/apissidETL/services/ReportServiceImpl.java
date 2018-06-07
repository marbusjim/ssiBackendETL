package com.ssid.api.apissidETL.services;

import com.ssid.api.apissidETL.domain.DimArea;
import com.ssid.api.apissidETL.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    /*private ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
*/
    /*@Transactional
    @Override
    public List<DimArea> findAllArea() {
        List<DimArea> results = new ArrayList<>();
        reportRepository.findAll().forEach(results::add);
        return results;
    }*/
}
