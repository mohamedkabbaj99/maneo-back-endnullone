/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zs.erh.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author admin
 */
@Entity
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;


    @ManyToOne
    private ProduitCategorie produitCategorie;

    public Produit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ProduitCategorie getProduitCategorie() {
        return produitCategorie;
    }

    public void setProduitCategorie(ProduitCategorie produitCategorie) {
        this.produitCategorie = produitCategorie;
    }

}
