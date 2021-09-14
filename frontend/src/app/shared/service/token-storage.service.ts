import { Injectable } from '@angular/core';
import { environment } from "src/environments/environment";


@Injectable({
    providedIn: 'root'
})
export class TokenStorageService {

    private readonly _TOKEN_KEY = 'auth-token';
    private readonly _USER_KEY = 'auth-user';

    signOut(): void {
        window.sessionStorage.clear();
    }

    public saveToken(token: string): void {
        window.sessionStorage.removeItem(this._TOKEN_KEY);
        window.sessionStorage.setItem(this._TOKEN_KEY, token);
    }

    public getToken(): string | null {
        return window.sessionStorage.getItem(this._TOKEN_KEY);
    }

    public saveUser(user: any): void {
        window.sessionStorage.removeItem(this._USER_KEY);
        window.sessionStorage.setItem(this._USER_KEY, JSON.stringify(user));
    }

    public getUser(): any {
        const user = window.sessionStorage.getItem(this._USER_KEY);
        if (user) {
            return JSON.parse(user);
        }

        return null;
    }
}
