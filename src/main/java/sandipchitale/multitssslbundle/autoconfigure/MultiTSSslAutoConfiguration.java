package sandipchitale.multitssslbundle.autoconfigure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ssl.SslBundleRegistrar;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.ssl.SslBundleRegistry;
import org.springframework.context.annotation.Bean;
import sandipchitale.multitssslbundle.MultiTSSslProperties;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for SSL.
 *
 * @author Scott Frederick
 * @since 3.1.0
 */
@AutoConfiguration
@EnableConfigurationProperties(MultiTSSslProperties.class)
public class MultiTSSslAutoConfiguration {

    private final MultiTSSslProperties multiTSSslProperties;
    private final ObjectMapper objectMapper;

    MultiTSSslAutoConfiguration(MultiTSSslProperties multiTSSslProperties, ObjectMapper objectMapper) {
        this.multiTSSslProperties = multiTSSslProperties;
        this.objectMapper = objectMapper;
    }

    public static class MultiTSSslPropertiesBundleRegistrar implements SslBundleRegistrar {
        private final ObjectMapper objectMapper;
        private final MultiTSSslProperties multiTSSslProperties;

        public MultiTSSslPropertiesBundleRegistrar(MultiTSSslProperties multiTSSslProperties, ObjectMapper objectMapper) {
            this.multiTSSslProperties = multiTSSslProperties;
            this.objectMapper = objectMapper;
        }

        @Override
        public void registerBundles(SslBundleRegistry registry) {
            try {
                System.out.println("multiTSSslProperties:\n" + objectMapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(multiTSSslProperties));
            } catch (JsonProcessingException jsonProcessingException) {
                throw new RuntimeException(jsonProcessingException);
            }
        }
    }

    @Bean
    MultiTSSslPropertiesBundleRegistrar multiTsSslPropertiesSslBundleRegistrar() {
        return new MultiTSSslPropertiesBundleRegistrar(this.multiTSSslProperties, this.objectMapper);
    }
}
