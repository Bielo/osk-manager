package pl.sdacademy.service.student.dto;

import pl.sdacademy.domain.entity.Teacher;

import java.util.Date;
import java.util.List;

public class DateDTO {

   private Date date;
   private Long teacher;

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

    public Long getTeacher() {
        return teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }
}
