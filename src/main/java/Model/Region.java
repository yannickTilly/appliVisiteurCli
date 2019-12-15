package Model;

import java.util.Collection;

public class Region {
    private long id;

    private String code;

    private String name;

    private Collection<WorkedTime> workedTimes;

    private Sector sector;

    private Collection<User> delegues;

    private Collection<Report> reports;



    public long getId() {
        return id;
    }

    public Region setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<WorkedTime> getWorkedTimes() {
        return workedTimes;
    }

    public Region setWorkedTimes(Collection<WorkedTime> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }

    public Sector getSector() {
        return sector;
    }

    public Region setSector(Sector sector) {
        this.sector = sector;
        return this;
    }

    public Collection<User> getDelegues() {
        return delegues;
    }

    public Region setDelegues(Collection<User> delegues) {
        this.delegues = delegues;
        return this;
    }

    public Collection<Report> getReports() {
        return reports;
    }

    public Region setReports(Collection<Report> reports) {
        this.reports = reports;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Region setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }
}
