import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { UploadService } from '../../services/upload.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  standalone:false
})
export class SignupComponent {
  signupForm: FormGroup;
  selectedFile: File | null = null;
  previewUrl: string | ArrayBuffer | null = null;
  loading = false;
  errorMessage: string | null = null;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private uploadService: UploadService
  ) {
    this.signupForm = this.fb.group({
      username: ['', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(20)
      ]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [
        Validators.required,
        Validators.minLength(8)
      ]],
      confirmPassword: ['', [Validators.required]],
      role: ['STUDENT', [Validators.required]],
      avatarUrl: [''],
      bio: ['']
    });
  }

  triggerFileInput(fileInput: HTMLInputElement): void {
    fileInput.click();
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length) {
      this.selectedFile = input.files[0];
      const reader = new FileReader();
      reader.onload = () => this.previewUrl = reader.result;
      reader.readAsDataURL(this.selectedFile);
    }
  }

  private passwordsMatch(): boolean {
    return this.signupForm.value.password === this.signupForm.value.confirmPassword;
  }

  onSubmit(): void {
    this.errorMessage = null;

    if (this.signupForm.invalid || !this.passwordsMatch()) {
      this.errorMessage = 'Please fix the form errors.';
      return;
    }

    if (!this.selectedFile) {
      this.errorMessage = 'Please select an avatar image.';
      return;
    }

    this.loading = true;

    this.uploadService.uploadImage(this.selectedFile).subscribe({
      next: (avatarUrl) => {
        this.signupForm.patchValue({ avatarUrl });

        const user: User = {
          username: this.signupForm.value.username,
          email: this.signupForm.value.email,
          password: this.signupForm.value.password,
          role: this.signupForm.value.role,
          avatarUrl,
          bio: this.signupForm.value.bio
        };

        this.authService.register(user).subscribe({
          next: (createdUser) => {
            console.log('Registration successful:', createdUser);
            this.signupForm.reset({ role: 'STUDENT' });
            this.previewUrl = null;
            this.selectedFile = null;
            this.loading = false;
          },
          error: (err) => {
            console.error('Registration error:', err);
            this.errorMessage = err.error?.message || 'Registration failed';
            this.loading = false;
          }
        });
      },
      error: (err) => {
        console.error('Upload error:', err);
        this.errorMessage = 'Image upload failed';
        this.loading = false;
      }
    });
  }

  isInvalid(controlName: string): boolean {
    const control = this.signupForm.get(controlName);
    return !!control && control.invalid && (control.dirty || control.touched);
  }
}