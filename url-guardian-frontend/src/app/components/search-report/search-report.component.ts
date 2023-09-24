import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IUrlReport } from 'src/app/schemas/IUrlReport';
import { UrlReportService } from 'src/app/services/url-report.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-report',
  templateUrl: './search-report.component.html',
  styleUrls: ['./search-report.component.css']
})
export class SearchReportComponent implements OnInit{

  constructor(private route: ActivatedRoute, private router: Router, private urlReportService: UrlReportService) { }
  url: string|null = '';
  report: IUrlReport|null = null;

  ngOnInit() {
     this.url = this.route.snapshot.paramMap.get('url');
     this.urlReportService.getReport(this.url!).subscribe((report: IUrlReport) => {
        this.report = report;
      });
  }

  formatDate(date: number|undefined) {
    if (date === undefined) {
      return 'N/A';
    }
    return new Date(date * 1000).toLocaleString();
  }

  clickBackToSafetyButton() {
    this.router.navigate(['']);
  }

  clickRedirectButton() {
    window.open(this.url!, '_blank');
  }

  clickHomeButton() {
    this.router.navigate(['']);
  }
}
