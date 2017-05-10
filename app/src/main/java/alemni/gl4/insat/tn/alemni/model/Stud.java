package alemni.gl4.insat.tn.alemni.model;


import java.io.Serializable;
/**
 * Created by Lenovo on 09/05/2017.
 */

public class Stud implements Serializable {

    public Stud() {
    }

    public Stud(String image, String email, String login, String nom, String prenom, String password, String accepte) {
        this.image = image;
        this.email = email;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.accepte = accepte;
    }

    @Override
    public String toString() {
        return "Stud{" +
                "image='" + image + '\'' +

                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", password='" + password + '\'' +
                ", accepte='" + accepte + '\'' +
                '}';
    }

    private String image;



        private String email;
    private String login;
    private String nom;
    private String prenom;
    private String password;
    private String accepte;
    public Stud(String email, String login, String nom, String prenom, String password, String accepte) {
        super();
        this.email = email;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.accepte = accepte;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAccepte() {
        return accepte;
    }
    public void setAccepte(String accepte) {
        this.accepte = accepte;
    }

}