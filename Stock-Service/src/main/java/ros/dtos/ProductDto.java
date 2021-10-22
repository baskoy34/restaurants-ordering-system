package ros.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private long id;
    private double quantity;

    public long getId() {
        return id;
    }

    public double getQuantity() {
        return quantity;
    }
}
