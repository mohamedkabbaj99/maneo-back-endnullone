package com.zs.erh.bean;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity

public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer annee;
    private String description;
    @Column(precision = 11, scale = 2)
    private BigDecimal mtTotal;
    @Column(precision = 11, scale = 2)
    private BigDecimal mtPaye;
    @Column(precision = 11, scale = 2)
    private BigDecimal mtReserve;


    @OneToMany
    private List<BudgetEntiteAdministrative> budgetEntiteAdministratives;
    @OneToOne
    private BudgetDetail budgetDetail;

    public Budget() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BudgetDetail getBudgetDetail() {
        return budgetDetail;
    }

    public void setBudgetDetail(BudgetDetail budgetDetail) {
        this.budgetDetail = budgetDetail;
    }

    public List<BudgetEntiteAdministrative> getBudgetEntiteAdministratives() {
        return budgetEntiteAdministratives;
    }

    public void setBudgetEntiteAdministratives(List<BudgetEntiteAdministrative> budgetEntiteAdministratives) {
        this.budgetEntiteAdministratives = budgetEntiteAdministratives;
    }

    public BigDecimal getMtTotal() {
        return mtTotal;
    }

    public void setMtTotal(BigDecimal mtTotal) {
        this.mtTotal = mtTotal;
    }

    public BigDecimal getMtPaye() {
        return mtPaye;
    }

    public void setMtPaye(BigDecimal mtPaye) {
        this.mtPaye = mtPaye;
    }

    public BigDecimal getMtReserve() {
        return mtReserve;
    }

    public void setMtReserve(BigDecimal mtReserve) {
        this.mtReserve = mtReserve;
    }


}
