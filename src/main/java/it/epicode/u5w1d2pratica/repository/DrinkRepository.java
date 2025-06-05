package it.epicode.u5w1d2pratica.repository;

import it.epicode.u5w1d2pratica.bean.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink,Integer> {
}
