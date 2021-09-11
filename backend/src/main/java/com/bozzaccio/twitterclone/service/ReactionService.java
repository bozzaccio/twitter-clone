package com.bozzaccio.twitterclone.service;

import com.bozzaccio.twitterclone.converter.ReactionConverter;
import com.bozzaccio.twitterclone.dao.ReactionRepository;
import com.bozzaccio.twitterclone.dto.ReactionDTO;
import com.bozzaccio.twitterclone.entity.Reaction;
import org.springframework.stereotype.Service;

@Service
public class ReactionService extends BaseCRUDServiceImpl<ReactionDTO, Reaction, Long> {

    public ReactionService(ReactionRepository repository, ReactionConverter converter) {
        super(repository, converter);
    }
}
