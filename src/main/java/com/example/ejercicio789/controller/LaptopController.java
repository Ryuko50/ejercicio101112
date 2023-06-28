package com.example.ejercicio789.controller;

import com.example.ejercicio789.model.Laptop;
import com.example.ejercicio789.repository.LaptopRepository;
import com.example.ejercicio789.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LaptopController {

    @Value("${app.message}")
    String message;

    @Autowired
    private LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/saludo")
    public ResponseEntity<String> hola(){
        return ResponseEntity.ok(message);

    }

    @GetMapping("/laptops")
    public ResponseEntity<List<Laptop>> findAll(){
        return ResponseEntity.ok(laptopService.findAll());
    }

    @GetMapping("/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable("id") Long id){
        return ResponseEntity.ok(laptopService.findOneById(id));
    }

    @PostMapping("/laptops")
    public ResponseEntity create(@RequestBody Laptop laptop) throws URISyntaxException {
        laptopService.save(laptop);
        return (ResponseEntity) ResponseEntity.created(new URI("/laptops"));
    }

    @PutMapping("/laptops")
    public ResponseEntity update(@RequestBody Laptop laptop){
        laptopService.update(laptop);
        return (ResponseEntity) ResponseEntity.status(301);
    }

    @DeleteMapping("/laptop/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        laptopService.delete(id);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @DeleteMapping("/laptops")
    public ResponseEntity deleteAll(){
        laptopService.deleteAll();
        return (ResponseEntity) ResponseEntity.ok();
    }

}
