package messages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderEventMessage {

    private String eventId;
    private Long eventTimestamp;
    private EventType eventType;
    private Long orderId;
    private String orderJson;
}
