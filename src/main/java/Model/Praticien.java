package Model;

import java.util.Collection;


public class Praticien {

    private long id;

    private Collection<RapportVisite> rapportVisites;

    private Collection<Diplome> diplomes;

    public long getId() {
        return id;
    }

    public Praticien setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<RapportVisite> getRapportVisites() {
        return rapportVisites;
    }

    public Praticien setRapportVisites(Collection<RapportVisite> rapportVisites) {
        this.rapportVisites = rapportVisites;
        return this;
    }

    public Collection<Diplome> getDiplomes() {
        return diplomes;
    }

    public Praticien setDiplomes(Collection<Diplome> diplomes) {
        this.diplomes = diplomes;
        return this;
    }
}
