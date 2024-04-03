package com.example.demo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.model.Event;
import com.example.demo2.repository.EventRepo;

@Service
public class EventService {
    @Autowired
    EventRepo mr;

    public Event create(Event mm) {
        return mr.save(mm);
    }

    public List<Event> getAll() {
        return mr.findAll();
    }

    public Event getMe(int id) {
        return mr.findById(id).orElse(null);
    }

    public boolean updateDetails(int id, Event mm) {
        if (this.getMe(id) == null) {
            return false;
        }
        try {
            mr.save(mm);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteProduct(int id) {
        if (this.getMe(id) == null) {
            return false;
        }
        mr.deleteById(id);
        return true;
    }

}
