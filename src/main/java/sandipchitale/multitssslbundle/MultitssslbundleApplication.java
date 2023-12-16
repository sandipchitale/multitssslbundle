package sandipchitale.multitssslbundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultitssslbundleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitssslbundleApplication.class, args);
	}

	@Bean
	CommandLineRunner clr(ObjectMapper objectMapper, SslProperties sslProeprties) {
		return (String... args) -> {
			System.out.println("sslProeprties:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sslProeprties));
		};
	}
}
