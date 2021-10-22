package ros.filestore;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.apache.http.entity.ContentType.*;

@Service
public class FileStore {

    private final AmazonS3 s3;
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Autowired
    public FileStore(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Async
    public void uploadFile(final MultipartFile multipartFile,String filename,String path) {
        System.out.println("File upload in progress.");
        isImage(multipartFile);
        try {
            final File file = convertMultiPartFileToFile(multipartFile);
            uploadFileToS3Bucket(path, file,filename);
            System.out.println("File upload is completed.");
            file.delete();  // To remove the file locally created in the project folder.
        } catch (final AmazonServiceException ex) {
            System.out.println("File upload is failed.");
            System.out.println("Error= {} while uploading file."+ ex.getMessage());
        }
    }

    private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
        final File file = new File(multipartFile.getOriginalFilename());
        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (final IOException ex) {
            System.out.println("Error converting the multi-part file to file= "+ ex.getMessage());
        }
        return file;
    }

    private void uploadFileToS3Bucket(final String path, final File file,final String fileName) {

        System.out.println("Uploading file with name= " + fileName);
        final PutObjectRequest putObjectRequest = new PutObjectRequest(path, fileName, file);
        s3.putObject(putObjectRequest);
    }

    public byte[] download(String path, String key) {
        byte[] content = null;
        try {
            System.out.println("In download");
            S3Object object = s3.getObject(path, key);
            S3ObjectInputStream inputStream = object.getObjectContent();
            System.out.println("In file store download");
            content = IOUtils.toByteArray(inputStream);
            System.out.println("File downloaded successfully.");
            object.close();


        }catch(AmazonServiceException | IOException e) {
            throw new IllegalStateException("Failed to download file from s3 ", e);
        }
        return content;
    }
    private void isImage(MultipartFile file) {
        if (!Arrays.asList(IMAGE_JPEG.getMimeType(), IMAGE_PNG.getMimeType(), IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an Image" + file.getContentType());
        }
    }
}
