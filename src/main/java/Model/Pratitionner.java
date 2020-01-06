package Model;

import java.util.Collection;

public class Pratitionner {
    private long id;
    private Collection<Report> reports;
    private Collection<Diploma> diplomas;
    private String firstName;

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

    public String getFirstName() {
        return firstName;
    }

    public Pratitionner setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
