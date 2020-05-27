import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'ecfapp';
  constructor() {
  }

  ngOnInit(): void {
  }

  loggedIn(): boolean {
    return sessionStorage.getItem('token') && sessionStorage.getItem('token').length !== 0;
  }
}