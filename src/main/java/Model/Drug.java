package Model;

import java.util.ArrayList;
import java.util.Collection;

public class Drug {

    private long id;

    private String name;

    private String description;

    private Collection<DrugPresentation> drugPresentations;

    public Drug()
    {
        drugPresentations = new ArrayList<DrugPresentation>();
    }

    public long getId() {
        return id;
    }

    public Drug setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<DrugPresentation> getDrugPresentations() {
        return drugPresentations;
    }

    public Drug setDrugPresentations(Collection<DrugPresentation> drugPresentations) {
        this.drugPresentations = drugPresentations;
        return this;
    }

    public String getName() {
        return name;
    }

    public Drug setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Drug setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
