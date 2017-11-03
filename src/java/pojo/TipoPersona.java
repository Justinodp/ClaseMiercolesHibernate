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
import javax.persistence.Table;

/**
 * #Pray4Tanque
 *
 * @author RigoBono
 */
// Anotacion que declara la calse como una entidad (renglon de excel)
@Entity
@Table(name = "TipoPersona", catalog = "generationHibernate")// Anotacion que designa el nombre del libro y archivo de donde se se ingresan/consulta los datos)
public class TipoPersona {

    //@id hace referencia a la primary key de TipoPersona @GenerateValue da un auto incremental a cada entidad
    @Id
    @GeneratedValue
    @Column(name = "idTipoPersona")
    private int idTipoPersona;

    @Column(name = "TipoPersonacol")
    private String TipoPersona;

    // Constructor vacio para optimizar la memoria debido a la reflexcion
    public TipoPersona() {

    }

    // ENCAPSULAMIENTO DE LA CLASE TIPO PERSONA (get/set para asignar y obtener valores de cada variable)
    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }

}
