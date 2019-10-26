package Model;


import java.util.Collection;

public class User {
    private long id;

    private String nom;

    private String login;

    private int numeroVoie;

    private String typeVoie;

    private String nomVoie;

    private String codePostal;

    private String ville;

    private Collection<RapportVisite> rapportVisites ;

    private Collection<PeriodeTravaillee> periodeTravaillees;
}
