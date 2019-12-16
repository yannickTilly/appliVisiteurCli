package Model;

import java.util.Collection;

public class ConsultationDrugModel {
    Collection<Drug> drugs;

    public Collection<Drug> getDrugs() {
        return drugs;
    }

    public ConsultationDrugModel setDrugs(Collection<Drug> drugs) {
        this.drugs = drugs;
        return this;
    }
}
