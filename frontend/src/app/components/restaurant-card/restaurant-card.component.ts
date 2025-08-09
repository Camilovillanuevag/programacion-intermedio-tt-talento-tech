import { Component, Input } from '@angular/core';
// ...existing code...
import { CommonModule, DecimalPipe } from '@angular/common';
import { Restaurant, MenuItem } from '../../models/restaurant.model';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-restaurant-card',
  standalone: true,
  imports: [CommonModule, DecimalPipe],
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
  }

  handleEscape(): void {
    if (this.showMenuModal) {
      this.closeMenu();
    } else if (this.showCartModal) {
      this.closeCart();
    }
  }
}
