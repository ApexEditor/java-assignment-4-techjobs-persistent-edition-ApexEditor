package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank @NotNull @Size(min = 1, max = 300)
    public String description;

    @ManyToMany (mappedBy = "skills")
    private final List<Job> jobs = new ArrayList<>();

    public Skill(){
    };

//    public List<Job> getJobs() {
//        return jobs;
//    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}