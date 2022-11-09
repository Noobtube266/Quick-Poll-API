package com.HW.Quick.Poll.API.controller;

import com.HW.Quick.Poll.API.model.Poll;
import com.HW.Quick.Poll.API.repository.PollRepository;
import com.HW.Quick.Poll.API.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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
    public void createPoll(@Valid @RequestBody Poll poll) {
        service.createPoll(poll);
    }


    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        return service.getPoll(pollId);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        return service.updatePoll(poll, pollId);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        return service.deletePoll(pollId);
    }

   /* @RequestMapping(value = "/polls", method = RequestMethod.POST)
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        poll = PollRepository.save(poll);
// Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(poll.getId()).toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);


    }*/
}
