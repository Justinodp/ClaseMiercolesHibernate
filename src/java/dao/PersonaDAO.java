/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class PersonaDAO {

    // Establace la variable Session con el valor session
    Session session;

    // Obtiene una session local de HibernateUtil
    public PersonaDAO() {
        session = HibernateUtil.getLocalSession();
    }

    // Consulta la base de datos para obtener el valor ID de una persona
    public Persona getPersonaById(int id) {
        return (Persona) session.load(Persona.class, id);
    }

    // Solicita a la base de datos la lista de persona con la restriccion de nombre
    public List<Persona> getPersonaByName(String nombre) {
        List<Persona> listaDePersonas = (List<Persona>) session.createCriteria(Persona.class)
                .add(Restrictions.eq("Nombre", nombre));
        return listaDePersonas;
    }

    // Modifica el valor nombre de una persona solicitada mediante el id, haciendo una "transaction"
    public boolean updateById(int id, Persona persona) {
        Persona personaAModificar = getPersonaById(id);
        try {
            Transaction transaccion = session.beginTransaction();
            personaAModificar.setNombre(persona.getNombre());
            session.update(personaAModificar);
            transaccion.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Agrega una persona nueva a la base de datos, ingresando cada uno de los campos, esta accion se realiza mediante un transaction
    public boolean savePersona(String nombre, String materno, String paterno, String telefono, int idTipoPersona) {
        // Instancia del objeto "personaDeTanque" al cual se le asignan los valores de cada campo
        Persona personaDeTanque = new Persona();
        TipoPersona tipoDeTanque = (TipoPersona) session.load(TipoPersona.class, idTipoPersona);
        //ingreso de campos
        personaDeTanque.setNombre(nombre);
        personaDeTanque.setMaterno(materno);
        personaDeTanque.setPaterno(paterno);
        personaDeTanque.setTelefono(telefono);
        personaDeTanque.setTipoPersona(tipoDeTanque);
        try {
            //Transaction
            Transaction transaccion = session.beginTransaction();
            session.save(personaDeTanque);
            transaccion.commit();
            return true;
        } catch (Exception e) {

        } finally {

        }
        return true;
    }

}
