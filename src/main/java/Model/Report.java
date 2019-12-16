package Model;

import java.util.ArrayList;
import java.util.Collection;

public class Report {

    private long id;

    private String description;

    private User user;

    private Collection<DrugPresentation> drugPresentations;

    private Pratitionner pratitionner;

    private Region region;

    private int sampleNumber;


    public String getDescription() {
        return description;
    }

    public Report setDescription(String description) {
        this.description = description;
        return this;
    }

    public Report()
    {
        drugPresentations = new ArrayList<DrugPresentation>();
    }
    public long getId() {
        return id;
    }

    public Report setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Report setUser(User user) {
        this.user = user;
        return this;
    }

    public Collection<DrugPresentation> getDrugPresentations() {
        return drugPresentations;
    }

    public Report setDrugPresentations(Collection<DrugPresentation> drugPresentations) {
        this.drugPresentations = drugPresentations;
        return this;
    }

    public Pratitionner getPratitionner() {
        return pratitionner;
    }

    public Report setPratitionner(Pratitionner pratitionner) {
        this.pratitionner = pratitionner;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Report setRegion(Region region) {
        this.region = region;
        return this;
    }

    public int getSampleNumber() {
        return sampleNumber;
    }

    public Report setSampleNumber(int sampleNumber) {
        this.sampleNumber = sampleNumber;
        return this;
    }
}
