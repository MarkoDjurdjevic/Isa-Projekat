import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListRegisterUserComponent } from './list-register-user.component';

describe('ListRegisterUserComponent', () => {
  let component: ListRegisterUserComponent;
  let fixture: ComponentFixture<ListRegisterUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListRegisterUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListRegisterUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
