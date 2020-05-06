import { Component, OnInit} from '@angular/core';
import { TransactionServiceService } from '../../transaction-service.service';
import { TransactionClass } from '../../transaction-class';

@Component({
  selector: 'app-view-debited-balance-history',
  templateUrl: './view-debited-balance-history.component.html',
  styleUrls: ['../view-credited-balance-history/view-credited-balance-history.component.css']
})
export class ViewDebitedBalanceHistoryComponent implements OnInit {

  constructor(private transactionService:TransactionServiceService) {
   }
  transactionData:TransactionClass[]=[];
  loading = true;
  errorVarForData=false;
  ngOnInit(): void {
    this.transactionService.loadTransaction().subscribe(data=>{
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
        this.loading=false;
      }
    );
  

  }

}
