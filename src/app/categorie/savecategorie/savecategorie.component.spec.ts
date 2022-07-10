import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavecategorieComponent } from './savecategorie.component';

describe('SavecategorieComponent', () => {
  let component: SavecategorieComponent;
  let fixture: ComponentFixture<SavecategorieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SavecategorieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SavecategorieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
