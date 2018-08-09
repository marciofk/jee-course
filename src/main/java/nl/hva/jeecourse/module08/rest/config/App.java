package nl.hva.jeecourse.module08.rest.config;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * The application config
 * 
 * @author marciofk
 */
@ApplicationPath("services/rest")
public class App extends ResourceConfig {
    
    public App() {
    }
    
    
    
}
