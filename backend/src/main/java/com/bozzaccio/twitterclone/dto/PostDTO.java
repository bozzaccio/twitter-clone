package com.bozzaccio.twitterclone.dto;

import com.bozzaccio.twitterclone.entity.Post;

public class PostDTO extends AbstractDTO<Long> {

    private static final long serialVersionUID = 8701496414601633465L;

    private String title;
    private String description;

    public PostDTO(Post entity) {
        super(entity);
        this.title = entity.getTitle();
        this.description = entity.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
