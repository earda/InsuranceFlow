import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PolicyCreateComponent } from '../policy/create/create.component';
import { PolicyListComponent } from '../policy/list/list.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    PolicyCreateComponent,
    PolicyListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    PolicyCreateComponent,
    PolicyListComponent
  ]
})
export class PolicyModule { }
