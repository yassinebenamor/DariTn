import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepotPdfComponent } from './depot-pdf.component';

describe('DepotPdfComponent', () => {
  let component: DepotPdfComponent;
  let fixture: ComponentFixture<DepotPdfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DepotPdfComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DepotPdfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
