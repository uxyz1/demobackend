package com.example.demobackend.entry;


import com.example.demobackend.user.User;
import com.example.demobackend.user.UserService;
import com.example.demobackend.yorum.Yorum;
import com.example.demobackend.yorum.YorumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Service
public class EntryService {

    private EntryRepository entryRepository;
    private YorumRepository yorumRepository;
    private UserService userService;

    @Autowired
    public EntryService(EntryRepository entryRepository, YorumRepository yorumRepository, UserService userService){
        this.entryRepository=entryRepository;
        this.yorumRepository=yorumRepository;
        this.userService=userService;
    }


    public List<Entry> getAllEntries(){
        return entryRepository.findAll();
    }

    public  Entry entryschreiben(String  name, long user_id, Instant postedAt){
            User user = userService.getUserById(user_id);// bu koddan repositorye user_ide yi kaydettirdi
        return entryRepository.save(new Entry(name,user,postedAt));
    }



    public void addEntry(Entry entry) {

            entry = new Entry(entry.getName());
            entryRepository.save(entry);

    }

    public List<Yorum> getYorumList(long id){
        return yorumRepository.findYorumByEntryId(id);
    }

    public Entry getEntryById(long id){
        return entryRepository.findById(id);
    }

    public Entry getEntryByname(String name){
        return entryRepository.findByname(name);
    }


    public EntryRepository getEntryRepository() {
        return entryRepository;
    }


}
