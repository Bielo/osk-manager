package pl.sdacademy.service.teacher.dto;

import java.util.Date;

public class CreateScheduleDTO {

    private Date day;
    private String startWorkHour;
    private String stopWorkHour;

    public CreateScheduleDTO() {
    }

    public CreateScheduleDTO(Date day, String startWorkHour, String stopWorkHour) {
        this.day = day;
        this.startWorkHour = startWorkHour;
        this.stopWorkHour = stopWorkHour;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getStartWorkHour() {
        return startWorkHour;
    }

    public void setStartWorkHour(String startWorkHour) {
        this.startWorkHour = startWorkHour;
    }

    public String getStopWorkHour() {
        return stopWorkHour;
    }

    public void setStopWorkHour(String stopWorkHour) {
        this.stopWorkHour = stopWorkHour;
    }
}
