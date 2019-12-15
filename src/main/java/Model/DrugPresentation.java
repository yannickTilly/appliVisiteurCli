package Model;

import com.fasterxml.jackson.annotation.JsonView;

public class DrugPresentation {

    private long id;


    private Drug drug;


    private Report report;

    public Drug getDrug() {
        return drug;
    }

    public DrugPresentation setDrug(Drug drug) {
        this.drug = drug;
        return this;
    }

    public long getId() {
        return id;
    }

    public DrugPresentation setId(long id) {
        this.id = id;
        return this;
    }

    public Report getReport() {
        return report;
    }

    public DrugPresentation setReport(Report report) {
        this.report = report;
        return this;
    }
}
