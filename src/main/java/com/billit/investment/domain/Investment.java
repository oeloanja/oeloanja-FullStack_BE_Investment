package com.billit.investment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer investmentId;

    private Integer groupId;
    private Integer userInvestorId;
    private Integer accountInvestorId;
    private BigDecimal investmentAmount;
    private LocalDateTime investmentDate;
    private BigDecimal expectedReturnRate;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
