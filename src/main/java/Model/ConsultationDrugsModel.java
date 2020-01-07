package Model;

import java.util.Collection;

public class ConsultationDrugsModel {
    Collection<Drug> drugs;

    public Collection<Drug> getDrugs() {
        return drugs;
    }

    public ConsultationDrugsModel setDrugs(Collection<Drug> drugs) {
        this.drugs = drugs;
        return this;
    }
}
