package cn.com.hystrix.bidinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class BidinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidinfoApplication.class, args);
	}

	public UserDetailsService userDetailsService () {
		return null;
	}
}
