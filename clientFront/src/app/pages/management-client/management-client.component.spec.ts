import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagementClientComponent } from './management-client.component';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('ManagementClientComponent', () => {
  let component: ManagementClientComponent;
  let fixture: ComponentFixture<ManagementClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagementClientComponent ],
      providers: [
        { provide: MatDialogRef, useValue: {} }, // Mock o objeto vacío
        { provide: MAT_DIALOG_DATA, useValue: {} }, 
      ],
      imports : [ ReactiveFormsModule , HttpClientTestingModule],
      schemas: [
        CUSTOM_ELEMENTS_SCHEMA
      ],
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManagementClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
