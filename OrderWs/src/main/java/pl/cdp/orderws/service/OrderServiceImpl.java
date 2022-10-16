package pl.cdp.orderws.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.cdp.orderws.dto.OrderReceived;
import pl.cdp.orderws.entity.Order;
import pl.cdp.orderws.entity.OrderedGame;
import pl.cdp.orderws.repository.OrderRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(OrderReceived gameId) {

        logger.info("Games ordered ");
        Set<OrderedGame> orderedGames = new HashSet<>();
        Order newOrder = new Order();

        if(gameId != null && gameId.getGamesIds() != null) {

            for (String id : gameId.getGamesIds()) {
                OrderedGame singleGame = new OrderedGame();
                singleGame.setGameId(id);
                orderedGames.add(singleGame);
            }

            if (!orderedGames.isEmpty()) {


                newOrder.setUserId("1");
                newOrder.setPrice(1000.);
                newOrder.getGames().addAll(orderedGames);
            }

            orderRepository.save(newOrder);
        }


    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
