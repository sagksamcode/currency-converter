package com.wex.currencyconvert.controllers;

import com.wex.currencyconvert.domains.vos.reponses.PurchaseTransactionPostResponse;
import com.wex.currencyconvert.domains.vos.reponses.PurchaseTransactionResponse;
import com.wex.currencyconvert.domains.vos.requests.PurchaseTransactionRequest;
import com.wex.currencyconvert.services.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseTransactionPostResponse> postPurchase(@Valid @RequestBody final PurchaseTransactionRequest request){

        final PurchaseTransactionPostResponse response = purchaseService.insert(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PurchaseTransactionResponse> postPurchase(@RequestParam String purchaseId, @RequestParam String country){

        return new ResponseEntity<>(purchaseService.retrievePurchase(purchaseId, country), HttpStatus.OK);
    }
}
