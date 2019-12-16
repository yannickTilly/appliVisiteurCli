package Model.RequestBody;

import java.util.Collection;

public class ReportBody {
    private Collection<Long> MedicamentId;
    private Long praticienId;
    private String note;
    private int sampleNumber;

    public Collection<Long> getMedicamentId() {
        return MedicamentId;
    }

    public ReportBody setMedicamentId(Collection<Long> medicamentId) {
        MedicamentId = medicamentId;
        return this;
    }

    public Long getPraticienId() {
        return praticienId;
    }

    public ReportBody setPraticienId(Long praticienId) {
        this.praticienId = praticienId;
        return this;
    }

    public String getNote() {
        return note;
    }

    public ReportBody setNote(String note) {
        this.note = note;
        return this;
    }

    public int getSampleNumber() {
        return sampleNumber;
    }

    public ReportBody setSampleNumber(int sampleNumber) {
        this.sampleNumber = sampleNumber;
        return this;
    }
}

