import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  objOfUser:User=new User();
  msg:string;
  errorMsg:string;
  editflag:boolean=false;
  constructor( private refOfUserService:UserService ) { }

  ngOnInit(): void {

  }

  logout()
  {
    alert("You have been logged out");
    this.editflag=false;
  }

  
  loginUser(form:NgForm)
  {
    this.refOfUserService.login(this.objOfUser.phoneNumber ,this.objOfUser.password).subscribe(data=>
    {
      console.log("user id",data);
      this.msg=data;
      this.errorMsg=undefined;
     
      
      localStorage.setItem('userid',JSON.stringify(data));

      
      alert("You have been successfully logged in");
      form.resetForm();
      this.editflag=true;
      window.location.href ="/home";
    },
    error=>
      {
        this.errorMsg=JSON.parse(error.error).message;
        console.log(error.error);
        this.msg=undefined});
  }

}
