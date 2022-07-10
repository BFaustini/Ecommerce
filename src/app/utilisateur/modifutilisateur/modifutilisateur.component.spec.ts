import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifutilisateurComponent } from './modifutilisateur.component';

describe('ModifutilisateurComponent', () => {
  let component: ModifutilisateurComponent;
  let fixture: ComponentFixture<ModifutilisateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifutilisateurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifutilisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
