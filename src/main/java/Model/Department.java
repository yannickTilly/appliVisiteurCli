package Model;

import java.util.Collection;

public class Department {
    private long id;

    private String code;

    private String name;

    private Collection<WorkedTime> workedTimes;

    public long getId() {
        return id;
    }

    public Department setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<WorkedTime> getWorkedTimes() {
        return workedTimes;
    }

    public Department setWorkedTimes(Collection<WorkedTime> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Department setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }
}
