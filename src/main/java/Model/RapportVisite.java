package Model;


import java.util.Collection;


public class RapportVisite {

    private long id;

    private String description;

    private User user;

    private Collection<PresentationMedicament> presentationMedicaments;

    private Praticien praticien;

    private int sampleNumbers;

    public int getSampleNumbers() {
        return sampleNumbers;
    }

    public RapportVisite setSampleNumbers(int sampleNumbers) {
        this.sampleNumbers = sampleNumbers;
        return this;
    }

    public long getId() {
        return id;
    }

    public RapportVisite setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RapportVisite setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public RapportVisite setUser(User user) {
        this.user = user;
        return this;
    }

    public Collection<PresentationMedicament> getPresentationMedicaments() {
        return presentationMedicaments;
    }

    public RapportVisite setPresentationMedicaments(Collection<PresentationMedicament> presentationMedicaments) {
        this.presentationMedicaments = presentationMedicaments;
        return this;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public RapportVisite setPraticien(Praticien praticien) {
        this.praticien = praticien;
        return this;
    }
}
