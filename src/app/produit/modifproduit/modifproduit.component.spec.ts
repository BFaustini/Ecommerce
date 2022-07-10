import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifproduitComponent } from './modifproduit.component';

describe('ModifproduitComponent', () => {
  let component: ModifproduitComponent;
  let fixture: ComponentFixture<ModifproduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifproduitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifproduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
