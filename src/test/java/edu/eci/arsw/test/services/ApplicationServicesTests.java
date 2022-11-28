package edu.eci.arsw.test.services;


import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistenceException;
import edu.eci.arsw.digital_waiter.services.DigitalWaiterServices;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfiguradorSpring.class })
public class ApplicationServicesTests {
    @Autowired
    DigitalWaiterServices dgservices = null;
    
    @Test
    public void deberiaConsultarUnUsuario() {
        try {
            Assert.assertEquals(dgservices.getUserByID("001").iterator().next().getName(),"Mario Bros" );
            Assert.assertEquals(dgservices.getUserByEmail("prueba@gmail.com").iterator().next().getName(),"Mario Bros" );
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Test
    public void deberiaConsultarSiUnUsuarioEsAdministrador(){
        try {
            Assert.assertFalse(dgservices.imIAdmin("prueba@gmail.com"));
            Assert.assertTrue(dgservices.imIAdmin("prueba2@gmail.com"));
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @Test
    public void deberiaConsultarUnRestaurante(){
        try {
            Assert.assertEquals(dgservices.getRestaurantById("r001").iterator().next().getName(),"NiñoPerdido" );
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
