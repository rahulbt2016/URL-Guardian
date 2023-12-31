import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IUrlReport } from '../schemas/IUrlReport';

@Injectable({
  providedIn: 'root'
})
export class UrlReportService {

  private apiUrl = 'http://localhost:8080/scoreUrl';

  constructor(private http: HttpClient) { }

  getReport(url: string): Observable<IUrlReport> {
    return this.http.post<IUrlReport>(this.apiUrl, {intakeUrl: url});
  }

  // getReport(url: string): Observable<any> {
  //   return this.http.post<any>(this.apiUrl, {intakeUrl: url});
  // }
}
