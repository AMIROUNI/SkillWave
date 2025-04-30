import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.css'],
  standalone:false
})
export class LoadingComponent implements OnInit {
  progress = 0;
  currentFeatureIndex = 0;
  randomHint = '';
  showNextComponent = false;
  
  features = [
    {
      title: 'Expert-Led Courses',
      description: 'Learn from industry professionals with real-world experience',
      icon: 'M12 3L1 9l11 6 9-4.91V17h2V9M5 13.18v4L12 21l7-3.82v-4L12 17l-7-3.82z'
    },
    {
      title: 'Hands-On Projects',
      description: 'Apply what you learn with practical exercises',
      icon: 'M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z'
    },
    {
      title: 'Flexible Learning',
      description: 'Study at your own pace, anytime, anywhere',
      icon: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zm.31-8.86c-1.77-.45-2.34-.94-2.34-1.67 0-.84.79-1.43 2.1-1.43 1.38 0 1.9.66 1.94 1.64h1.71c-.05-1.34-.87-2.57-2.49-2.97V5H10.9v1.69c-1.51.32-2.72 1.3-2.72 2.81 0 1.79 1.49 2.69 3.66 3.21 1.95.46 2.34 1.15 2.34 1.87 0 .53-.39 1.39-2.1 1.39-1.6 0-2.23-.72-2.32-1.64H8.04c.1 1.7 1.36 2.66 2.86 2.97V19h2.34v-1.67c1.52-.29 2.72-1.16 2.73-2.77-.01-2.2-1.9-2.96-3.66-3.42z'
    }
  ];

  hints = [
    'You can download courses for offline viewing',
    'Certificates are available upon course completion',
    'Our mobile app lets you learn on the go',
    'Bookmark lessons to revisit later'
  ];

  ngOnInit() {
    // Animate progress bar
    const progressInterval = setInterval(() => {
      this.progress += Math.random() * 10;
      if (this.progress >= 100) {
        this.progress = 100;
        clearInterval(progressInterval);
        setTimeout(() => {
          this.showNextComponent = true; // 
        }, 100);
      }
    }, 300);

    // Rotate features
    setInterval(() => {
      this.currentFeatureIndex = (this.currentFeatureIndex + 1) % this.features.length;
    }, 4000);

    // Select random hint
    this.randomHint = this.hints[Math.floor(Math.random() * this.hints.length)];
  }
}