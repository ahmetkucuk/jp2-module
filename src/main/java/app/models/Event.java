package app.models;

import app.utils.CoordinateSystemConverter;
import app.utils.Utilities;
import com.sun.tools.javac.code.Attribute;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by ahmetkucuk on 01/10/15.
 */
public class Event {

    private EventType eventType;
    private String coordinateString;
    private String imageFileString;
    private Coordinate[] coordinates;
    private String startDateString;
    private String endDateString;
    private Date startDate;
    private Date endDate;
    private String sFileName;
    private String mFileName;
    private String eFileName;

    private int id;

    private String measurement;

    public String getImageFileName() {
        return getEventType().toString() + "_" + getId();
    }

    public Date getMiddleDate() {
        if(startDate == null || endDate == null) {
            System.err.println("Essential paramaters are null. This will change the behaviour of software");
            return startDate;
        }

        Date middleDate = new Date(startDate.getTime()/2 + endDate.getTime()/2);
        return  middleDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDate) {
        this.startDateString = startDate;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDate) {
        this.endDateString = endDate;
    }

    public String getImageFileString() {
        return imageFileString;
    }

    public String getImageFilePNGString() {
        return imageFileString.replace(".jpg", ".png");
    }

    public void setImageFileString(String imageFileString) {
        this.imageFileString = imageFileString;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getMeasurement() {
        return measurement;

//        if(measurement == null) return String.valueOf(eventType.getMeasurement());
//        if(measurement.contains("_THIN")) return  measurement.replace("_THIN", "");
//        if(Utilities.isNumeric(measurement)) return measurement;
//
//        return String.valueOf(eventType.getMeasurement());
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getCoordinateString() {
        return coordinateString;
    }

    public void setCoordinateString(String coordinateString) {
        this.coordinateString = coordinateString;
    }

    public Coordinate[] getCoordinates() {
        if(coordinates == null) {
            if(coordinateString == null) {
                System.err.println("Coordinate String is null");
                return null;
            }
            coordinates = Utilities.parseCoordinatesString(coordinateString);
        }
        return coordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsFileName() {
        return sFileName;
    }

    public void setsFileName(String sFileName) {
        this.sFileName = sFileName;
    }

    public String getmFileName() {
        return mFileName;
    }

    public void setmFileName(String mFileName) {
        this.mFileName = mFileName;
    }

    public String geteFileName() {
        return eFileName;
    }

    public void seteFileName(String eFileName) {
        this.eFileName = eFileName;
    }

    @Override
    public String toString() {
        String pixelPolygon = Utilities.polygonToString(this);
        return getId() + "\t" + getEventType().toString() + "\t" + getStartDateString() + "\t" + getEndDateString() + "\t" + measurement + "\t" + pixelPolygon + "\t" + sFileName + "\t" + mFileName + "\t" + eFileName;
    }
}
