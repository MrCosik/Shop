package repository;

import entity.OrderedGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedGameRepository extends JpaRepository<OrderedGame, Long> {
}
