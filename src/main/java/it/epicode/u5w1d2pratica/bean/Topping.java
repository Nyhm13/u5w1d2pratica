package it.epicode.u5w1d2pratica.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true,exclude = "pizze")
@Entity
public class Topping extends Prodotto{
    private boolean glutenFree;

    @ManyToMany
    // questo mi crea una tabella di join tra Topping e Pizza dove avrò le chiavi verso le altre due tablle
    // il set delle pizze va sempre fatto sul lato mani dove ci sta il join column/joinTable ovvero il lato proprietario della relazione

    @JoinTable(name = "topping_pizza", joinColumns = @JoinColumn(name = "topping_id"),
    inverseJoinColumns = @JoinColumn(name = "pizza_id"))

    private List<Pizza> pizze;
}