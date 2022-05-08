import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContratachatComponent } from './contratachat.component';

describe('ContratachatComponent', () => {
  let component: ContratachatComponent;
  let fixture: ComponentFixture<ContratachatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContratachatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContratachatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
