package com.HW.Quick.Poll.API.controller;

import com.HW.Quick.Poll.API.DTO.OptionCount;
import com.HW.Quick.Poll.API.DTO.VoteResult;
import com.HW.Quick.Poll.API.model.Vote;
import com.HW.Quick.Poll.API.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {
    @Autowired
    private VoteRepository voteRepository;
    @GetMapping("/computeresult")
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

        int totalVotes = 0;
        Map<Long, OptionCount> tempMap = new HashMap<Long, OptionCount>();

        for (Vote v : allVotes) {

            totalVotes++;

            OptionCount optionCount = tempMap.get(v.getOption().getId());

            if (optionCount == null) {

                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOption().getId());
                tempMap.put(v.getOption().getId(), optionCount);

            }
            optionCount.setCount(optionCount.getCount() + 1);
        }

        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());

        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);

    }
}
