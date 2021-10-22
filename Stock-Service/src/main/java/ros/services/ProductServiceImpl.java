package ros.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.ProductDto;
import ros.models.Product;
import ros.repositorys.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private  ProductRepository productRepository;

    @Override
    public double getProductStock(Long id){
        Product product =null;
        try
        {
           product= productRepository.findById(id).get();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return product.getQuantity();

    }

    @Override
    public ProductDto DecreaseStock(ProductDto productDto){
        // stok azalt
        try
        {
            Product product = productRepository.findById(productDto.getId()).get();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
