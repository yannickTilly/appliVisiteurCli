package View.Structure;

public class Prationner {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public Prationner setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Prationner setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return getName();
    }
}
