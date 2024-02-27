import { Component, OnInit } from '@angular/core';
import { TaskService } from 'src/app/services/task.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-tasks',
  templateUrl: './view-tasks.component.html',
  styleUrls: ['./view-tasks.component.css']
})
export class ViewTasksComponent implements OnInit {

  constructor( private _tasks:TaskService) { }

  // Task data in array format
  tasks = [];
  filteredTasks = [];
  searchTerm: string = '';
  sortField: string = 'title'; // Initial sort field
  sortOrder: string = 'asc';
  isFilterByDueDate: Boolean = false;

  ngOnInit(): void {
    this._tasks.tasks().subscribe(
      (allData: any)=>{
      this.tasks = allData?.data;
      this.filteredTasks = allData?.data;
    },
    (error)=>{
      Swal.fire("Error","Some thing went wrong, Please try again",'error');
    });
  }

  // Perform filtering based on searchTerm
  filterTasks() {
    this.filteredTasks = this.tasks.filter(task =>
      task.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      task.description.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
  }

  // Perform sorting based on sortField
  sortTasks() {
    this.filteredTasks.sort((a, b) => {
      if (this.sortOrder === 'asc') {
        return a[this.sortField].localeCompare(b[this.sortField]);
      } else {
        return b[this.sortField].localeCompare(a[this.sortField]);
      }
    });
  
    // Toggle the sort order for the next click
    this.sortOrder = this.sortOrder === 'asc' ? 'desc' : 'asc';
  }

  // Filter tasks within 5 days from current date
  filterTasksWithin5Days() {
    if(!this.isFilterByDueDate) {
      const currentDate = new Date();
      const fiveDaysLater = new Date();
      fiveDaysLater.setDate(fiveDaysLater.getDate() + 5);

      this.filteredTasks = this.tasks.filter(task => {
        const dueDate = new Date(task.dueDate);
        return dueDate >= currentDate && dueDate <= fiveDaysLater;
      });
      this.isFilterByDueDate = true;
    } else {
      this.filteredTasks = this.tasks;
      this.isFilterByDueDate = false;
    }
  }

  filterTasksWithDueDate() {
    if(!this.isFilterByDueDate) {
      const currentDate = new Date();
      const fiveDaysLater = new Date();
      fiveDaysLater.setDate(fiveDaysLater.getDate() + 5);

      this.filteredTasks = this.tasks.filter(task => {
        const dueDate = new Date(task.dueDate);
        return dueDate <= currentDate;
      });
      this.isFilterByDueDate = true;
    } else {
      this.filteredTasks = this.tasks;
      this.isFilterByDueDate = false;
    }
  }

  // Delete Task
  deleteTask(id){    
    Swal.fire({
      icon: 'warning',
      title: 'Are you sure ?',
      confirmButtonText: 'Delete',
      showCancelButton: true,
    }).then((result) => {

      if (result.isConfirmed) {
        this._tasks.deleteTask(id).subscribe(
          (data) => {
            this.tasks = this.tasks = this.tasks.filter((task) => task.id != id);
            this.filteredTasks = this.filteredTasks = this.filteredTasks.filter((task) => task.id != id);
            Swal.fire('Success', 'Task deleted successfully!!', 'success');
          },
          (error) => {
            Swal.fire('Error', 'Error in deleting Task', 'error');
          },
        );
      }
    });
  }
}