package cloud.anypoint.azure.appconfig.internal;

import cloud.anypoint.azure.appconfig.internal.connection.AzureAppConfigurationConnectionProvider;
import cloud.anypoint.azure.appconfig.internal.operation.AzureAppConfigurationOperations;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;

@Operations(AzureAppConfigurationOperations.class)
@ConnectionProviders(AzureAppConfigurationConnectionProvider.class)
public class AzureAppConfigurationConfiguration {

  @Parameter
  private String endpoint;

  public String getEndpoint() { return endpoint; }

  @Parameter
  private String clientId;

  public String getClientId(){
    return clientId;
  }

  @Parameter
  private String clientSecret;

  public String getClientSecret() { return clientSecret; }

  @Parameter
  private String tenantId;

  public String getTenantId() { return tenantId; }
}
