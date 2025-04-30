import { Component } from '@angular/core';
import { courses } from '../models/course.model';

@Component({
  selector: 'app-course',
  standalone: false,
  templateUrl: './course.component.html',
  styleUrl: './course.component.css'
})
export class CourseComponent {

  courses=courses;
  

}
