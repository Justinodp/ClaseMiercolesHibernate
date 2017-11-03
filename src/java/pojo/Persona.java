/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */
// Anotacion que declara la calse como una entidad (renglon de excel)
@Entity
@Table(name="Persona",catalog="generationHibernate") // Anotacion que designa el nombre del libro y archivo de donde se se ingresan/consulta los datos)
public class Persona {
    //@id hace referencia a la primary key de Persona @GenerateValue da un auto incremental a cada entidad
    @Id @GeneratedValue
    @Column(name="idPersona") // @Column hace refencia a la columna "id persona" 
    private int idPersona; // Variable
    
    @Column(name="Nombre",nullable=false)// @Column hace refencia a la columna "Nombre" de la tabla Persona con la instruccion not null mediante nullable=false
    private String Nombre; // Variable
    
    @Column(name="Paterno")// @Column hace refencia a la columna "Paterno" de la tabla Persona
    private String Paterno; // Variable
    
     @Column(name="Materno")// @Column hace refencia a la columna "Materno" de la tabla Persona
    private String Materno; // Variable
     
     @Column(name="Telefono")// @Column hace refencia a la columna "Telefono" de la tabla Persona
    private String Telefono; // Variable
    
     @ManyToOne // Declara la relacion de la Tabla Persona con IdTipoPersona
     @JoinColumn(name="idTipoPersona") // Llave foranera de idTipoPersona 
    private TipoPersona tipoPersona; // Variable "tipo persona" del objeto "TipoPersona" 

     
     
     // ENCAPSULAMIENTO DE LA CLASE TIPO PERSONA (get/set para asignar y obtener valores de cada variable)
    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
