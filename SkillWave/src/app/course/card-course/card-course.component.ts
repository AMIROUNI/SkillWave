import { Component, Input } from '@angular/core';
import { Course } from '../../models/course.model'; // Adjust path to your Course interface

@Component({
  selector: 'app-card-course',
  templateUrl: './card-course.component.html',
  styleUrls: ['./card-course.component.css'],
  standalone:false
})
export class CardCourseComponent {
  @Input() course!: Course;
  @Input() showAddToCart: boolean = true;
  
  isWishlisted: boolean = false;
  isHovered: boolean = false;

  toggleWishlist(): void {
    this.isWishlisted = !this.isWishlisted;
  }

  get rating(): number {
  
    return Math.floor(Math.random() * 2) + 4; 
  }

  get ratingCount(): number {
    // In a real app, this would come from your data
    return Math.floor(Math.random() * 500) + 50; // Random count 50-550
  }

  get formattedPrice(): string {
    return this.course.price.toLocaleString('en-US', {
      style: 'currency',
      currency: 'USD'
    });
  }
}