package ros.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import ros.filestore.FileStore;

@Data
public class ProductDto {
    private long id;
    private String imageLink;
    private String productName;
    private String categori;
    private MultipartFile file;
}
