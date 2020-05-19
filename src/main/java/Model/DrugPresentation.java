package Model;


import com.fasterxml.jackson.annotation.JsonView;


public class DrugPresentation {

    private long id;

    private String label;

    private Drug drug;

    private Report report;

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Drug getDrug() {
        return drug;
    }

    public DrugPresentation setDrug(Drug drug) {
        this.drug = drug;
        return this;
    }

    public Report getReport() {
        return report;
    }

    public DrugPresentation setReport(Report report) {
        this.report = report;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public DrugPresentation setLabel(String label) {
        this.label = label;
        return this;
    }
}
