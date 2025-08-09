import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SearchService } from '../../services/search.service';

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent {
  searchTerm = '';
  selectedCategory = '';
  categories = [
    'Todos', 'Pizza', 'Hamburguesas', 'Sushi', 'Típica', 'Comida Rápida', 'Postres'
  ];

  constructor(private searchService: SearchService) {}

  onSearchChange(): void {
    this.searchService.updateSearchTerm(this.searchTerm);
  }

  onSearch(): void {
    this.searchService.updateSearchTerm(this.searchTerm);
  }

  onCategoryFilter(category: string): void {
    this.selectedCategory = this.selectedCategory === category ? '' : category;
    const searchTerm = category === 'Todos' || !this.selectedCategory ? '' : category;
    this.searchTerm = searchTerm;
    this.searchService.updateSearchTerm(searchTerm);
  }
}
