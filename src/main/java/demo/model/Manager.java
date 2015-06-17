package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by poo2 on 17/06/2015.
 */

@Entity
public class Manager extends Employee {

    @Column
    private Double bonusSuccess;


    public Manager() {
    }

    public Double getBonusSuccess() {
        return bonusSuccess;
    }

    public void setBonusSuccess(Double bonusSuccess) {
        this.bonusSuccess = bonusSuccess;
    }

    @Override
    public String toString() {
        String manager = super.toString();
        return manager + "Manager{" +
                "bonusSuccess=" + bonusSuccess +
                '}';
    }
}
