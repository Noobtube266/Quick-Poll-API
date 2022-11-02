package com.HW.Quick.Poll.API.controller;

import com.HW.Quick.Poll.API.model.Poll;
import com.HW.Quick.Poll.API.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PollController {
    @Autowired
    private Service service;

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        return service.getAllPolls();
    }


    //return new ResponseEntity<>(null, HttpStatus.CREATED);
    @PostMapping("/polls")            //Valid
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        return service.createPoll(poll);
    }


    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        return service.getPoll(pollId);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        return service.updatePoll(poll,pollId);
    }
    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        return service.deletePoll(pollId);
    }


}
