package cloud.anypoint.azure.appconfig.internal.connection;

import com.azure.data.appconfiguration.ConfigurationClient;
import com.azure.data.appconfiguration.ConfigurationClientBuilder;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;

public final class AzureAppConfigurationConnection {

  /**
   * This constructor currently requires ClientSecretCredential to be used to authenticate to Azure.
   * TODO: should this use TokenCredential to allow others?
   */
  ClientSecretCredential credential;
  public AzureAppConfigurationConnection(String clientId, String clientSecret, String tenantId, String endpoint) {
      credential = new ClientSecretCredentialBuilder()
              .clientId(clientId)
              .clientSecret(clientSecret)
              .tenantId(tenantId)
              .build();
    ConfigurationClient configurationClient = new ConfigurationClientBuilder()
            .credential(credential)
            .endpoint(endpoint)
            .buildClient();
  }


  public void invalidate() {
    // do something to invalidate this connection!
  }
}
