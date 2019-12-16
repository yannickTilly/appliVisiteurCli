package Model;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Collection;

public class Diploma {

    private long id;

    private String name;

    private String speciality;

    private Collection<Pratitionner> pratitionners;

    public long getId() {
        return id;
    }

    public Diploma setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diploma setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Diploma setSpeciality(String speciality) {
        this.speciality = speciality;
        return this;
    }

    public Collection<Pratitionner> getPratitionners() {
        return pratitionners;
    }

    public Diploma setPratitionners(Collection<Pratitionner> pratitionners) {
        this.pratitionners = pratitionners;
        return this;
    }
}
