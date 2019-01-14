import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeptListComponentComponent } from './dept-list-component.component';

describe('DeptListComponentComponent', () => {
  let component: DeptListComponentComponent;
  let fixture: ComponentFixture<DeptListComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeptListComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeptListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
