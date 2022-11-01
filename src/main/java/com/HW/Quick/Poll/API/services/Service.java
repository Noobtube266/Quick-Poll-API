package com.HW.Quick.Poll.API.services;


import com.HW.Quick.Poll.API.model.Poll;
import com.HW.Quick.Poll.API.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private PollRepository pollRepository;
    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Poll poll = pollRepository.findById(pollId).orElse(null);
        if(poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }



    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();

        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }


    //return new ResponseEntity<>(null, HttpStatus.CREATED);
    //Valid
    public ResponseEntity<?> createPoll( Poll poll) {

        poll = pollRepository.save(poll);
// Set the location header for the newly created

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders,
                HttpStatus.CREATED);
    }



    public ResponseEntity<?> getPoll(Long pollId) {
        verifyPoll(pollId);
        Optional<Poll> p = pollRepository.findById(pollId);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }


    public ResponseEntity<?> updatePoll( Poll poll,
                                         Long pollId) {
// Save the entity
        verifyPoll(pollId);
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deletePoll(Long pollId) {
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
