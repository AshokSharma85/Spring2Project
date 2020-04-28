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

  constructor( private refOfTransactionService:TransactionServiceService ) { }

  objOfTranaction:TransactionClass=new TransactionClass();

  ngOnInit(): void {
  }

  addTransaction(form :NgForm):void
  {
  this.refOfTransactionService.createNewTransaction(this.objOfTranaction).subscribe(data=>
  {
    form.resetForm();
    alert("Transaction Done");
  
  },
  error=>
  {
    //Json.parse function convert string into object to work with
    alert(JSON.parse(error.error).message);
    console.log("erroor occured",error);
  }
);
  }
}
