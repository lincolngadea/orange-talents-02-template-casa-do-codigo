package zup.orange.desafio.casadocodigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Deprecated
    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public void setName(String name) {this.name = name; }

    public String getName() { return name; }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
