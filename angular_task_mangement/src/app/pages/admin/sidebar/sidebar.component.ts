import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(public loginService: LoginService) { }

  ngOnInit(): void {
  }

  
  public logout(){
    console.log('logout click');
    this.loginService.logOut();
    window.location.reload();
    // this.loginService.loginStatusSubject.next(false);
  }

}
