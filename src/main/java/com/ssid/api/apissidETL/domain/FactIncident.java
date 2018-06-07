package com.ssid.api.apissidETL.domain;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "FactIncident")
public class FactIncident implements Serializable {
//    @Id
//    @Column(name = "PersonalID")
    private long personalID;

//    @Id
//    @Column(name = "AreaID")
    private long areaID;

//    @Id
//    @Column(name = "PositionID")
    private long positionID;

//    @Id
//    @Column(name = "EventIncidentID")
    private long eventIncidentID;

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
}

//@Embeddable
//class FactIncidentId {
//    long personalID;
//    long areaID;
//    long positionID;
//    long eventIncidentID;
//}