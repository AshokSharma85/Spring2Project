import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCreditedBalanceHistoryComponent } from './view-credited-balance-history.component';

describe('ViewCreditedBalanceHistoryComponent', () => {
  let component: ViewCreditedBalanceHistoryComponent;
  let fixture: ComponentFixture<ViewCreditedBalanceHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCreditedBalanceHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCreditedBalanceHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
