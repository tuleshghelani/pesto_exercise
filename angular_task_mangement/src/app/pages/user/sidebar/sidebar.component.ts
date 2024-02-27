import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { TaskService } from 'src/app/services/task.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sidebar-user',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  tasks;
  constructor(private _taskService:TaskService, public loginService: LoginService) { }

  ngOnInit(): void {
    // on Loading init method data loaded
    this._taskService.tasks().subscribe(
      (data:any)=>{
        // Success 
        this.tasks = data;
        console.log(" data is " ,this.tasks);

      },
      (error)=>{
        // Error
        Swal.fire("Error","Server Error while loading Tasks","error");
      }
    )
  }

  
  public logout(){
    console.log('logout click');
    this.loginService.logOut();
    window.location.reload();
    // this.loginService.loginStatusSubject.next(false);
  }

}
