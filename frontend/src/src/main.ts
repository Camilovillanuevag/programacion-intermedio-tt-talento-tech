import { bootstrapApplication } from '@angular/platform-browser';
import { importProvidersFrom } from '@angular/core';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app';

import { HeaderComponent } from './app/components/header/header.component';
import { LoginComponent } from './app/components/login/login.component';
import { SearchBarComponent } from './app/components/search-bar/search-bar.component';
import { RestaurantListComponent } from './app/components/restaurant-list/restaurant-list.component';
import { RestaurantCardComponent } from './app/components/restaurant-card/restaurant-card.component';

bootstrapApplication(AppComponent, appConfig)
  .catch((err) => console.error(err));
