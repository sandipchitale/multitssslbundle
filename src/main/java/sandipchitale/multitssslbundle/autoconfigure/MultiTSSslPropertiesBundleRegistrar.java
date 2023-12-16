package sandipchitale.multitssslbundle.autoconfigure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.ssl.SslBundleRegistrar;
import org.springframework.boot.ssl.SslBundleRegistry;
import sandipchitale.multitssslbundle.autoconfigure.multitsssl.MultiTSSslProperties;

public class MultiTSSslPropertiesBundleRegistrar implements SslBundleRegistrar {
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
