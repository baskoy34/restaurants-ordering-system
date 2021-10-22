package ros.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    @Value("${stomp.topic}")
    private String stompTopic;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void send(String message){
        System.out.println("message alındı");
        messagingTemplate.convertAndSend(stompTopic,message);
    }
}
