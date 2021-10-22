package ros.bus;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import messages.EventType;
import messages.OrderEventMessage;
import org.hibernate.criterion.Order;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import ros.dtos.BasketDto;
import ros.dtos.BasketProductDto;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableBinding(Source.class)
public class OrderEvent {
    private final Source source;
    private final Gson gson;

    public void orderCreated(Long id, BasketProductDto basketDto) {
        OrderEventMessage orderEventMessage = OrderEventMessage.builder()
                .eventId(UUID.randomUUID().toString())
                .eventTimestamp(System.currentTimeMillis())
                .eventType(EventType.CREATED)
                .orderId(id)
                .orderJson(gson.toJson(basketDto))
                .build();

        sendToBus(id, orderEventMessage);
    }

    public void orderUpdated(Long id, BasketProductDto basketDto) {
        OrderEventMessage orderEventMessage = OrderEventMessage.builder()
                .eventId(UUID.randomUUID().toString())
                .eventTimestamp(System.currentTimeMillis())
                .eventType(EventType.UPDATED)
                .orderId(id)
                .orderJson(gson.toJson(basketDto))
                .build();

        sendToBus(id, orderEventMessage);
    }

    public void orderDeleted(Long id) {
        OrderEventMessage orderEventMessage = OrderEventMessage.builder()
                .eventId(UUID.randomUUID().toString())
                .eventTimestamp(System.currentTimeMillis())
                .eventType(EventType.DELETED)
                .orderId(id)
                .build();

        sendToBus(id, orderEventMessage);
    }

    private void sendToBus(Long partitionKey, OrderEventMessage orderEventMessage) {
        Message<OrderEventMessage> message = MessageBuilder.withPayload(orderEventMessage)
                .setHeader("partitionKey", partitionKey)
                .build();
        source.output().send(message);
        log.info("\n---\nHeaders: {}\n\nPayload: {}\n---", message.getHeaders(), message.getPayload());
    }
}
