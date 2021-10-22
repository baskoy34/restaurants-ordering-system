package ros.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ros.dto.ProductDto;
import ros.filestore.FileStore;
import ros.model.Product;
import ros.repository.ProductRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private  final ProductRepository productRepository;
    private final FileStore fileStore;


    public void insertProduct(ProductDto product, MultipartFile file){
        if(file.isEmpty()){
          throw  new IllegalArgumentException("File is Empty!");
        }
        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        product.setProductName(filename);
        Product newP=productRepository.save(Product.builder().categori(product.getCategori()).imageLink(filename).productName(product.getProductName()).build());
        String path = String.format("%s/%s", "resimdepo", newP.getId());
        uploadProductImage(file,filename,path);
    }
    @Async
    public void   uploadProductImage(MultipartFile file,String filename,String path){
        fileStore.uploadFile(file,filename,path);

    }
    @Async
    public byte[] downloadUserProfileImage(long productId,String keyname) {

        String path = String.format("%s/%s",
                "resimdepo",
                productId);

        System.out.println("In product profile service download");
        return fileStore.download(path,keyname);
    }
}
