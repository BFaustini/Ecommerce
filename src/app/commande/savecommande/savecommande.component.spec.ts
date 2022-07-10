import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavecommandeComponent } from './savecommande.component';

describe('SavecommandeComponent', () => {
  let component: SavecommandeComponent;
  let fixture: ComponentFixture<SavecommandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SavecommandeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavecommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
