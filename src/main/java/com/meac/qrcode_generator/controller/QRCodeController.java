package com.meac.qrcode_generator.controller;

import com.meac.qrcode_generator.dto.QRCodeGenerateRequest;
import com.meac.qrcode_generator.dto.QRCodeGenerateResponse;
import com.meac.qrcode_generator.services.QRCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/qrcode")
public class QRCodeController {

    private final QRCodeGeneratorService qrCodeGeneratorService;

    public QRCodeController(QRCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }


    @PostMapping
    public ResponseEntity<QRCodeGenerateResponse> generateQrCode(@RequestBody QRCodeGenerateRequest request) {

        try {
            QRCodeGenerateResponse response = this.qrCodeGeneratorService.generateQRCode(request);
           return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }




    }
}
