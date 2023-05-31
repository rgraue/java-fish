package fishapp.models;

import javax.persistence.*;

@Entity
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String Name;

    public Fish(String name) {
        this.Name = name;
    }

    public Fish (){}

    public void setId(int id) {
        this.Id = id;
    }

    @Id
    public int getId() {
        return this.Id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public String toString () {
        return String.format("%s....%s", this.Name, this.Id);
    }

}
