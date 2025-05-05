// src/app/services/auth.service.ts
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, tap } from 'rxjs';
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
  private apiUrl = 'http://localhost:8095/api/auth';
  private emailKey = 'user_email';

  // Émission du statut de connexion (email ou null)
  private currentEmailSubject = new BehaviorSubject<string | null>(this.getEmailFromStorage());
  public currentEmail$ = this.currentEmailSubject.asObservable();

  constructor(private http: HttpClient,private router :Router) { }

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
    localStorage.removeItem("user"); // <-- Ajoute ça si nécessaire
    this.currentEmailSubject.next(null);
    this.router.navigate(['/']); // ou vers la page de login
  }
  

  getEmail(): string | null {
    return localStorage.getItem(this.emailKey);
  }

  private getEmailFromStorage(): string | null {
    return localStorage.getItem(this.emailKey);
  }


   removeStorage(): void  {
    return localStorage.removeItem("user")
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
  const user = this.getUser();
  const role = user?.role;

  if (!role) {
    this.router.navigate(['/login']); // ou une page d'erreur
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
      this.router.navigate(['/login']); // fallback
  }
}
}
