package com.example.demobackend.yorum;


import com.example.demobackend.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class YorumService {

    private YorumRepository yorumRepository;


    @Autowired
    public YorumService(YorumRepository yorumRepository){
        this.yorumRepository=yorumRepository;
    }

    public List<Yorum> getAllYorums(){
        return yorumRepository.findAll();
    }

    public Yorum getYorumById(long id){
        return yorumRepository.findYorumById(id);
    }

    public void addYorum( Yorum yorum){
        yorum = new Yorum(yorum.getText(),yorum.getId());
        yorumRepository.save(yorum);
    }


    public Yorum yorumschreiben(String  text, long id){
        return yorumRepository.save(new Yorum(text,id));
    }

    public YorumRepository getYorumRepository(){
        return yorumRepository;
    }

    public Yorum getYorumBytext(String text){
        return yorumRepository.findYorumByText(text);
    }
}
