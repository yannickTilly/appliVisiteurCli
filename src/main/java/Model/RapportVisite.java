package Model;


import java.util.ArrayList;
import java.util.Collection;


public class RapportVisite {

    private long id;

    private String note;

    private User user;

    private Collection<PresentationMedicament> presentationMedicaments;

    private Praticien praticien;

    public long getId() {
        return id;
    }

    public RapportVisite setId(long id) {
        this.id = id;
        return this;
    }

    public String getNote() {
        return note;
    }

    public RapportVisite setNote(String note) {
        this.note = note;
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
