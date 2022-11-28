package edu.eci.arsw.test.services;


import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Table;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistenceException;
import edu.eci.arsw.digital_waiter.services.DigitalWaiterServices;
import java.util.Set;
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
    
    @Test
    public void deberiaModificarLaDsiponibilidadDeUnaMesa(){
        try {
            Assert.assertFalse(dgservices.getTableById("t004").iterator().next().getDisponibility());
            dgservices.setTableDisponibilityByRestaurant("t004", "r001", true);
            Assert.assertTrue(dgservices.getTableById("t004").iterator().next().getDisponibility());
            dgservices.setTableDisponibilityByRestaurant("t004", "r001", false);
            Assert.assertFalse(dgservices.getTableById("t004").iterator().next().getDisponibility());
            dgservices.setTableDisponibilityByRestaurant("t00", "r001", true);
            Assert.assertFalse(dgservices.getTableById("t004").iterator().next().getDisponibility());
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void deberiaConsultarElRestauranteAsociadoAUnaCuenaAdministrador(){
        try {
            Assert.assertEquals(dgservices.getRestaurantByUser("111").iterator().next().getId(), "r001");
            Assert.assertEquals(dgservices.getRestaurantByUser("001").iterator().hasNext(), false);
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void deberiaConsultarLosMenusDeUnRestaurante(){
        try {
            Set<Menu> menus = dgservices.getMenusByRestaurant("r002");
            for (int i = 0; i < menus.size(); i++){
                Assert.assertEquals(menus.iterator().next().getIdRestaurant(), "r002");
            }
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void deberiaConsultarLosPlatosDeUnRestaurante(){
        try {
            Set<Plato> platos = dgservices.getPlatosByrestaurant("r002");
            for(int i = 0; i < platos.size(); i++){
                Assert.assertEquals(platos.iterator().next().getIdRestaurant(), "r002");
            }
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void deberiaConsultarLasMesasDeUnRestaurante(){
        try {
            Set<Table> mesas = dgservices.getTablesByRestaurant("r002");
            for(int i = 0; i < mesas.size(); i++){
                Assert.assertEquals(mesas.iterator().next().getIdRestaurant(), "r002");
            }
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void noDeberiaPersistirContraseñasEnLaBaseDeDatos(){
        String usr = "prueba@gmail.com";
        String pswd = "123456";
        
        try {
            Assert.assertTrue(dgservices.login(usr, pswd));
            Assert.assertFalse(dgservices.getUserByEmail(usr).iterator().next().getPswd().equals(pswd));
        } catch (DigitalWaiterPersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
