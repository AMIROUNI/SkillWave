import { Component,Output,EventEmitter } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../../models/user.model';

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
 constructor( private router: Router) { }

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

  const credentials :User = {
    email: this.formLogin.get('username')?.value || '',
    password: this.formLogin.get('password')?.value || ''
  };

  console.log(credentials);

 
}

showPassword: boolean = false;

togglePasswordVisibility(): void {
  this.showPassword = !this.showPassword;
}
   }
 


