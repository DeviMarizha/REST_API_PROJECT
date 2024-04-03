package com.example.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.model.Event;
import com.example.demo2.service.EventService;

@RestController
public class EventController {
    @Autowired
    EventService ms;

    @PostMapping("api/product")
    public ResponseEntity<Event> addelements(@RequestBody Event m) {
        Event mm = ms.create(m);
        return new ResponseEntity<>(mm, HttpStatus.CREATED);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Event>> showinfo() {
        return new ResponseEntity<>(ms.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Event> getById(@PathVariable Integer productId) {
        Event obj = ms.getMe(productId);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<Event> putMethodName(@PathVariable("productId") int id, @RequestBody Event m) {
        if (ms.updateDetails(id, m) == true) {
            return new ResponseEntity<>(m, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/product/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int id) {
        if (ms.deleteProduct(id) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
