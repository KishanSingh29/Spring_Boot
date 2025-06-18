package com.BackendX.journalApp.controller;

import com.BackendX.journalApp.JournalApplication;
import com.BackendX.journalApp.Service.JournalEntryService;
import com.BackendX.journalApp.entity.JournalEntry;
import com.BackendX.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry ){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);

        return myEntry;

    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){

        return journalEntryService.findById(myId).orElse(null);
    }
    @DeleteMapping("id/{myId}")
    public boolean DeleteJournalEntryById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId id, @RequestBody  JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
            old.setContent(newEntry.getContent()!=null&& !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
        }
        journalEntryService.saveEntry(old);

        return old;
    }


}
