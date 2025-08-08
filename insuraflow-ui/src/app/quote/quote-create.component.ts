import { Component } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-quote-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './quote-create.component.html',
  styleUrls: ['./quote-create.component.css']
})
export class QuoteCreateComponent {
  quote = {
    fullName: '',
    identityNumber: '',
    birthDate: '',
    gender: '',
    phoneNumber: '',
    email: ''
  };
successMessage = '';
  constructor(private http: HttpClient) {}
 

  submitQuote() {
    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + btoa('admin:admin123')
    });

    this.http.post('http://localhost:8080/api/quotes', this.quote)
      .subscribe({
        next: res => {
          alert('Quote oluşturuldu.');
          this.quote = {
            fullName: '',
            identityNumber: '',
            birthDate: '',
            gender: '',
            phoneNumber: '',
            email: ''
          };
        },
        error: err => {
          alert('Bir hata oluştu.');
          console.error(err);
        }
      });
  }
}
