/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {

    // SessionFactory crea las sessiones (Hilos)
    private static final SessionFactory sessionFactory;
    // SessionFactory crea sessiones de manera local (asignando un nuevo hilos)
    private static final ThreadLocal localSession;

    static {

        try {
            // Asigna el achivo de configuracion del hibernate.cgf.xml de donde se toman los datos 
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            //Da contexto al sessionFactory en base a la configuracion 
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        //Crea un hilo local en la session local
        localSession = new ThreadLocal();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Crea y verifica la nueva session local
    public static Session getLocalSession() {
        // Creacion
        Session session = (Session) localSession.get();
        if (session == null) {
            // Verificacion
            session = sessionFactory.openSession();
            localSession.set(session);
            System.out.println("\nsesion iniciada");
        }
        return session;
    }
    // Metodo que finaliza el localSession

    public static void closeLocalSession() {
        Session session = (Session) localSession.get();
        if (session != null) {
            session.close();
        }
        localSession.set(null);
        System.out.println("sesion cerrada\n");
    }
}
