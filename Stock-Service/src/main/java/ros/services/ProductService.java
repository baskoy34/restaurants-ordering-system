package ros.services;


import ros.dtos.ProductDto;

public interface ProductService {

    double getProductStock(Long id);
    ProductDto DecreaseStock(ProductDto productDto);

}
