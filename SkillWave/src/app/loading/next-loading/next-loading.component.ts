import { Component } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-next-loading',
  templateUrl: './next-loading.component.html',
  styleUrls: ['./next-loading.component.css'],
  standalone:false
})
export class NextLoadingComponent {
  videoId = 'LxdjUqdnl00';
  trailerUrl: string;

  constructor() {
    this.trailerUrl = `https://www.youtube.com/embed/${this.videoId}?autoplay=1&mute=0&controls=0&showinfo=0&rel=0&modestbranding=1&iv_load_policy=3&start=30`;
  }
}