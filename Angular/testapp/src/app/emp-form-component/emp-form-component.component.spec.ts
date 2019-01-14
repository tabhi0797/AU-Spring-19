import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpFormComponentComponent } from './emp-form-component.component';

describe('EmpFormComponentComponent', () => {
  let component: EmpFormComponentComponent;
  let fixture: ComponentFixture<EmpFormComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpFormComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpFormComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
