package com.HW.Quick.Poll.API.repository;

import com.HW.Quick.Poll.API.model.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long> {
}
