import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from '../../transaction-service.service';
import { TransactionClass } from '../../transaction-class';

@Component({
  selector: 'app-view-debited-balance-history',
  templateUrl: './view-debited-balance-history.component.html',
  styleUrls: ['./view-debited-balance-history.component.css']
})
export class ViewDebitedBalanceHistoryComponent implements OnInit {

  constructor(private refOfTransactionService:TransactionServiceService) { }
  transactionData:TransactionClass[]=[];
  loading = true;
  errorVarForData=false;
  ngOnInit(): void {
    this.refOfTransactionService.loadTransaction().subscribe(data=>{
      this.transactionData=data;
      this.loading=false
      if(this.transactionData.length==0)
      {
        this.errorVarForData=true;
      }
    },
      error=>
      {
        console.log("erroor occured",error);
        this.errorVarForData=true;
      }
    );
  

  }

}
