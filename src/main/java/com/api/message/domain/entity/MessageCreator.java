package com.api.message.domain.entity;


import com.api.message.domain.dto.PaymentNotificationMessageParamsDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MessageCreator {

    private static final String AUTOMATION_TITLE = "⚠️\uD83E\uDD16```Atenção, essa é uma mensagem automática enviada por uma automação de cobrança!```\n";
    private static final String CONDOMINIUM_TITLE = "\n\uD83C\uDFD8️ ```CONDOMÍNIO MARIA ELIZABETH DE BRUIN CAVALHEIRO CNPJ``` ";
    private static final String REFERENCE_TITLE = "\n\nOlá, segue a Taxa de Condomínio referente ao mês ";
    private static final String LABEL_PIX = "\n\n\uD83D\uDD30Chave PIX: ";
    private static final String LABEL_PAYMENT_VALUE = "\n\n\uD83D\uDCB0```Valor da taxa: R$``` ";
    private static final String LABEL_EXPENSES = "\n\n\uD83D\uDCB8```Despesas```\n\n";
    private static final String LABEL_WATER_BILL = "```Copasa: R$``` ";
    private static final String LABEL_ELECTRICITY_BILL = "\n```CEMIG: R$``` ";
    private static final String LABEL_EMPLOYER_PAYROLL = "\n```Folha de Pagamento: R$``` ";
    private static final String LABEL_MAINTENANCE = "\n```Manutenções: R$``` ";
    private static final String LABEL_CLEAN_PRODUCTS = "\n```Produtos de Limpeza: R$``` ";
    private static final String LABEL_OTHERS = "\nOutros: R$ ";
    private static final String LABEL_DUE_DATE = "\n\n\uD83D\uDDD3️```Vencimento: ``` ";
    private static final String LABEL_REPORT = "\n\n\uD83D\uDCCA```Relatório Financeiro do Condomínio```\n";

    public String paymentNotificationMessage(PaymentNotificationMessageParamsDTO params) {

        return AUTOMATION_TITLE +
                CONDOMINIUM_TITLE.concat(params.getCnpj()) +
                REFERENCE_TITLE.concat(params.getReference()) +
                LABEL_PIX.concat(params.getPixKey()) +
                LABEL_PAYMENT_VALUE.concat(params.getPaymentValue()) +
                LABEL_EXPENSES +
                LABEL_WATER_BILL.concat(params.getWaterBill()) +
                LABEL_ELECTRICITY_BILL.concat(params.getElectricityBill()) +
                LABEL_EMPLOYER_PAYROLL.concat(params.getEmployeePayroll()) +
                LABEL_MAINTENANCE.concat(params.getMaintenance()) +
                LABEL_CLEAN_PRODUCTS.concat(params.getCleaningProducts()) +
                LABEL_OTHERS.concat(params.getOthers()) +
                LABEL_DUE_DATE.concat(params.getDueDate()) +
                LABEL_REPORT.concat(params.getLinkReport());
    }
}
