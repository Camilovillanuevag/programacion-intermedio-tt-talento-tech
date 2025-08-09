import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @Input() showModal = false;
  @Output() modalClose = new EventEmitter<void>();

  loginData = {
    email: '',
    password: ''
  };

  constructor(private authService: AuthService) {}

  onSubmit(): void {
    if (this.loginData.email && this.loginData.password) {
      const success = this.authService.login(this.loginData.email, this.loginData.password);
      if (success) {
        this.closeModal();
        this.resetForm();
      }
    }
  }

  closeModal(): void {
    this.modalClose.emit();
    this.resetForm();
  }

  private resetForm(): void {
    this.loginData = {
      email: '',
      password: ''
    };
  }
}
