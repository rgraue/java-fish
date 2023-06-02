package fishapp.models;

import javax.persistence.*;

@Entity
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int Id;

    @Column(name = "user_id")
    private String UserId;

    @Column(name = "species")
    private String Species;

    @Column(name = "length")
    private double Length;

    @Column(name = "weight")
    private double Weight;

    public Fish() {
    }

    public Fish(String species) {
        this.Species = species;
    }

    public void setId(int id) {
        this.Id = id;
    }

    @Id
    public int getId() {
        return this.Id;
    }

    public void setSpecies(String species) {
        this.Species = species;
    }

    public String getSpecies() {
        return this.Species;
    }

    public void setLength(double length) {
        this.Length = length;
    }

    public double getLength() {
        return this.Length;
    }

    public void setWeight(double weigth) {
        this.Weight = weigth;
    }

    public double getWeight() {
        return this.Weight;
    }

    @Override
    public String toString() {
        return String.format("%s....%s\n", this.Species, this.Id);
    }

}
