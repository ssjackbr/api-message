package com.api.message.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentNotificationMessageParamsDTO {

    private String paymentValue;
    private String pixKey;
    private String cnpj;
    private String reference;
    private String waterBill;
    private String electricityBill;
    private String employeePayroll;
    private String maintenance;
    private String cleaningProducts;
    private String others;
    private String dueDate;
    private String linkReport;
}
