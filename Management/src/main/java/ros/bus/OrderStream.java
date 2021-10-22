package ros.bus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import ros.service.WebSocketService;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableBinding(Sink.class)
public class OrderStream {
    @Autowired
    private WebSocketService websocketService;

    @StreamListener(Sink.INPUT)
    public void process(Message<String> message) {
        log.info("\n---\nHeaders: {}\n\nPayload: {}\n---", message.getHeaders(), message.getPayload());
        System.out.println(message.getPayload());
        websocketService.send(message.getPayload());

    }

}
