package ca.ericthomas;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Simple class to represent a student's education. This class
 * represents a single diploma, certificate or degree. Students
 * may have many of these.
 * <p>
 * Education has the following attributes:
 * - ID - for DB purposes, primary key
 * - Title - program title. ie. "Accelerated Software Development"
 * - Institution - name of institution, university, college or school
 * - Location - location of institution, university, college or school
 * - Start Date - when the program started
 * - End Date - when the program ended
 *
 * @author Eric Thomas
 */
@Entity(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String institution;
    private String location;

    @JsonFormat(pattern = "yyyy-MM-dd")  //yyyy-MM-dd
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")  //yyyy-MM-dd
    private LocalDate endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
