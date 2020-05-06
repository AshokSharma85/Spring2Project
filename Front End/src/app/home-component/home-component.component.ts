import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-component',
  templateUrl: './home-component.component.html',
  styleUrls: ['./home-component.component.css']
})
export class HomeComponentComponent implements OnInit {

  constructor() { }
   imgOfAddMoney;
   imgOfTransferMoney;
   imgOfTransactionHistory;
   imgOfLogout;
  ngOnInit(): void {
  this.imgOfAddMoney="assets/addMoney.png";
  this.imgOfTransferMoney="assets/41.png";
  this.imgOfTransactionHistory="assets/42.png";
  this.imgOfLogout="assets/logout.png";


  }

  
}
