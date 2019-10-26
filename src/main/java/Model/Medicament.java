package Model;

import java.util.ArrayList;
import java.util.Collection;

public class Medicament {
    private long id;

    private Collection<PresentationMedicament> presentationMedicaments;

    public Medicament()
    {
        presentationMedicaments = new ArrayList<PresentationMedicament>();
    }

    public long getId() {
        return id;
    }

    public Medicament setId(long id) {
        this.id = id;
        return this;
    }

    public Collection<PresentationMedicament> getPresentationMedicaments() {
        return presentationMedicaments;
    }

    public Medicament setPresentationMedicaments(Collection<PresentationMedicament> presentationMedicaments) {
        this.presentationMedicaments = presentationMedicaments;
        return this;
    }
}
