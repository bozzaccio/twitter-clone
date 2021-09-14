import { BaseModel } from "./base-model.interface";
import { User } from "./user.interface";

export interface Comment extends BaseModel{
    text: string;
    user: User;
}