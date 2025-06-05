package it.epicode.u5w1d2pratica;

import it.epicode.u5w1d2pratica.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunnerQuery implements CommandLineRunner {
    @Autowired
    private ProdottoRepository prodottoRepository;

    @Override
    public void run(String... args) throws Exception {

        prodottoRepository.findAll().forEach(System.out::println);

        prodottoRepository.findByCalorieGreaterThan(500).forEach(System.out::println);

        prodottoRepository.findByNomeLike("%la%").forEach(System.out::println);

    }
}
