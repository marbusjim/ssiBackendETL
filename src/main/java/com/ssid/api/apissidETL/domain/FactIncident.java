package com.ssid.api.apissidETL.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "fact_incident")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "GetIncidentDetails",
                procedureName = "GetIncidentDetails",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "STARTDATE", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ENDDATE", type = Date.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "GetIncidentByArea",
                procedureName = "GetIncidentByArea",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "STARTDATE", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ENDDATE", type = Date.class)
                }
        )
})
public class FactIncident implements Serializable {
    @Id
    @Column(name = "personal_id")
    private long personalID;

    @Id
    @Column(name = "area_id")
    private long areaID;

    @Id
    @Column(name = "position_id")
    private long positionID;

    @Id
    @Column(name = "event_incident_id")
    private long eventIncidentID;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "event_incident_date")
    private Date date;

    public long getPersonalID() {
        return personalID;
    }

    public void setPersonalID(long personalID) {
        this.personalID = personalID;
    }

    public long getAreaID() {
        return areaID;
    }

    public void setAreaID(long areaID) {
        this.areaID = areaID;
    }

    public long getPositionID() {
        return positionID;
    }

    public void setPositionID(long positionID) {
        this.positionID = positionID;
    }

    public long getEventIncidentID() {
        return eventIncidentID;
    }

    public void setEventIncidentID(long eventIncidentID) {
        this.eventIncidentID = eventIncidentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

@Embeddable
class FactIncidentId {
    long personalID;
    long areaID;
    long positionID;
    long eventIncidentID;
}