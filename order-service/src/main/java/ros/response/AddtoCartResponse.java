package ros.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddtoCartResponse {
    private long basketId;
    private double totalPrice;
    private int responseStatus;
    private String responseMessage;
    private int itemCount;
}
