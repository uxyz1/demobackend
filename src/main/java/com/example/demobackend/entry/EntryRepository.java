package com.example.demobackend.entry;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EntryRepository extends CrudRepository<Entry,Long> {


    List<Entry>findAllByOrderByPostedAtDesc();
    List<Entry> findAll();

    Entry findById(long id);

    Entry findByname(String name);

    Entry findByUserId(long id);
}
