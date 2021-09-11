package com.bozzaccio.twitterclone.controller;

import com.bozzaccio.twitterclone.dto.ReactionDTO;
import com.bozzaccio.twitterclone.entity.Reaction;
import com.bozzaccio.twitterclone.service.ReactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/reaction"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ReactionController extends AbstractRESTController<ReactionDTO, Reaction, Long, ReactionService> {

    public ReactionController(ReactionService service) {
        super(service);
    }
}
