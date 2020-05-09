package com.example.demobackend.entry;


import com.example.demobackend.user.User;
import com.example.demobackend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EntryController {


    private EntryService entryService;
    private UserService userService;

    @Autowired
    public EntryController(EntryService entryService, UserService userService){
        this.entryService=entryService;
        this.userService=userService;
    }

    @GetMapping("api/entries")
    public List<Entry> showAllEntries(){
        return entryService.getAllEntries();

    }

// Wenn man Entry schreibt
    @PostMapping("/api/entry")
    public Entry entryschreiben(@RequestBody Entry entry)  {


           return entryService.entryschreiben(entry.getName());}

    @GetMapping("/api/entries/{entryId}")
    public Entry showEntry(@PathVariable("entryId") long id) {
        return entryService.getEntryById(id);
    }


}
