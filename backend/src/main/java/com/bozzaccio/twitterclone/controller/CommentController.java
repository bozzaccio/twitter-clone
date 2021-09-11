package com.bozzaccio.twitterclone.controller;

import com.bozzaccio.twitterclone.dto.CommentDTO;
import com.bozzaccio.twitterclone.entity.Comment;
import com.bozzaccio.twitterclone.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/comment"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class CommentController extends AbstractRESTController<CommentDTO, Comment, Long, CommentService> {

    public CommentController(CommentService service) {
        super(service);
    }
}
