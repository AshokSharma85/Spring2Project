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
    /*
    *It will load the data form transaction table in database
    */
    this.transactionService.loadTransaction().subscribe(data=>{

      this.transactionData=JSON.parse(data);
      /*
      *Till the time response is coming from user server we will show to user
      *The data is loading  
      */

      this.loading=false
      /**
       * If no transaction is there then it will show to user that no transaction 
       * history is there
       */
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
