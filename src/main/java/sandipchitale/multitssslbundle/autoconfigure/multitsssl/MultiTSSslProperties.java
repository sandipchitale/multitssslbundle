package sandipchitale.multitssslbundle.autoconfigure.multitsssl;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Properties for centralized SSL trust material configuration.
 *
 * @author Sandip Chitale
 */
@ConfigurationProperties(prefix = "spring.multitsssl")
public class MultiTSSslProperties {

    /**
     * SSL bundles.
     */
    private final MultiTSSslProperties.MultiTSBundles multiTsBundle = new MultiTSSslProperties.MultiTSBundles();

    public MultiTSSslProperties.MultiTSBundles getMultiTsBundle() {
        return this.multiTsBundle;
    }

    /**
     * Properties to define SSL Bundles.
     */
    public static class MultiTSBundles {

        /**
         * Java keystore SSL trust material.bundls
         */
        private final Map<String, MultiTSJksSslBundleProperties> multiTsJks = new LinkedHashMap<>();

        public Map<String, MultiTSJksSslBundleProperties> getMultiTsJks() {
            return this.multiTsJks;
        }

    }
}
