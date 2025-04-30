import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
  standalone:false
})
export class FooterComponent {
  // Static links for footer sections
  companyLinks = [
    { name: 'About Us', url: '/about' },
    { name: 'Careers', url: '/careers' },
    { name: 'Blog', url: '/blog' }
  ];

  learnerLinks = [
    { name: 'Browse Courses', url: '/courses' },
    { name: 'My Learning', url: '/learning' },
    { name: 'Certificates', url: '/certificates' }
  ];

  supportLinks = [
    { name: 'Help Center', url: '/help' },
    { name: 'Contact Us', url: '/contact' },
    { name: 'FAQ', url: '/faq' }
  ];
}