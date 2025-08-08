import { Component } from '@angular/core';
import { PolicyService } from '../policy.service';
import { Policy } from '../policy.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-policy-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class PolicyCreateComponent {
  policy: Policy = {
    quoteId: 0,
    startDate: '',
    endDate: '',
    totalPremium: 0
  };

  successMessage = '';

  constructor(private policyService: PolicyService, private router: Router) {}

  createPolicy() {
    this.policyService.create(this.policy).subscribe((result: Policy) => {
      this.successMessage = 'Poliçe başarıyla oluşturuldu. ID: ' + result.id;
    });
  }

  goToPolicyList() {
    this.router.navigate(['/policy/list']);
  }

}
