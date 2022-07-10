import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModiflignecommandeComponent } from './modiflignecommande.component';

describe('ModiflignecommandeComponent', () => {
  let component: ModiflignecommandeComponent;
  let fixture: ComponentFixture<ModiflignecommandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModiflignecommandeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModiflignecommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
