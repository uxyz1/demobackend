package com.example.demobackend.yorum;


import com.example.demobackend.entry.Entry;
import com.example.demobackend.entry.EntryRepository;
import com.example.demobackend.user.User;
import com.example.demobackend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Service
public class YorumService {

    private YorumRepository yorumRepository;
    private EntryRepository entryRepository;
    private UserService userService;


    @Autowired
    public YorumService(YorumRepository yorumRepository,EntryRepository entryRepositor, UserService userService){
        this.yorumRepository=yorumRepository;
        this.entryRepository=entryRepositor;
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


    public Yorum yorumschreiben(String text, long id, Instant postedAt){
        Entry entry = entryRepository.findById(id);
        //User user = userService.getUserById(user_id);
        return yorumRepository.save(new Yorum(text,entry,postedAt));
    }

    public YorumRepository getYorumRepository(){
        return yorumRepository;
    }

    public Yorum getYorumBytext(String text){
        return yorumRepository.findYorumByText(text);
    }
}
