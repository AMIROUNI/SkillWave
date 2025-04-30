import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  standalone:false
})
export class SignupComponent {
  signupForm = new FormGroup({
    username: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(20),

    ]),
    email: new FormControl('', [
      Validators.required,
      Validators.email
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
   
    ]),
    confirmPassword: new FormControl('', [
      Validators.required
    ]),
    role: new FormControl('STUDENT', [
      Validators.required
    ]),
    avatarUrl: new FormControl(''),
    bio: new FormControl('')
  }, );

  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    return password === confirmPassword ;
  }

  onSubmit(): void {
    if (this.signupForm.invalid) return;

    const user = {
      username: this.signupForm.get('username')?.value || '',
      email: this.signupForm.get('email')?.value || '',
      password: this.signupForm.get('password')?.value || '',
      role: this.signupForm.get('role')?.value || 'STUDENT',
      avatarUrl: this.signupForm.get('avatarUrl')?.value || '',
      bio: this.signupForm.get('bio')?.value || ''
    };

    console.log(user);
  }

  isInvalidAndTouchedOrDirty(formControl: FormControl): boolean {
    return formControl.invalid && (formControl.touched || formControl.dirty);
  }


}