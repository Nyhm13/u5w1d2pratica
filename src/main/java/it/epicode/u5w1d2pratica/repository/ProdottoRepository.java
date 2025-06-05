package it.epicode.u5w1d2pratica.repository;

import it.epicode.u5w1d2pratica.bean.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto,Integer> {

    List<Prodotto> findByCalorieGreaterThan(int calorie);

    List<Prodotto> findByNomeLike(String nome);
}
