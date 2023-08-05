package cloud.anypoint.azure.appconfig.internal.connection;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AzureAppConfigurationConnectionProvider implements CachedConnectionProvider<AzureAppConfigurationConnection> {

    private final Logger LOGGER = LoggerFactory.getLogger(AzureAppConfigurationConnectionProvider.class);
    @Parameter
    private String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

    @Parameter
    private String clientId;

    public String getClientId() {
        return clientId;
    }

    @Parameter
    private String clientSecret;

    public String getClientSecret() {
        return clientSecret;
    }

    @Parameter
    private String tenantId;

    public String getTenantId() {
        return tenantId;
    }

    @Override
    public AzureAppConfigurationConnection connect() throws ConnectionException {
        TokenCredential credential = new ClientSecretCredentialBuilder()
                .tenantId(tenantId)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
        return new AzureAppConfigurationConnection(credential, endpoint);
    }

    @Override
    public void disconnect(AzureAppConfigurationConnection connection) {
        try {
            connection.invalidate();
        } catch (Exception e) {
            LOGGER.error("Error while disconnecting: " + e.getMessage(), e);
        }
    }

    @Override
    public ConnectionValidationResult validate(AzureAppConfigurationConnection connection) {
        return ConnectionValidationResult.success();
    }
}
