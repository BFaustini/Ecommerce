import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LignecommandesComponent } from './lignecommandes.component';

describe('LignecommandesComponent', () => {
  let component: LignecommandesComponent;
  let fixture: ComponentFixture<LignecommandesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LignecommandesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LignecommandesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
