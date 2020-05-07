import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTransactionComponent } from './add-transaction/add-transaction.component';
import { ViewTransactionComponent } from './view-transaction/view-transaction.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ViewCreditedBalanceHistoryComponent } from './view-transaction/view-credited-balance-history/view-credited-balance-history.component';
import { ViewDebitedBalanceHistoryComponent } from './view-transaction/view-debited-balance-history/view-debited-balance-history.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTransactionComponent,
    ViewTransactionComponent,
    ViewCreditedBalanceHistoryComponent,
    ViewDebitedBalanceHistoryComponent,
    HomeComponentComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
