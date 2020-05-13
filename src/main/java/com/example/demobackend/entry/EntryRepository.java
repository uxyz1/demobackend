package com.example.demobackend.entry;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EntryRepository extends CrudRepository<Entry,Long> {


    Set<Entry>findAllByOrderByPostedAtDesc();
    Set<Entry> findAll();
    Set<Entry> findAllByName(String name);

    Entry findById(long id);

    Entry findByName(String name);


    Entry findByUserId(long id);
}
