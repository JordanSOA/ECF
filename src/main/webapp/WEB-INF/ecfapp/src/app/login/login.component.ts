import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../services/user-service.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any;

  constructor(private http: HttpClient,
              private router: Router,
              private userService: UserServiceService) {
  }

  ngOnInit() {
    this.model = {};
    sessionStorage.setItem('token', '');
  }

  login() {
    this.userService
      .login(this.model.username, this.model.password)
      .subscribe(
        () => {
          let base64hash = btoa(this.model.username + ':' + this.model.password);
          sessionStorage.setItem('token', base64hash);
          this.router.navigate(['']);
        },
        error => {
          if (error.status === 401) {
            alert('Authentication failed');
          }
        }
      );
  }

}
