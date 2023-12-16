package sandipchitale.multitssslbundle;

import org.springframework.boot.autoconfigure.ssl.JksSslBundleProperties;

import java.util.LinkedList;
import java.util.List;

public class MultiTSJksSslBundleProperties extends JksSslBundleProperties {
    private final List<Store> trustStores = new LinkedList<>();

    public List<Store> getTrustStores() {
        return this.trustStores;
    }

    @Override
    public Store getTruststore() {
        Store truststore = super.getTruststore();
        if (truststore.getLocation() == null) {
            if (!getTrustStores().isEmpty()) {
                truststore = getTrustStores().get(0);
            }
        }
        return truststore;
    }
}
