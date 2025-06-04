package it.epicode.u5w1d2pratica;


import it.epicode.u5w1d2pratica.bean.*;
import it.epicode.u5w1d2pratica.enumeration.StatoOrdine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component//serve per permettere a Spring di gestire completamente la classe
//tutte le classi con Component vengono istanziate direttamente da Spring e gli
//oggetti creati vengono salvati nel contesto
@Order(1)//deve essere il primo runner ad essere lanciato
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //serve per accedere al contesto di Spring
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(U5w1d2praticaApplication.class);
        //abbiamo recuperato dal contesto di Spring un oggetto di tipo Menu
        Menu menu = ctx.getBean(Menu.class);
        menu.stampaMenu();

        Ordine o1 = new Ordine();
        o1.setNumOrdine(1);
        o1.setNumCoperti(4);
        o1.setOraOrdine(LocalTime.of(21,0,0));
        o1.setStatoOrdine(StatoOrdine.IN_CORSO);
        o1.setTavolo(ctx.getBean("t1", Tavolo.class));
        o1.setProdotti(List.of(ctx.getBean("water", Drink.class),
                ctx.getBean("cocaCola", Drink.class),
                ctx.getBean("margherita", Pizza.class),
                ctx.getBean("primavera", Pizza.class),
                ctx.getBean("primavera", Pizza.class)));

        System.out.println(o1);

        System.out.println(o1.totaleOrdine());



        //recuperare il menu dal contesto e chiamare il metodo per stampare tutto il suo contenuto
    }
}