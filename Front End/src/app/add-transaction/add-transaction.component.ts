import { Component, OnInit } from '@angular/core';
import { TransactionServiceService } from '../transaction-service.service';
import { TransactionClass } from '../transaction-class';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {

  constructor( private transactionService:TransactionServiceService ) { }

  tranaction:TransactionClass=new TransactionClass();
  errorMessage;
  errorMessageCondition=false;
  ngOnInit(): void {
  }

  addTransaction(form :NgForm):void
  {
  this.transactionService.createNewTransaction(this.tranaction).subscribe(data=>
  {
    form.resetForm();
    this.errorMessageCondition=false;
    alert("Money Successfully Transferred");
    
  },
  error=>
  {
    //Json.parse function convert string into object to work with
    // alert(JSON.parse(error.error).message);
    this.errorMessageCondition=true;
    this.errorMessage=JSON.parse(error.error).message;
    console.log("erroor occured",error);
  }
);
  }

}
