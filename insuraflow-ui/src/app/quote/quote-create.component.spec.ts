import { ComponentFixture, TestBed } from '@angular/core/testing';
import { QuoteCreateComponent } from './quote-create.component';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('QuoteCreateComponent', () => {
  let component: QuoteCreateComponent;
  let fixture: ComponentFixture<QuoteCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuoteCreateComponent ],
      imports: [ FormsModule, HttpClientTestingModule ]
    }).compileComponents();

    fixture = TestBed.createComponent(QuoteCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });
});
