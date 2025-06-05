package it.epicode.u5w1d2pratica.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Prodotto {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private double prezzo;
    private int calorie;
}