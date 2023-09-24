import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-search-report',
  templateUrl: './search-report.component.html',
  styleUrls: ['./search-report.component.css']
})
export class SearchReportComponent implements OnInit{

  constructor(private route: ActivatedRoute) { }
  url: string|null = '';

  ngOnInit() {
     this.url = this.route.snapshot.paramMap.get('url');
  }
}
