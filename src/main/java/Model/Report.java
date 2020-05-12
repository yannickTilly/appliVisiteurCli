package Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Report {
    private long id;
    private String description;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private User user;
    private Collection<DrugPresentation> drugPresentations;
    private Pratitionner pratitionner;
    private Region region;
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDate getDate() {
        return date;
    }

    public Report setDate(LocalDate date) {
        this.date = date;
        return this;
    }

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
}