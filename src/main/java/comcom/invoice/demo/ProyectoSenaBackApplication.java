	package comcom.invoice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProyectoSenaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSenaBackApplication.class, args);
	}

	/*@Bean
	public WebSecurityConfigurerAdapter webSecurity() {
	    return new WebSecurityConfigurerAdapter() {

	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	            http.headers().addHeaderWriter(
	                    new StaticHeadersWriter("Access-Control-Allow-Origin", "*"));


	        }
	    };*/
}
