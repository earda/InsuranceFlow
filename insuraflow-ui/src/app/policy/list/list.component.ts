import { Component, OnInit } from '@angular/core';
import { PolicyService } from '../policy.service'; // Doğru yolu yaz
import { Policy } from '../policy.model';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-policy-list',
    standalone: true,
    imports: [CommonModule],
  templateUrl: './list.component.html',
})
export class PolicyListComponent implements OnInit {
  policies: Policy[] = [];

  constructor(private policyService: PolicyService, private router: Router) {}

  ngOnInit(): void {
    this.policyService.getAll().subscribe((data) => {
      this.policies = data;
    });
  }
    goToCreatePolicy() {
        this.router.navigate(['/policy/create']);
      }
}
