import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveproduitComponent } from './saveproduit.component';

describe('SaveproduitComponent', () => {
  let component: SaveproduitComponent;
  let fixture: ComponentFixture<SaveproduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveproduitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveproduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
