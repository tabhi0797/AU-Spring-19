import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpListComponentComponent } from './emp-list-component.component';

describe('EmpListComponentComponent', () => {
  let component: EmpListComponentComponent;
  let fixture: ComponentFixture<EmpListComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpListComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
