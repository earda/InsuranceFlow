import { Routes } from '@angular/router';
import { PolicyCreateComponent } from './policy/create/create.component';
import { PolicyListComponent } from './policy/list/list.component';
import { QuoteCreateComponent } from './quote/quote-create.component';

export const routes: Routes = [
  { path: 'policy/create', component: PolicyCreateComponent },
  { path: 'policy/list', component: PolicyListComponent },
  { path: 'quote/create', component: QuoteCreateComponent },
  { path: '', redirectTo: 'quote/create', pathMatch: 'full' },
  { path: '**', redirectTo: 'quote/create' }
];
