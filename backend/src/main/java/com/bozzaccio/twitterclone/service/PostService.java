package com.bozzaccio.twitterclone.service;

import com.bozzaccio.twitterclone.converter.PostConverter;
import com.bozzaccio.twitterclone.dao.PostRepository;
import com.bozzaccio.twitterclone.dto.PostDTO;
import com.bozzaccio.twitterclone.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService extends BaseCRUDServiceImpl<PostDTO, Post, Long> {

    public PostService(PostRepository repository, PostConverter converter) {
        super(repository, converter);
    }
}
