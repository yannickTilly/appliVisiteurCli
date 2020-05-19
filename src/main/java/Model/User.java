package Model;

import java.util.Collection;


public class User {

    private long id;

    private String prenom;

    private String nom;

    private String login;

    private String password;

    private String codePostal;

    private String ville;

    private String hiringDate;

    private String matricule;

    private Collection<Report> reports;

    private Collection<WorkedTime> workedTimes;

    private Region region;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public User setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public User setCodePostal(String codePostal) {
        this.codePostal = codePostal;
        return this;
    }

    public String getVille() {
        return ville;
    }

    public User setVille(String ville) {
        this.ville = ville;
        return this;
    }

    public Collection<Report> getReports() {
        return reports;
    }

    public User setReports(Collection<Report> reports) {
        this.reports = reports;
        return this;
    }

    public Collection<WorkedTime> getWorkedTimes() {
        return workedTimes;
    }

    public User setWorkedTimes(Collection<WorkedTime> workedTimes) {
        this.workedTimes = workedTimes;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public User setRegion(Region region) {
        this.region = region;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public User setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public User setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
        return this;
    }

    public String getMatricule() {
        return matricule;
    }

    public User setMatricule(String matricule) {
        this.matricule = matricule;
        return this;
    }
}
