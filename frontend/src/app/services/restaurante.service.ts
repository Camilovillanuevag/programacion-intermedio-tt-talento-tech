import { Restaurante } from '../models/restaurante.model';

export const RESTAURANTES: Restaurante[] = [
  {
    id: 1,
    nombre: 'La Pizzería',
    direccion: 'Cra 45 # 10-23',
    estrellas: 4.5,
    precioPromedio: 25000,
    menu: [
      { id: 1, nombre: 'Pizza Margarita', descripcion: 'Pizza tradicional italiana', precio: 25000 }
    ]
  },
  {
    id: 2,
    nombre: 'Sushi Medellín',
    direccion: 'Calle 30 # 20-15',
    estrellas: 4.8,
    precioPromedio: 40000,
    menu: [
      { id: 2, nombre: 'Sushi Roll', descripcion: 'Roll de salmón y aguacate', precio: 40000 }
    ]
  }
];
