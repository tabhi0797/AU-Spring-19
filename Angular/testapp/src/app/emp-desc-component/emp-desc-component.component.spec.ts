import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpDescComponentComponent } from './emp-desc-component.component';

describe('EmpDescComponentComponent', () => {
  let component: EmpDescComponentComponent;
  let fixture: ComponentFixture<EmpDescComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpDescComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpDescComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
