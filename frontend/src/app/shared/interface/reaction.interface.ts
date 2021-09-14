
export interface Reaction {
    type: ReactionType;
    count: number;
}

export type ReactionType = 'LIKE' | 'SMILE' | 'LOVE';