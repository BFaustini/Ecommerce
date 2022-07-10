import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveutilisateurComponent } from './saveutilisateur.component';

describe('SaveutilisateurComponent', () => {
  let component: SaveutilisateurComponent;
  let fixture: ComponentFixture<SaveutilisateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveutilisateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveutilisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
