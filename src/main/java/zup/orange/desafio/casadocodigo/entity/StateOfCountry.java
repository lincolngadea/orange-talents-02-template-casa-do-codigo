package zup.orange.desafio.casadocodigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class StateOfCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Country country;

    @Deprecated
    public StateOfCountry() {
    }

    public StateOfCountry(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
