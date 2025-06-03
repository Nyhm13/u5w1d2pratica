package it.epicode.u5w1d2pratica.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Topping extends Prodotto{
    private boolean glutenFree;
}