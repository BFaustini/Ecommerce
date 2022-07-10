import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LignespaniersComponent } from './lignespaniers.component';

describe('LignespaniersComponent', () => {
  let component: LignespaniersComponent;
  let fixture: ComponentFixture<LignespaniersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LignespaniersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LignespaniersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
