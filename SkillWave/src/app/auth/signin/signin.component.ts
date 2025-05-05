import { Component,Output,EventEmitter } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../models/user.model';
import { AuthService, LoginPayload } from '../../services/auth.service';

@Component({
  selector: 'app-signin',
  standalone: false,
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css',
  
})
export class SigninComponent {
  
  //data: string[] = [];

  login :string='';
  password :string='';
 constructor( private router: Router, private  authService:AuthService) { }

 formLogin=new FormGroup({
   username:new FormControl('',[Validators.required,Validators.minLength(4)]),
   password:new FormControl('',[Validators.required, Validators.minLength(8)]),
 })




 isInvalidAndTouchedOrDirty(FormControl: FormControl): boolean {
  return FormControl.invalid && (FormControl.touched || FormControl.dirty);
 }
 errorMessage : string = '';

 onSubmitLogin(): void {
  if (this.formLogin.invalid) return;

  const credentials :LoginPayload = {
    email: this.formLogin.get('username')?.value || '',
    password: this.formLogin.get('password')?.value || ''
  };

  console.log(credentials);
  
  this.authService.login(credentials).subscribe({
    next: (req :User) => {
      console.log('Registration successful:', req);
      this.authService.setUser(req)
      this.authService.redirectByRole(); 
  
    error: (err : any) => {
      console.error('Registration error:', err);
      this.errorMessage = err.error?.message || 'Registration failed';
    }
  }})


  
 
}

showPassword: boolean = false;

togglePasswordVisibility(): void {
  this.showPassword = !this.showPassword;
}
   }
 


