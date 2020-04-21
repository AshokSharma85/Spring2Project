import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from '../transaction-service.service';
import { TransactionClass } from '../transaction-class';

@Component({
  selector: 'app-view-transaction',
  templateUrl: './view-transaction.component.html',
  styleUrls: ['./view-transaction.component.css']
})
export class ViewTransactionComponent implements OnInit {

  constructor(private refOfTransactionService:TransactionServiceService) { }

      transactionData:TransactionClass[]=[];

  ngOnInit(): void {
    this.refOfTransactionService.loadTransaction().subscribe(data=>{this.transactionData=data},
      error=>
      {
        console.log("erroor occured",error);
      }
    );
  }

}
