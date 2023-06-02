package fishapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @Column(name = "firstname")
    private String FirstName;

    @Column(name = "lastname")
    private String LastName;

    @Column(name = "email")
    private String Email;

    @Column(name = "password")
    private String Password;

    public User (){
    }

    public User (
        String email,
        String password,
        String first,
        String last
    ){
        this.Email = email;
        this.Password = password;
        this.FirstName = first;
        this.LastName = last;
    }

    public void setId(int id) {
        this.Id = id;
    }

    @Id
    public int getId() {
        return this.Id;
    }

    public void setFirstName(String first) {
        this.FirstName = first;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setLastName(String last) {
        this.LastName = last;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return this.Password;
    }
}
