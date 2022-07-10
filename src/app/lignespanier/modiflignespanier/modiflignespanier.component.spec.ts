import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModiflignespanierComponent } from './modiflignespanier.component';

describe('ModiflignespanierComponent', () => {
  let component: ModiflignespanierComponent;
  let fixture: ComponentFixture<ModiflignespanierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModiflignespanierComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModiflignespanierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
