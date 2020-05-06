import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from '../../transaction-service.service';
import { TransactionClass } from '../../transaction-class';

@Component({
  selector: 'app-view-credited-balance-history',
  templateUrl: './view-credited-balance-history.component.html',
  styleUrls: ['./view-credited-balance-history.component.css']
})
// ./view-debited-balance-history/
export class ViewCreditedBalanceHistoryComponent implements OnInit {

  constructor(private transactionService:TransactionServiceService) { }
  transactionData:TransactionClass[]=[];
  loading = true;
  errorVarForData=false;
  ngOnInit(): void {
    this.transactionService.loadTransaction().subscribe(data=>{
      this.transactionData=JSON.parse(data);
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
        this.loading=false;
      }
    );
  
  }

}
