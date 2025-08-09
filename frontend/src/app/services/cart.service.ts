import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { MenuItem } from '../models/restaurant.model';

@Injectable({ providedIn: 'root' })
export class CartService {
  private itemsSubject = new BehaviorSubject<MenuItem[]>([]);
  items$ = this.itemsSubject.asObservable();

  addItem(item: MenuItem) {
    const items = [...this.itemsSubject.value, item];
    this.itemsSubject.next(items);
  }

  removeItem(index: number) {
    const items = [...this.itemsSubject.value];
    items.splice(index, 1);
    this.itemsSubject.next(items);
  }

  clearCart() {
    this.itemsSubject.next([]);
  }

  getTotal() {
    return this.itemsSubject.value.reduce((acc, item) => acc + item.price, 0);
  }
}
