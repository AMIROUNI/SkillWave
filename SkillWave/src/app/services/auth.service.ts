// src/app/services/auth.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, tap } from 'rxjs';
import { User } from '../models/user.model';

export interface LoginPayload {
  email: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8095/api/auth';
  private emailKey = 'user_email';

  // Émission du statut de connexion (email ou null)
  private currentEmailSubject = new BehaviorSubject<string | null>(this.getEmailFromStorage());
  public currentEmail$ = this.currentEmailSubject.asObservable();

  constructor(private http: HttpClient) { }

  /** POST /register */
  register(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/register`, user);
  }

  /** POST /login */
  login(payload: LoginPayload): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/login`, payload)
      .pipe(
        tap(user => {
        
          localStorage.setItem(this.emailKey, user.email);
          this.currentEmailSubject.next(user.email);
        })
      );
  }

  logout(): void {
    localStorage.removeItem(this.emailKey);
    this.currentEmailSubject.next(null);
  }

  getEmail(): string | null {
    return localStorage.getItem(this.emailKey);
  }

  private getEmailFromStorage(): string | null {
    return localStorage.getItem(this.emailKey);
  }

  isLoggedIn(): boolean {
    return !!this.getEmail();
  }
}
