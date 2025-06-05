package it.epicode.u5w1d2pratica;

import it.epicode.u5w1d2pratica.bean.Drink;
import it.epicode.u5w1d2pratica.bean.Pizza;
import it.epicode.u5w1d2pratica.bean.Topping;
import it.epicode.u5w1d2pratica.repository.DrinkRepository;
import it.epicode.u5w1d2pratica.repository.PizzaRepository;
import it.epicode.u5w1d2pratica.repository.ProdottoRepository;
import it.epicode.u5w1d2pratica.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class RunnerD4 implements CommandLineRunner {

    // mi innietto le dipendenze delle repository quando si crea l'istanza del runner
//    @Autowired
//    private PizzaRepository pizzaRepository;
//
//    @Autowired
//    private DrinkRepository drinkRepository;
//
//    @Autowired
//    private ToppingRepository toppingRepository;

    @Autowired
    private ProdottoRepository prodottoRepository;

    //--------------------------- mi creo oggetti tramite autowired e qualifier per popolare il database ---------------------------
    //-------PIZZE-------
    @Autowired
    @Qualifier("margherita")
    private Pizza margherita;


    @Autowired
    @Qualifier("primavera")
    private  Pizza primavera;

    //--------Drinks--------
    @Autowired
    @Qualifier("cocaCola")
    private Drink cocaCola;

    @Autowired
    @Qualifier("water")
    private  Drink water;


    //--------Toppings--------

    @Autowired
    @Qualifier("tomato")
    private Topping tomato;

    @Autowired
    @Qualifier("mozzarella")
    private Topping mozzarella;

    @Autowired
    @Qualifier("prosciuttoCotto")
    private Topping prosciuttoCotto;


    @Override
    public void run(String... args) throws Exception {



        // Salvo le pizze nel database
        prodottoRepository.save(margherita);
        prodottoRepository.save(primavera);

        // Salvo i drinks nel database
        prodottoRepository.save(water);
        prodottoRepository.save(cocaCola);

        // salvo le pizze sui toppings
        mozzarella.setPizze(List.of(margherita,primavera));
        tomato.setPizze(List.of(margherita,primavera));
        prosciuttoCotto.setPizze(List.of(primavera));

        // salvo i toppings nel database
        prodottoRepository.save(tomato);
        prodottoRepository.save(mozzarella);
        prodottoRepository.save(prosciuttoCotto);






    }
}
