package org.launchcode.techjobs.persistent.models;

import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Employer extends AbstractEntity {

    @Id @NotEmpty @NotNull @Size(min = 0, max = 70)
    private String location;

    @OneToMany @JoinColumn(name = "employer_id")
    private final List<Job> jobs = new ArrayList<>();

    public Employer () {};

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void save(EmployerRepository employerRepository) {
    }
}
