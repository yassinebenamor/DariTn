import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimulationcreditComponent } from './simulationcredit.component';

describe('SimulationcreditComponent', () => {
  let component: SimulationcreditComponent;
  let fixture: ComponentFixture<SimulationcreditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SimulationcreditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SimulationcreditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
