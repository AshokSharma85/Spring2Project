import { Injectable } from '@angular/core';
import { TransactionClass } from './transaction-class';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TransactionServiceService {

  transactions:TransactionClass[]=[];
   loggedInId;
  constructor(private http:HttpClient) { }
  loadTransaction():Observable<any>
  {
    let url="http://localhost:1137/viewTransactionHistory/"+this.loggedInId;
    
    return this.http.get(url,{responseType:'text'});
  }

  createNewTransaction(transRef:TransactionClass):Observable<any>
  {
    transRef.sender=this.loggedInId;
    let url="http://localhost:1137/addTransaction";
    return this.http.post(url,transRef,{responseType:'text'});


  }
}
