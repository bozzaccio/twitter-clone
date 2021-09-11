package com.bozzaccio.twitterclone.controller;

import com.bozzaccio.twitterclone.dto.PostDTO;
import com.bozzaccio.twitterclone.entity.Post;
import com.bozzaccio.twitterclone.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/post"}, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class PostController extends AbstractRESTController<PostDTO, Post, Long, PostService> {

    public PostController(PostService service) {
        super(service);
    }
}
