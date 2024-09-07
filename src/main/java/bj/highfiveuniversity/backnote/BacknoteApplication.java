package bj.highfiveuniversity.backnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= "bj.highfiveuniversity")
public class BacknoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacknoteApplication.class, args);
	}

}
