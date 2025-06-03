package it.epicode.u5w1d2pratica.bean;

import it.epicode.u5w1d2pratica.enumeration.StatoTavolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int numeroMaxCoperti;
    private StatoTavolo statoTavolo;
    private double costoCoperto;
}