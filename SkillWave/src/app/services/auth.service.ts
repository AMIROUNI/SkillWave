// src/app/services/auth.service.ts

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, tap, map } from 'rxjs';
import { User } from '../models/user.model';
import { Router } from '@angular/router';

export interface LoginPayload {
  email: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8095/graphql'; // GraphQL endpoint
  private emailKey = 'user_email';

  private currentEmailSubject = new BehaviorSubject<string | null>(this.getEmailFromStorage());
  public currentEmail$ = this.currentEmailSubject.asObservable();

  constructor(private http: HttpClient, private router: Router) {}

  /** MUTATION: signUp */
  register(user: User): Observable<User> {
    const mutation = `
      mutation {
        signUp(name: "${user.name}", email: "${user.email}", password: "${user.password}") {
          id
          name
          email
          role
        }
      }
    `;

    return this.http.post<any>(this.apiUrl, { query: mutation }).pipe(
      map(response => response.data.signUp)
    );
  }

  /** MUTATION: signIn */
  login(payload: LoginPayload): Observable<User> {
    const query = `
      mutation {
        signIn(email: "${payload.email}", password: "${payload.password}") {
          id
          name
          email
          role
        }
      }
    `;

    return this.http.post<any>(this.apiUrl, { query }).pipe(
      map(response => response.data.signIn),
      tap(user => {
        if (user) {
          localStorage.setItem(this.emailKey, user.email);
          localStorage.setItem("user", JSON.stringify(user));
          this.currentEmailSubject.next(user.email);
        }
      })
    );
  }

  logout(): void {
    localStorage.removeItem(this.emailKey);
    localStorage.removeItem("user");
    this.currentEmailSubject.next(null);
    this.router.navigate(['/']);
  }

  getEmail(): string | null {
    return localStorage.getItem(this.emailKey);
  }

  private getEmailFromStorage(): string | null {
    return localStorage.getItem(this.emailKey);
  }

  removeStorage(): void {
    localStorage.removeItem("user");
  }

  isLoggedIn(): boolean {
    return !!this.getUser();
  }

  setUser(user: User): void {
    localStorage.setItem("user", JSON.stringify(user));
  }

  getUser(): User | null {
    const userJson = localStorage.getItem("user");
    return userJson ? JSON.parse(userJson) as User : null;
  }

  getRole(): 'STUDENT' | 'INSTRUCTOR' | 'ADMIN' | null {
    const user = this.getUser();
    return user?.role || null;
  }

  redirectByRole(): void {
    const role = this.getRole();
    if (!role) {
      this.router.navigate(['/login']);
      return;
    }

    switch (role) {
      case 'STUDENT':
        this.router.navigate(['/courses']);
        break;
      case 'INSTRUCTOR':
        this.router.navigate(['/instructor/dashboard']);
        break;
      case 'ADMIN':
        this.router.navigate(['/admin/dashboard']);
        break;
      default:
        this.router.navigate(['/login']);
    }
  }
}
