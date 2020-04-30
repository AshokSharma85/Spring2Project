import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDebitedBalanceHistoryComponent } from './view-debited-balance-history.component';

describe('ViewDebitedBalanceHistoryComponent', () => {
  let component: ViewDebitedBalanceHistoryComponent;
  let fixture: ComponentFixture<ViewDebitedBalanceHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDebitedBalanceHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDebitedBalanceHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
