import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UploadService } from '../../services/upload.service';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-management',
  templateUrl: './course-management.component.html',
  styleUrls: ['./course-management.component.css'],
  standalone:false
})
export class CourseManagementComponent {
  courseForm: FormGroup;
  selectedFile: File | null = null;

  previewUrl: string | ArrayBuffer | null = null;

  constructor(private fb: FormBuilder , private uploadService: UploadService, private courseServie: CourseService) {
    this.courseForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      price: [0, [Validators.required, Validators.min(0)]],
      category: ['', Validators.required],
      imageUrl: [''],
    });
  }

  onFileChange(event: Event): void {
    const fileInput = event.target as HTMLInputElement;
    const file = fileInput?.files?.[0];
    if (file) {
      this.selectedFile = file;
    }
  }

  /*

  onSubmit(): void {
    if (this.courseForm.valid && this.selectedFile) {
      const formData = new FormData();
      formData.append('title', this.courseForm.get('title')?.value);
      formData.append('description', this.courseForm.get('description')?.value);
      formData.append('price', this.courseForm.get('price')?.value);
      formData.append('instructorId', this.courseForm.get('instructorId')?.value);
      formData.append('category', this.courseForm.get('category')?.value);
      formData.append('image', this.selectedFile); // Adjust this key based on your backend

      // You can now send formData to your backend using HttpClient
      console.log('Form submitted!', formData);
    } else {
      console.warn('Form is invalid or image is missing.');
    }
  }*/

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];

    // For image preview
    const reader = new FileReader();
    reader.onload = (e) => {
      this.previewUrl = reader.result;
    };
    reader.readAsDataURL(this.selectedFile!);
  }

  triggerFileInput(fileInput: HTMLInputElement) {
    fileInput.click();
  }

  onSubmit() {
    if (this.courseForm.valid && this.selectedFile) {
     // First upload the image
      this.uploadService.uploadImage(this.selectedFile).subscribe({
        next: (imageUrl) => {
          console.log('Image  uploaded successfully:', imageUrl);

          // Update the form with the image URL
          this.courseForm.patchValue({ imageUrl: imageUrl });

          // Now send the brand to the backend
          const course: Course = this.courseForm.value;
          
          this.courseServie.createCourse(course).subscribe({
            next: (res) => {
              console.log('course added successfully:', res);
              // You can reset the form here if needed
              this.courseForm.reset();
              this.previewUrl = null;
              this.selectedFile = null;
            },
            error: (err) => {
              console.error('Error saving course:', err);
            }
          });
        },
        error: (err) => {
          console.error('Upload failed:', err);
        }
      });
    } else {
      console.log('Form is invalid or no image selected.');
    }
  }
}
