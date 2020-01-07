package Model;

import com.fasterxml.jackson.annotation.JsonView;


public class Sector {

    private long id;

    private String code;

    private String name;

    public long getId() {
        return id;
    }

    public Sector setId(long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Sector setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sector setName(String name) {
        this.name = name;
        return this;
    }
}
