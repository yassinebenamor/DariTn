import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MescriteresComponent } from './mescriteres.component';

describe('MescriteresComponent', () => {
  let component: MescriteresComponent;
  let fixture: ComponentFixture<MescriteresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MescriteresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MescriteresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
