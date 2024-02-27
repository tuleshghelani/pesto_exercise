import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private _http:HttpClient) { }

  // load all the tasks
  public tasks(){
    return this._http.get(`${baseUrl}/task/getUserTask`);
  }

  // Add task
  public addTask(task){
    return this._http.post(`${baseUrl}/task/createTask`, task);
  }

  // delete task
  public deleteTask(id){
    const url = `${baseUrl}/task/deleteTask?taskId=${id}`; // Adjust the URL based on your API endpoint
    return this._http.delete(url);
  }
  // get task by id
  public getTaskById(id){
    return this._http.get(`${baseUrl}/task/${id}`);
  }

  // updating task 
  public updatingTask(task){
    return this._http.put(`${baseUrl}/task/updateTask`,task);
  }
}