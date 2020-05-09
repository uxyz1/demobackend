package com.example.demobackend.yorum;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface YorumRepository extends CrudRepository<Yorum,Long> {

    List<Yorum> findAll();

    Yorum findYorumById(long id);

    Yorum findYorumByText(String text);

    List<Yorum> findYorumByEntryId(long id);

}
