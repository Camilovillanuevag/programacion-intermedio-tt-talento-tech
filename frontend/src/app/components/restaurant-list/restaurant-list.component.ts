import { Component } from '@angular/core';
import { SearchService } from '../../services/search.service';
import { CommonModule } from '@angular/common';
import { RestaurantCardComponent } from '../restaurant-card/restaurant-card.component';
import { Restaurant } from '../../models/restaurant.model';

@Component({
  selector: 'app-restaurant-list',
  standalone: true,
  imports: [CommonModule, RestaurantCardComponent],
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent {
  allRestaurants: Restaurant[] = [
    {
      id: 1,
      name: 'La Pizzería',
      description: 'Pizza tradicional italiana y pastas frescas.',
      image: 'https://images.unsplash.com/photo-1513104890138-7c749659a591',
      rating: 4.5,
      isOpen: true,
      deliveryTime: '30-40 min',
      category: 'Pizza',
      deliveryFee: 5000,
      address: 'Cra 45 # 10-23',
      phone: '604-1234567',
      menu: [
        { id: 1, name: 'Pizza Margarita', description: 'Pizza con tomate y albahaca', category: 'Pizza', price: 25000 },
        { id: 2, name: 'Lasagna', description: 'Lasagna de carne y queso', category: 'Pasta', price: 28000 }
      ]
    },
    {
      id: 2,
      name: 'Sushi Medellín',
      description: 'Sushi fresco y rolls creativos.',
      image: 'https://images.unsplash.com/photo-1543353071-873f17a7a088',
      rating: 4.8,
      isOpen: true,
      deliveryTime: '25-35 min',
      category: 'Sushi',
      deliveryFee: 7000,
      address: 'Calle 30 # 20-15',
      phone: '604-7654321',
      menu: [
        { id: 3, name: 'Sushi Roll', description: 'Roll de salmón y aguacate', category: 'Sushi', price: 40000 },
        { id: 4, name: 'Nigiri', description: 'Nigiri de salmón fresco', category: 'Sushi', price: 35000 }
      ]
    },
    {
      id: 3,
      name: 'Hamburguesas mama',
      description: 'Las mejores hamburguesas artesanales.',
      image: 'https://images.unsplash.com/photo-1550547660-d9450f859349',
      rating: 4.2,
      isOpen: false,
      deliveryTime: '40-50 min',
      category: 'Hamburguesas',
      deliveryFee: 6000,
      address: 'Av. El Parque # 5-67',
      phone: '604-1122334',
      menu: [
        { id: 5, name: 'Hamburguesa Clásica', description: 'Carne, queso y vegetales', category: 'Hamburguesa', price: 22000 },
        { id: 6, name: 'Hamburguesa BBQ', description: 'Carne, salsa BBQ y cebolla', category: 'Hamburguesa', price: 24000 }
      ]
    },
    {
      id: 4,
      name: 'Comida Típica Paisa',
      description: 'Bandeja paisa y platos tradicionales.',
      image: 'https://images.unsplash.com/photo-1504674900247-0877df9cc836',
      rating: 4.7,
      isOpen: true,
      deliveryTime: '35-45 min',
      category: 'Típica',
      deliveryFee: 4000,
      address: 'Cra 50 # 12-34',
      phone: '604-5566778',
      menu: [
        { id: 7, name: 'Bandeja Paisa', description: 'Plato tradicional paisa', category: 'Típica', price: 30000 },
        { id: 8, name: 'Arepa con Queso', description: 'Arepa rellena de queso', category: 'Típica', price: 8000 }
      ]
    },
    {
      id: 5,
      name: 'Postres Dulce Vida',
      description: 'Postres caseros y repostería gourmet.',
      image: 'https://images.unsplash.com/photo-1505250463360-8d07a3f3a5a0',
      rating: 4.9,
      isOpen: true,
      deliveryTime: '20-30 min',
      category: 'Postres',
      deliveryFee: 3000,
      address: 'Calle 80 # 30-22',
      phone: '604-9988776',
      menu: [
        { id: 9, name: 'Cheesecake', description: 'Cheesecake de frutos rojos', category: 'Postre', price: 15000 },
        { id: 10, name: 'Brownie', description: 'Brownie de chocolate', category: 'Postre', price: 12000 }
      ]
    }
  ];
  filteredRestaurants: Restaurant[] = this.allRestaurants;

  constructor(private searchService: SearchService) {
    this.searchService.searchTerm$.subscribe(term => {
      this.filterRestaurants(term);
    });
  }

  filterRestaurants(term: string) {
    const lowerTerm = term.toLowerCase().trim();
    if (!lowerTerm) {
      this.filteredRestaurants = this.allRestaurants;
      return;
    }
    this.filteredRestaurants = this.allRestaurants.filter(r =>
      r.name.toLowerCase().includes(lowerTerm) ||
      r.category.toLowerCase().includes(lowerTerm) ||
      r.description.toLowerCase().includes(lowerTerm) ||
      r.menu.some(item => item.name.toLowerCase().includes(lowerTerm) || item.category.toLowerCase().includes(lowerTerm))
    );
  }
}
