package br.com.dynamodblocal.dynamodblocal.controller;

import br.com.dynamodblocal.dynamodblocal.repositories.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class DynamoController {

    @Autowired
    private ProductInfoRepository infoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProdutoById(@PathVariable("id") String id) {
        return ResponseEntity.ok(infoRepository.findById(id));
    }
}
