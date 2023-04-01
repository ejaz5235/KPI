package net.ejazcurd.springbootcurd;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableEncryptableProperties

public class SpringbootCurdApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCurdApplication.class, args);
	}

}
