package pl.cdp.orderws.repository;

import pl.cdp.orderws.entity.OrderedGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedGameRepository extends JpaRepository<OrderedGame, Long> {
}
