package Model;

import java.util.Date;


public class WorkedTime {

    private long id;

    private User user;

    private Department department;

    private Region region;

    private Date dateStart;

    private Date dateEnd;



    public long getId() {
        return id;
    }

    public WorkedTime setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public WorkedTime setUser(User user) {
        this.user = user;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    public WorkedTime setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public WorkedTime setRegion(Region region) {
        this.region = region;
        return this;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public WorkedTime setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public WorkedTime setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }
}

