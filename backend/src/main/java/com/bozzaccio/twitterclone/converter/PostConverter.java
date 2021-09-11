package com.bozzaccio.twitterclone.converter;

import com.bozzaccio.twitterclone.dto.PostDTO;
import com.bozzaccio.twitterclone.entity.Post;
import org.springframework.util.Assert;

import static com.bozzaccio.twitterclone.util.ErrorUtils.*;

public class PostConverter extends AbstractConverter<PostDTO, Post> implements IConverter<Long> {

    @Override
    public PostDTO convertEntity(Post entity) {

        Assert.notNull(entity, buildErrorMessage(BASE_INITIALIZATION_ERROR, ENTITY, NULL_MESSAGE_ERROR));

        return new PostDTO(entity);
    }

    @Override
    public Post convertDTO(PostDTO dto) {

        Assert.notNull(dto, buildErrorMessage(BASE_INITIALIZATION_ERROR, DTO, NULL_MESSAGE_ERROR));

        Post post = new Post();

        convertBaseEntityToDTO(dto, post);
        post.setDescription(dto.getDescription());
        post.setTitle(dto.getTitle());

        return post;
    }
}
