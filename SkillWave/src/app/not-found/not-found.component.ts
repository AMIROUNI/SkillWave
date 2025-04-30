import { Component } from '@angular/core';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css'],
  standalone: false
})
export class NotFoundComponent {
  stars = Array(100).fill(0);
  planets = Array(5).fill(0);
}