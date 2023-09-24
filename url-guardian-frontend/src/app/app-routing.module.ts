import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchBarComponent } from './components/search-bar/search-bar.component';
import { SearchReportComponent } from './components/search-report/search-report.component';

const routes: Routes = [
  { path: '', component: SearchBarComponent },
  { path: 'urlReport/:url', component: SearchReportComponent }, 
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
