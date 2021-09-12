package com.bozzaccio.twitterclone.dao;

import com.bozzaccio.twitterclone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT COUNT(c) FROM Comment c WHERE c.post_id=:postId")
    Long countCommentByPostId(@Param("id") Long postId);
}
