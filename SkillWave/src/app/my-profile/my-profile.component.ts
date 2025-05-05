import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { User } from '../models/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css'],
  standalone: false
})
export class MyProfileComponent implements OnInit {
  user: User | null = null;

  constructor(private userService: UserService,private authService: AuthService) {}

  ngOnInit(): void {
    const email: string | null = this.authService.getEmail();
    
    console.log(email)// ✅ ajouter ()
    
    if (<string>email) {
      this.userService.getCurrentUser(<string>email).subscribe({
        next: (userData) => {
          this.user = userData;
        },
        error: (err) => {
          console.error("Error fetching profile:", err);
        }
      });
    } else {
      console.warn("No email found in localStorage");
    }
  }
  openAvatarEditor(){}
  }

