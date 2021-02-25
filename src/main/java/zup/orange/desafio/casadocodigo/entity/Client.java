package zup.orange.desafio.casadocodigo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tables")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String document;
    private String address;
    private String complement;
    private String phone;
    private String cep;

    @ManyToOne
    private City city;

    @ManyToOne
    private Country country;

    @ManyToOne
    private StateOfCountry stateOfCountry;

    public Client() {
    }

    public Client(String email, String name, String surname, String document, String address, String complement, String phone, String cep, City city, Country country, StateOfCountry stateOfCountry) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.phone = phone;
        this.cep = cep;
        this.city = city;
        this.country = country;
        this.stateOfCountry = stateOfCountry;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", cep='" + cep + '\'' +
                ", country=" + country +
                ", stateOfCountry=" + stateOfCountry +
                '}';
    }
}