import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})

export class SearchBarComponent {
  constructor(private router: Router) { }
  searchUrl: string = '';
  urlPattern = /^(https?:\/\/)?([\w-]+\.)+[\w-]+(\/[\w-./?%&=]*)?$/;

  onSearch() {
    if (this.urlPattern.test(this.searchUrl)) {
      this.router.navigate(['/urlReport', this.searchUrl]);
    }

    else {
      alert("Invalid URL. Please try again.");
    }
  }
}

