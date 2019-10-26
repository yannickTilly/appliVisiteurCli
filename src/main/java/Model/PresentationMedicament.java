package Model;



public class PresentationMedicament {
private long id;

    private Medicament medicament;

    private  RapportVisite rapportVisite;

    public long getId() {
        return id;
    }

    public PresentationMedicament setId(long id) {
        this.id = id;
        return this;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public PresentationMedicament setMedicament(Medicament medicament) {
        this.medicament = medicament;
        return this;
    }

    public RapportVisite getRapportVisite() {
        return rapportVisite;
    }

    public PresentationMedicament setRapportVisite(RapportVisite rapportVisite) {
        this.rapportVisite = rapportVisite;
        return this;
    }
}
