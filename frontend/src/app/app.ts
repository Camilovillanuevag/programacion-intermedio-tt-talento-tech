import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/login/login.component';
import { SearchBarComponent } from './components/search-bar/search-bar.component';
import { RestaurantListComponent } from './components/restaurant-list/restaurant-list.component';
import { RestaurantCardComponent } from './components/restaurant-card/restaurant-card.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    LoginComponent,
    SearchBarComponent,
    RestaurantListComponent,
    RestaurantCardComponent
  ],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class AppComponent {}
