package pl.sdacademy.service.student.dto;

import java.util.Date;

public class DateDTO {

    Date date;

    public DateDTO() {
    }

    public DateDTO(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
