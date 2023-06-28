package com.example.ejercicio789.service;

import com.example.ejercicio789.model.Laptop;

import java.util.List;

public interface LaptopService {

    List<Laptop> findAll();

    Laptop findOneById(Long id);

    Laptop update(Laptop laptop);

    void save(Laptop laptop);

    void delete(Long id);

    void deleteAll();
}
