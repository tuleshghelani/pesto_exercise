import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TaskService } from 'src/app/services/task.service';
import Swal from 'sweetalert2';
import { TaskStatus } from '../enum/TaskStatus';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  constructor(private _taskService : TaskService ,private _snackbar :MatSnackBar) { }

  task = {
    title: '',
    description:'',
    status: 'To Do',
    dueDate: null,
  };
  taskStatus = TaskStatus;

  ngOnInit(): void {
  }

  //add task form submit method

  addTaskFormSubmit(){

    if(this.task.title == '' || this.task.description == null){
      this._snackbar.open("Task title required!!!!","ok",{
        duration:3000,
      });
      return;
    }

    if(this.task.description =='' || this.task.description == null){
      this._snackbar.open("Task description required!!!","ok",{
        duration:3000,
      });
      return;
    }

    console.log('this.task : ', this.task);
    
    this._taskService.addTask(this.task).subscribe(
      (data:any)=>{
        this.task.title = '';
        this.task.description = '';
        this.task.status = TaskStatus.ToDo;
        this.task.dueDate = '';
        Swal.fire("Success" , "Task added successfully!!!" , "success");
      },
      (error)=>{
        //Error
        Swal.fire("Oop's" ,"Server Error Try Again!!!" , "error");
      });

      
  }

}
