package View.Structure;

public class Pratitionner {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public Pratitionner setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pratitionner setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return getName();
    }
}
