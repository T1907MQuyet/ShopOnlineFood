import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestApiComponent } from './test-api/test-api.component';

const routes: Routes = [
  {
    path: '', component: TestApiComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
