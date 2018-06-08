package com.ssid.api.apissidETL.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dim_event_incident")
public class DimEventIncident {
    @Id
    @Column(name = "event_incident_id")
    private long id;

    @Column(name = "event_incident_detail")
    private String detail;

    @Column(name = "event_incident_severity", length = 150)
    private String severity;

    @Column(name = "event_incident_reported_by", length = 50)
    private String reportedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }
}
