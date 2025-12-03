import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './landing.html',
  styleUrl: './landing.css'
})
export class LandingComponent implements OnInit {
  
  constructor(private router: Router) {}

  ngOnInit(): void {
    // Cargar Font Awesome si no está en index.html
  }

  scrollToSection(sectionId: string): void {
    const element = document.getElementById(sectionId);
    if (element) {
      element.scrollIntoView({ behavior: 'smooth' });
    }
  }

  goToLogin(): void {
    this.router.navigate(['/login']);
  }

  contactSupport(): void {
    window.location.href = 'mailto:soporte@nightwave.com';
  }
}