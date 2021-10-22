package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ros.dtos.ProductDto;
import ros.models.Product;
import ros.repositorys.ProductRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IGenericService<ProductDto>{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto findById(Long id) {
        // unnecessary
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id).get();
        if (product != null){
            product.setActive(false);
            productRepository.save(product);
        }

    }

    @Override
    public ProductDto Update(ProductDto entity) {
        Product product = modelMapper.map(entity,Product.class);
        product = productRepository.save(product);
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<ProductDto> findAll(Long id) {
        List<Product> products = productRepository.findByCategory(id);
        List<ProductDto> productDtos = new ArrayList<ProductDto>();

        for (Product product: products) {
            productDtos.add(modelMapper.map(product,ProductDto.class));
        }

        return productDtos;
    }

    @Override
    public ProductDto Add(ProductDto entity) {
        Product product = modelMapper.map(entity,Product.class);
        product = productRepository.save(product);
        return modelMapper.map(product,ProductDto.class);
    }
}
