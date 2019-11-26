package Model.RequestBody;

import java.util.Collection;

public class VisitorReportBody {
    private Collection<Long> MedicamentId;
    private Long praticienId;
    private String note;
    private int sampleNumber;

    public Collection<Long> getMedicamentId() {
        return MedicamentId;
    }

    public VisitorReportBody setMedicamentId(Collection<Long> medicamentId) {
        MedicamentId = medicamentId;
        return this;
    }

    public Long getPraticienId() {
        return praticienId;
    }

    public VisitorReportBody setPraticienId(Long praticienId) {
        this.praticienId = praticienId;
        return this;
    }

    public String getNote() {
        return note;
    }

    public VisitorReportBody setNote(String note) {
        this.note = note;
        return this;
    }

    public int getSampleNumber() {
        return sampleNumber;
    }

    public VisitorReportBody setSampleNumber(int sampleNumber) {
        this.sampleNumber = sampleNumber;
        return this;
    }
}

