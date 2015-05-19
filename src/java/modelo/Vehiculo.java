/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import validators.Matricula;

/**
 *
 * @author admin1
 */
@Entity
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @OneToOne(mappedBy = "vehiculo")
    private Poliza poliza;
    
    @Matricula(message = "{comprobarMatricula}")
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    
    @Max(value = 5000, message = "{maximoCv}")
    @Min(value = 50, message = "{minimoCv}")
    private long cv;//de 50 a 5000
    
    @Max(value = 5, message = "{maximoNumeroPuertas}")
    @Min(value = 2, message = "{minimoNumeroPuertas}")
    private int numeroPuertas;//2-5

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getCv() {
        return cv;
    }

    public void setCv(long cv) {
        this.cv = cv;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (this.id != other.id) {
            return false;
        } else if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

}
