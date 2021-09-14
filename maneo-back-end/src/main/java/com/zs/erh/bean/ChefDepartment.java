package com.zs.erh.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("chef-department")
public class ChefDepartment extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String propritie;


    public String getPropritie() {
        return propritie;
    }

    public void setPropritie(String propritie) {
        this.propritie = propritie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
