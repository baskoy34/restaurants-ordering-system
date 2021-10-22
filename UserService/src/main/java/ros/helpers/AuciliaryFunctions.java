package ros.helpers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Component
public class AuciliaryFunctions {

    public String generateQRCodeImageString(String barcodeText) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 300, 300);
        ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", os);
        return Base64.getEncoder().encodeToString(os.toByteArray());
    }
}
