package com.meac.qrcode_generator.services;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.meac.qrcode_generator.dto.QRCodeGenerateRequest;
import com.meac.qrcode_generator.dto.QRCodeGenerateResponse;
import com.meac.qrcode_generator.ports.StoragePort;
import com.meac.qrcode_generator.util.MatrixToImageWriter;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QRCodeGeneratorService {

    private final StoragePort storagePort;


    public QRCodeGeneratorService(StoragePort storagePort) {
        this.storagePort = storagePort;
    }

    public QRCodeGenerateResponse generateQRCode(QRCodeGenerateRequest request) throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(request.url(), BarcodeFormat.QR_CODE,200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        byte[] pngQrCodeData = pngOutputStream.toByteArray();

        String url = storagePort.uploadFile(pngQrCodeData, UUID.randomUUID().toString(), "image/png");

        return new QRCodeGenerateResponse(url).map;



    }

}
