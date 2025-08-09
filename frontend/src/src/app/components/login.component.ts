import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  correo: string = '';
  contrasena: string = '';
  error: string = '';

  iniciarSesion() {
    // Simulación de inicio de sesión
    if (this.correo === 'juan@correo.com' && this.contrasena === '1234') {
      this.error = '';
      alert('¡Inicio de sesión exitoso!');
    } else {
      this.error = 'Correo o contraseña incorrectos';
    }
  }
}
