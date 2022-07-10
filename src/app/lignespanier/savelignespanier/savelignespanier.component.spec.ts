import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavelignespanierComponent } from './savelignespanier.component';

describe('SavelignespanierComponent', () => {
  let component: SavelignespanierComponent;
  let fixture: ComponentFixture<SavelignespanierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SavelignespanierComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavelignespanierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
