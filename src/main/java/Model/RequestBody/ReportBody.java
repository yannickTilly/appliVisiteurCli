package Model.RequestBody;

import java.time.LocalDate;
import java.util.Collection;

public class ReportBody {
    private String label;
    private Collection<Long> medicamentIds;
    private Long praticienId;
    private String note;
    private int sampleNumber;
    private String date;

    public String getDate() {
        return date;
    }

    public ReportBody setDate(String date) {
        this.date = date;
        return this;
    }

    public Collection<Long> getMedicamentIds() {
        return medicamentIds;
    }

    public ReportBody setMedicamentIds(Collection<Long> medicamentIds) {
        this.medicamentIds = medicamentIds;
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

    public String getLabel() {
        return label;
    }

    public ReportBody setLabel(String label) {
        this.label = label;
        return this;
    }
}

