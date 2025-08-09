import { MenuItem } from './menu-item.model';
export type { MenuItem };

export interface Restaurant {
  id: number;
  name: string;
  description: string;
  image: string;
  rating: number;
  deliveryTime: string;
  deliveryFee: number;
  category: string;
  address: string;
  phone: string;
  menu: MenuItem[];
  isOpen: boolean;
}
