import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject =  new Subject<boolean>();

  constructor(private _http: HttpClient) { }

  public generateToken(loginData: any) {
    return this._http.post(`${baseUrl}/login`, loginData);
  }

  public loginUser(token) {
    localStorage.setItem("token", token);
    return true;
  }

  public getCurrentUser(){
    return this._http.get(`${baseUrl}/current-user`);
  }

  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token");
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null) {
      return false;
    } else {
      return true;
    }
  }

  public logOut(){
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  public getToken(){
    return localStorage.getItem("token");
  }

  public setUser(user){
    localStorage.setItem("user",JSON.stringify(user));
  }

  public getUser(){
    let userStr = localStorage.getItem("user");
    if (userStr != null){
      return JSON.parse(userStr);
    }else{
      this.logOut();
      return null;
    }
  }

  //get user role
  public getUserRole(){
    let user = this.getUser();
    // return user.authorities[0].authority
    return user
  }

  // get all users count for admin 
  public getUserCount(){
    return this._http.get(`${baseUrl}/user/usercount/`);
  }

}
