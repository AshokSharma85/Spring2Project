import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewTransactionComponent } from './view-transaction/view-transaction.component';
import { AddTransactionComponent } from './add-transaction/add-transaction.component';


const routes: Routes = [
  {path:'show',component:ViewTransactionComponent},
  {path:'add',component:AddTransactionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
