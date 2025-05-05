import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8095/api/users'; 
  constructor(private httpClient: HttpClient) { }



  getCurrentUser(email: string): Observable<User> {
    return this.httpClient.get<User>(`${this.baseUrl}/me/${email}`);
  }
  
}
