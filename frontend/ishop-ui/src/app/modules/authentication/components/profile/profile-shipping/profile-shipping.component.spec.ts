import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileShippingComponent } from './profile-shipping.component';

describe('ProfileShippingComponent', () => {
  let component: ProfileShippingComponent;
  let fixture: ComponentFixture<ProfileShippingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileShippingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileShippingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
