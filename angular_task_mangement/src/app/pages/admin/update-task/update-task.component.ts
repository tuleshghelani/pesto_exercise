import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskService } from 'src/app/services/task.service';
import Swal from 'sweetalert2';
import { TaskStatus } from '../enum/TaskStatus';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  // local variable
  cid;
  taskUpdateData;
  taskStatus = TaskStatus;

  constructor(
    private _route:ActivatedRoute,
    private _taskService: TaskService,
    private _snackbar:MatSnackBar,
    private _router:Router,
    ) { }

  ngOnInit(): void {

    //Now get id from url with help of _route
    this.cid = this._route.snapshot.params.cid;
    console.log(this.cid);
    this._taskService.getTaskById(this.cid).subscribe(
      (allData: any)=>{
        this.taskUpdateData = {
          id: allData.data.id,
          title: allData.data.title,
          description: allData.data.description,
          status: allData.data.status,
          dueDate: allData.data.dueDate
        };
      },
      (error)=>{
        //error
        Swal.fire('Error' , 'Server error while loading data!!' , 'error');
      }
    );

  }

  updateTaskONFormSubmit(){
    
    if(this.taskUpdateData.title == '' || this.taskUpdateData.title == null){
      this._snackbar.open("Task title required!!!!","ok",{
        duration:3000,
      });
      return;
    }

    if(this.taskUpdateData.description =='' || this.taskUpdateData.description == null){
      this._snackbar.open("Task description required!!!","ok",{
        duration:3000,
      });
      return;
    }
    let currentDate: Date = new Date(); // Get current date
    const dueDate = new Date(this.taskUpdateData.dueDate);
    if(dueDate < currentDate){
      this._snackbar.open("Due date should more than today!!!","ok",{
        duration:3000,
      });
      return;
    }

    
    console.log('this.taskUpdateData : ', this.taskUpdateData);
    
    this._taskService.updatingTask(this.taskUpdateData).subscribe(
      (data)=>{
       this.taskUpdateData.title = '';
       this.taskUpdateData.description = '';
        Swal.fire('Success' ,'Task updated' ,'success').then((e)=>{
              this._router.navigate(['/admin/tasks']);
        });       
      },
      (error)=>{
        Swal.fire('Error' ,'Error while updating task' ,'error');
      }
    );
  }

}
