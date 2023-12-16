package sandipchitale.multitssslbundle.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import sandipchitale.multitssslbundle.autoconfigure.multitsssl.MultiTSSslProperties;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for SSL.
 *
 * @author Sandip Chitale
 */
@AutoConfiguration
@EnableConfigurationProperties(MultiTSSslProperties.class)
@ConditionalOnClass({ MultiTSSslProperties.class })
public class MultiTSSslAutoConfiguration {

    private final MultiTSSslProperties multiTSSslProperties;
    private final ObjectMapper objectMapper;

    MultiTSSslAutoConfiguration(MultiTSSslProperties multiTSSslProperties, ObjectMapper objectMapper) {
        this.multiTSSslProperties = multiTSSslProperties;
        this.objectMapper = objectMapper;
    }

    @Bean
    MultiTSSslPropertiesBundleRegistrar multiTsSslPropertiesSslBundleRegistrar() {
        return new MultiTSSslPropertiesBundleRegistrar(this.multiTSSslProperties, this.objectMapper);
    }
}
