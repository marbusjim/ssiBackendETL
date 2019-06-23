package com.ssid.api.apissidETL.DTO;

import java.util.Date;

public class RepoTableDTO {
    private Date incidentDate;
    private String personalFullName;
    private String personalStatus;
    private int personalAge;
    private String type;
    private String areaName;
    private String incidentDetail;
    private String incidentSeverity;
    private String incidentReportedBy;
    private String positionName;
    private String positionParent;

    public String getPersonalFullName() {
        return personalFullName;
    }

    public void setPersonalFullName(String personalFullName) {
        this.personalFullName = personalFullName;
    }

    public String getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }

    public int getPersonalAge() {
        return personalAge;
    }

    public void setPersonalAge(int personalAge) {
        this.personalAge = personalAge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getIncidentDetail() {
        return incidentDetail;
    }

    public void setIncidentDetail(String incidentDetail) {
        this.incidentDetail = incidentDetail;
    }

    public String getIncidentReportedBy() {
        return incidentReportedBy;
    }

    public void setIncidentReportedBy(String incidentReportedBy) {
        this.incidentReportedBy = incidentReportedBy;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionParent() {
        return positionParent;
    }

    public void setPositionParent(String positionParent) {
        this.positionParent = positionParent;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentSeverity() {
        return incidentSeverity;
    }

    public void setIncidentSeverity(String incidentSeverity) {
        this.incidentSeverity = incidentSeverity;
    }
}
