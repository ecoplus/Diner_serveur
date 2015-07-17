/**
 * 
 */
package fr.sallafranque.diner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author MATT-FIXE
 *
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"fr.sallafranque.diner"})
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
