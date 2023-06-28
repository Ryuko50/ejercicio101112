package com.example.ejercicio789.service.impl;

import com.example.ejercicio789.model.Laptop;
import com.example.ejercicio789.repository.LaptopRepository;
import com.example.ejercicio789.service.LaptopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LaptopServiceImpl implements LaptopService {
    private LaptopRepository laptopRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop findOneById(Long id) {
        return laptopRepository.findById(id).get();
    }

    @Override
    public Laptop update(Laptop laptop) {
        if(!Objects.isNull(laptop.getId())) {
            laptopRepository.save(laptop);
        }
        return laptopRepository.findById(laptop.getId()).get();
    }

    @Override
    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    @Override
    public void delete(Long id) {
        laptopRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        laptopRepository.deleteAll();
    }
}
