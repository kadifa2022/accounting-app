package com.accounting.entity;

import com.accounting.enums.InvoiceStatus;
import com.accounting.enums.InvoiceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity{
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    private String invoiceNo;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    @ManyToOne(fetch =FetchType.LAZY)
    private ClientVendor clientVendor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
}
