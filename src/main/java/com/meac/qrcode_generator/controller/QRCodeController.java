package com.meac.qrcode_generator.controller;

import com.meac.qrcode_generator.dto.QRCodeGenerateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/qrcode")
public class QRCodeController {

    @PostMapping
    public ResponseEntity<String> generateQrCode(@RequestBody QRCodeGenerateRequest request) {

        return null;

    }
}
