export interface Restaurante {
  id: number;
  nombre: string;
  direccion: string;
  estrellas: number;
  precioPromedio: number;
  menu: MenuItem[];
}

export interface MenuItem {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number;
}
