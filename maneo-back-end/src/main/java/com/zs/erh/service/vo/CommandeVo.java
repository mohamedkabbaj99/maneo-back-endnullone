package com.zs.erh.service.vo;

public class CommandeVo {
    private Long id;
    private String description;
    private String reference;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalPaye;
    private String totalPayeMin;
    private String totalPayeMax;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalMin() {
        return totalMin;
    }

    public void setTotalMin(String totalMin) {
        this.totalMin = totalMin;
    }

    public String getTotalMax() {
        return totalMax;
    }

    public void setTotalMax(String totalMax) {
        this.totalMax = totalMax;
    }

    public String getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(String totalPaye) {
        this.totalPaye = totalPaye;
    }

    public String getTotalPayeMin() {
        return totalPayeMin;
    }

    public void setTotalPayeMin(String totalPayeMin) {
        this.totalPayeMin = totalPayeMin;
    }

    public String getTotalPayeMax() {
        return totalPayeMax;
    }

    public void setTotalPayeMax(String totalPayeMax) {
        this.totalPayeMax = totalPayeMax;
    }
}
