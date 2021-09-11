package com.bozzaccio.twitterclone.entity;

import java.io.Serializable;

public abstract class BaseEntity<ID> extends Auditable implements Serializable {

    private static final long serialVersionUID = -8854348232451333086L;

    public abstract ID getId();

    public abstract void setId(ID Id);
}
