package com.geektrust.backend.service;

import com.geektrust.backend.dto.PrintBillDto;

public interface IBillingService {
    PrintBillDto calculateBill();
}
