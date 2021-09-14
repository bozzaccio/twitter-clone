export interface BaseModel {
    id?: number;
    creationTimestamp?: Date;
    creationUser?: number;
    updateTimestamp?: Date;
    updateUser?: string;
    version?: string;
}