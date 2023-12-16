package sandipchitale.multitssslbundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(MultiTSSslProperties.class)
public class MultitssslbundleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitssslbundleApplication.class, args);
	}

	@Bean
	CommandLineRunner clr(ObjectMapper objectMapper, MultiTSSslProperties multiTSSslProperties, SslProperties sslProeprties) {
		return (String... args) -> {
			System.out.println("multiTSSslProperties:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(multiTSSslProperties));

			System.out.println("sslProeprties:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sslProeprties));
		};
	}
}
