package com.bozzaccio.twitterclone.entity;

import com.bozzaccio.twitterclone.util.ReactionEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_REACTION")
public class Reaction extends BaseEntity<Long> {

    private static final long serialVersionUID = -8581319746187738371L;

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "T_REACTION_GEN", sequenceName = "T_REACTION_GEN_SQ", allocationSize = 1)
    @GeneratedValue(generator = "T_REACTION_GEN", strategy = GenerationType.SEQUENCE)
    private Long Id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "REACTION", nullable = false)
    private ReactionEnum reaction;

    @NotNull
    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Override
    public Long getId() {
        return this.Id;
    }

    @Override
    public void setId(Long Id) {
        this.Id = Id;
    }

    public ReactionEnum getReaction() {
        return reaction;
    }

    public void setReaction(ReactionEnum reaction) {
        this.reaction = reaction;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
