import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavelignecommandeComponent } from './savelignecommande.component';

describe('SavelignecommandeComponent', () => {
  let component: SavelignecommandeComponent;
  let fixture: ComponentFixture<SavelignecommandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SavelignecommandeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavelignecommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
