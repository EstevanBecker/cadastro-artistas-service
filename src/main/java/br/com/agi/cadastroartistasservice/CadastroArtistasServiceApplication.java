package br.com.agi.cadastroartistasservice;

import br.com.agi.cadastroartistasservice.configuration.WebServerConfig;
import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroArtistasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServerConfig.class, args);
	}

}
