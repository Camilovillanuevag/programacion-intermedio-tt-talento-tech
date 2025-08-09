import { Component, Input } from '@angular/core';
import { CommonModule, DecimalPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Restaurant, MenuItem } from '../../models/restaurant.model';
import { CartService } from '../../services/cart.service';

interface OrderData {
  name: string;
  phone: string;
  address: string;
  notes?: string;
}

@Component({
  selector: 'app-restaurant-card',
  standalone: true,
  imports: [CommonModule, DecimalPipe, FormsModule],
  templateUrl: './restaurant-card.component.html',
  styleUrls: ['./restaurant-card.component.css'],
  host: {
    '(document:keydown.escape)': 'handleEscape()'
  }
})

export class RestaurantCardComponent {
  @Input() restaurant!: Restaurant;
  showMenuModal = false;
  showCartModal = false;
  showCheckoutForm = false;
  
  orderData: OrderData = {
    name: '',
    phone: '',
    address: '',
    notes: ''
  };

  constructor(public cartService: CartService) {}

  getStarsArray(): number[] {
    return Array(5).fill(0).map((_, i) => i + 1);
  }

  openMenu(): void {
    this.showMenuModal = true;
  }

  closeMenu(): void {
    this.showMenuModal = false;
  }

  addToCart(item: MenuItem) {
    this.cartService.addItem(item);
  }

  openCart(): void {
    this.showCartModal = true;
  }

  closeCart(): void {
    this.showCartModal = false;
    this.showCheckoutForm = false;
    this.resetOrderData();
  }

  handleEscape(): void {
    if (this.showMenuModal) {
      this.closeMenu();
    } else if (this.showCartModal) {
      this.closeCart();
    }
  }

  resetOrderData(): void {
    this.orderData = {
      name: '',
      phone: '',
      address: '',
      notes: ''
    };
  }

  submitOrder(): void {
    if (!this.orderData.name || !this.orderData.phone || !this.orderData.address) {
      alert('Por favor complete los campos requeridos');
      return;
    }

    const cartItems = (this.cartService as any).itemsSubject.value;
    
    const order = {
      items: cartItems,
      total: this.cartService.getTotal(),
      ...this.orderData,
      restaurantName: this.restaurant.name,
      date: new Date()
    };

    console.log('Orden enviada:', order);
    alert('¡Pedido realizado con éxito! Pronto recibirás tu comida.');
    this.cartService.clearCart();
    this.closeCart();
  }
}
