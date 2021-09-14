package com.bozzaccio.twitterclone.controller;

import com.bozzaccio.twitterclone.dto.CommentDTO;
import com.bozzaccio.twitterclone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = {"/comment"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class CommentController extends AbstractRESTController<CommentDTO, Long, CommentService> {

    public CommentController(@Autowired final CommentService service) {
        super(service);
    }
}
