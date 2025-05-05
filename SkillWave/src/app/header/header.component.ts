import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  standalone: false
})
export class HeaderComponent implements OnInit {

  isLoggedIn: boolean = false;
  isMenuOpen: boolean = false;
  user: User | null = null;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isLoggedIn();
    this.user = this.authService.getUser(); 
    console.log(this.user)// ✅ appel correct de la méthode

    console.log("Avatar URL:", this.user?.avatarUrl);
  }

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
  }



  signout(){
    this.authService.logout()
  }
}
