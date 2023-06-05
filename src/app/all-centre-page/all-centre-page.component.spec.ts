import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCentrePageComponent } from './all-centre-page.component';

describe('AllCentrePageComponent', () => {
  let component: AllCentrePageComponent;
  let fixture: ComponentFixture<AllCentrePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllCentrePageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllCentrePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
