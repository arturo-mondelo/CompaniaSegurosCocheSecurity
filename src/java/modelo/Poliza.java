/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

/**
 *
 * @author admin1
 */
@Entity
public class Poliza implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(1)
    private long capitalMaximoPorSiniestro;
    @Min(1)
    private long cuantia;
    private String condiciones;
    @OneToOne
    @JoinTable(name = "Vehiculo_Poliza", joinColumns = @JoinColumn(name ="idPoliza", unique = true), 
            inverseJoinColumns = @JoinColumn(name = "idVehiculo"))
    private Vehiculo vehiculo;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCapitalMaximoPorSiniestro() {
        return capitalMaximoPorSiniestro;
    }

    public void setCapitalMaximoPorSiniestro(long capitalMaximoPorSiniestro) {
        this.capitalMaximoPorSiniestro = capitalMaximoPorSiniestro;
    }

    public long getCuantia() {
        return cuantia;
    }

    public void setCuantia(long cuantia) {
        this.cuantia = cuantia;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
}
