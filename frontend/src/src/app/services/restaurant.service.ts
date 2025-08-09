import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Restaurant } from '../models/restaurant.model';

@Injectable({ providedIn: 'root' })
export class RestaurantService {
  private restaurantsSubject = new BehaviorSubject<Restaurant[]>([]);
  public restaurants$ = this.restaurantsSubject.asObservable();

  constructor() {
    this.loadMockData();
  }

  private loadMockData(): void {
    const mockRestaurants: Restaurant[] = [
      {
        id: 1,
        name: 'La Pizzería del Centro',
        description: 'Las mejores pizzas artesanales de Medellín',
        image: 'https://via.placeholder.com/300x200/FF6B6B/FFFFFF?text=Pizzeria',
        rating: 4.5,
        deliveryTime: '25-35 min',
        deliveryFee: 3500,
        category: 'Pizza',
        address: 'Carrera 50 #45-30, El Poblado',
        phone: '+57 4 123 4567',
        isOpen: true,
        menu: [
          { id: 1, name: 'Pizza Margherita', description: 'Tomate, mozzarella, albahaca fresca', price: 28000, category: 'Pizzas' },
          { id: 2, name: 'Pizza Pepperoni', description: 'Pepperoni, mozzarella, salsa de tomate', price: 32000, category: 'Pizzas' }
        ]
      },
      {
        id: 2,
        name: 'Burger Paisa',
        description: 'Hamburguesas gourmet con sabor paisa',
        image: 'https://via.placeholder.com/300x200/4ECDC4/FFFFFF?text=Burger',
        rating: 4.2,
        deliveryTime: '20-30 min',
        deliveryFee: 4000,
        category: 'Hamburguesas',
        address: 'Calle 10 #43-20, Laureles',
        phone: '+57 4 234 5678',
        isOpen: true,
        menu: [
          { id: 3, name: 'Burger Clásica', description: 'Carne de res, lechuga, tomate, cebolla', price: 18000, category: 'Hamburguesas' },
          { id: 4, name: 'Burger BBQ', description: 'Carne de res, salsa BBQ, cebolla caramelizada', price: 22000, category: 'Hamburguesas' }
        ]
      },
      {
        id: 3,
        name: 'Sushi Medellín',
        description: 'Auténtico sushi japonés',
        image: 'https://via.placeholder.com/300x200/45B7D1/FFFFFF?text=Sushi',
        rating: 4.8,
        deliveryTime: '35-45 min',
        deliveryFee: 5000,
        category: 'Sushi',
        address: 'Carrera 35 #8A-15, El Poblado',
        phone: '+57 4 345 6789',
        isOpen: true,
        menu: [
          { id: 5, name: 'Combo Sushi', description: '12 piezas variadas de sushi', price: 45000, category: 'Combos' },
          { id: 6, name: 'Roll Philadelphia', description: 'Salmón, queso crema, pepino', price: 28000, category: 'Rolls' }
        ]
      },
      {
        id: 4,
        name: 'Comida Típica Antioqueña',
        description: 'Platos tradicionales de la región',
        image: 'https://via.placeholder.com/300x200/F39C12/FFFFFF?text=Tipica',
        rating: 4.6,
        deliveryTime: '30-40 min',
        deliveryFee: 3000,
        category: 'Típica',
        address: 'Carrera 70 #52-20, Robledo',
        phone: '+57 4 456 7890',
        isOpen: false,
        menu: [
          { id: 7, name: 'Bandeja Paisa', description: 'Frijoles, arroz, carne, chorizo, chicharrón', price: 25000, category: 'Platos Fuertes' },
          { id: 8, name: 'Sancocho Antioqueño', description: 'Sancocho tradicional con verduras', price: 20000, category: 'Sopas' }
        ]
      }
    ];
    this.restaurantsSubject.next(mockRestaurants);
  }

  getRestaurants(): Observable<Restaurant[]> {
    return this.restaurants$;
  }

  getRestaurantById(id: number): Restaurant | undefined {
    return this.restaurantsSubject.value.find(r => r.id === id);
  }

  searchRestaurants(query: string): Observable<Restaurant[]> {
    const filtered = this.restaurantsSubject.value.filter(restaurant =>
      restaurant.name.toLowerCase().includes(query.toLowerCase()) ||
      restaurant.category.toLowerCase().includes(query.toLowerCase()) ||
      restaurant.description.toLowerCase().includes(query.toLowerCase())
    );
    return new BehaviorSubject(filtered).asObservable();
  }
}
