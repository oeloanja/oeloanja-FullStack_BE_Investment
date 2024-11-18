package com.billit.investment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class InvestmentPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer portfolioId;

    private Integer userInvestorId;
    private String portfolioName;
    private String riskLevel;
    private BigDecimal targetReturnRate;
    private BigDecimal totalInvestedAmount;
    private BigDecimal actualReturnValue;
    private BigDecimal actualReturnRate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}