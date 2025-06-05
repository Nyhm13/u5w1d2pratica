package it.epicode.u5w1d2pratica.repository;

import it.epicode.u5w1d2pratica.bean.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
}
