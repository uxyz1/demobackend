package com.example.demobackend;


import com.example.demobackend.entry.Entry;
import com.example.demobackend.entry.EntryService;
import com.example.demobackend.user.User;
import com.example.demobackend.user.UserService;
import com.example.demobackend.yorum.YorumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyDataService {

    private EntryService entryService;
    private YorumService yorumService;
    private UserService userService;

    @Autowired
    public DummyDataService(EntryService entryService,YorumService yorumService,UserService userService){
        this.entryService=entryService;
        this.yorumService=yorumService;
        this.userService=userService;
        getDummyData();
    }

    public void getDummyData() {

        if (!userService.usernameExists("test1")) {
            userService.register("test1", "test1");
        }



        Entry entry = new Entry("Istanbul hakkinda bilgi",1);
        Entry entry1= new Entry("Köln",1);
        entryService.addEntry(entry);
        entryService.addEntry(entry1);


}}
