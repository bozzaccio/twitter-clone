package com.bozzaccio.twitterclone.service;

import com.bozzaccio.twitterclone.converter.CommentConverter;
import com.bozzaccio.twitterclone.dao.CommentRepository;
import com.bozzaccio.twitterclone.dto.CommentDTO;
import com.bozzaccio.twitterclone.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends BaseCRUDServiceImpl<CommentDTO, Comment, Long> {

    public CommentService(CommentRepository repository, CommentConverter converter) {
        super(repository, converter);
    }
}
