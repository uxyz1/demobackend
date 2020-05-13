package com.example.demobackend.yorum;


import com.example.demobackend.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class YorumController {

    private YorumService yorumService;


    @Autowired
    public YorumController(YorumService yorumService){
        this.yorumService=yorumService;
    }

    @GetMapping("api/yorum/{entryId}")
    public List<Yorum> showAllYorums(@PathVariable("entryId") long id){
        return yorumService.getYorumRepository().findYorumByEntryId(id);
    }


    @PostMapping("/api/yorum/{entryId}")
    public Yorum yorumschreiben(@RequestBody Yorum yorum,@PathVariable("entryId") long id) {

        return yorumService.yorumschreiben(yorum.getText(),id,yorum.getPostedAt());
    }


}
