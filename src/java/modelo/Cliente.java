/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import validators.Dni;

/**
 *
 * @author admin1
 */
@Entity
public class Cliente implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Dni(message = "{comprobarErrorDni}")
    private String dni;
    @Size(min = 5,message = "{tamanoNombre}")
    private String nombre;//tamaño min de 5 caracteres
    
    @Max(value=90,message="{clienteErrorEdadMaximo}")//le puedo añadir message = "No aseguramos clientes mayores de 90 años" pero no internacionaliza el mensaje.Por eso hacemos lo de arriba
    @Min(value = 18,message = "{clienteErrorEdadMinimo}")
    private int edad;//18-90
    @Embedded
    private Direccion direccion;
    @OneToMany(mappedBy = "cliente")
    private Set<Poliza> polizas = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public Set<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(Set<Poliza> polizas) {
        this.polizas = polizas;
    }
    
    public void addPoliza(Poliza poliza) {
        this.polizas.add(poliza);
    }
    public void eliminarPoliza(Poliza poliza){
        this.polizas.remove(poliza);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        else if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

   
    
}
