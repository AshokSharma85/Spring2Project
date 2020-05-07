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
    /**
     * The data of form will be given to service through this method
     */
  this.transactionService.createNewTransaction(this.tranaction).subscribe(data=>
  {
    /**
     * This will reset the form after successfully submitted the data
     */

    form.resetForm();
    /*
    *The div which shows error will hide after making ngif false
    */

    this.errorMessageCondition=false;
    alert("Money Successfully Transferred"); 
    
  },
  error=>
  {
    
    /*
    *The condition of div become true and that div will show respective error
    */
    this.errorMessageCondition=true;

    /*
    *Json.parse function convert string into object to work with
    */
    this.errorMessage=JSON.parse(error.error).message;
    console.log("erroor occured",error);
  }
);
  }

}
