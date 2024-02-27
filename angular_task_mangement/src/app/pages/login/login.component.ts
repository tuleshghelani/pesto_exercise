import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    constructor(private snackBar: MatSnackBar , private loginService: LoginService, private router: Router) { }

  loginData = {
    username: '',
    password: '',
  };

  ngOnInit(): void {
  }

  loginFormSubmit(){
    if (this.loginData.username.trim() == '' || this.loginData.username == null){
      this.snackBar.open('Username is required!!!', 'OK', {
        duration: 3000,
      });
      return;
    }
    if (this.loginData.password.trim() == '' || this.loginData.password == null){
      this.snackBar.open('Password is required!!!', 'ok', {
        duration: 3000,
      });
      return;
    }

    this.loginService.generateToken(this.loginData).subscribe(
        (data: any) => {
          this.loginService.loginUser(data.token);
          this.loginService.getCurrentUser().subscribe(
            (user: any) => {
              this.loginService.setUser(user);
              this.router.navigate(['admin/profile']);
              this.loginService.loginStatusSubject.next(true);
            },
          );
        },
        (err) => {
          this.snackBar.open('Invaild credentials! Please try Agin', 'ok', {
            duration: 5000,
          });
        }
      );
  }
}
