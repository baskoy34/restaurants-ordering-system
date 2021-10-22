package ros.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ros.dto.ProductDto;
import ros.service.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductController {
   private final ProductService productService;

    @PostMapping(value= "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadFile(@ModelAttribute ProductDto productDto) {
        productService.insertProduct(productDto,productDto.getFile());
        final String response = "[" + productDto.getFile().getOriginalFilename() + "] uploaded successfully.";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("{productId}/image/download")
    public byte[] downloadUserProfileImage(@PathVariable("productId") Long productId, @RequestParam  String keyname ) {
        System.out.println("In controller download");
        return productService.downloadUserProfileImage(productId,keyname);
    }
}
