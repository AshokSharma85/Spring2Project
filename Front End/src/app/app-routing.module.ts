import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewTransactionComponent } from './view-transaction/view-transaction.component';
import { AddTransactionComponent } from './add-transaction/add-transaction.component';
import { ViewCreditedBalanceHistoryComponent } from './view-transaction/view-credited-balance-history/view-credited-balance-history.component';
import { ViewDebitedBalanceHistoryComponent } from './view-transaction/view-debited-balance-history/view-debited-balance-history.component';


const routes: Routes = [
  {path:'show',component:ViewTransactionComponent},
  {path:'add',component:AddTransactionComponent},
  {path:'show/credithistory',component:ViewCreditedBalanceHistoryComponent},
  {path:'show/debithistory',component:ViewDebitedBalanceHistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent=[ViewTransactionComponent,AddTransactionComponent,ViewCreditedBalanceHistoryComponent,ViewDebitedBalanceHistoryComponent];