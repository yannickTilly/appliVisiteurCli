package Model;

import java.util.Collection;

public class Pratitionner {
    private long id;

    private Collection<Report> reports;

    private Collection<Diploma> diplomas;

    private String first_name;

    private String last_name;

    public long getId() {
        return id;
    }

    public Pratitionner setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<Report> getReports() {
        return reports;
    }

    public Pratitionner setReports(Collection<Report> reports) {
        this.reports = reports;
        return this;
    }

    public Collection<Diploma> getDiplomas() {
        return diplomas;
    }

    public Pratitionner setDiplomas(Collection<Diploma> diplomas) {
        this.diplomas = diplomas;
        return this;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Pratitionner setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public String getLast_name() {
        return last_name;
    }

    public Pratitionner setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public String getName()
    {
        return this.first_name + " " + this.last_name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
