package cloud.anypoint.azure.appconfig.internal.connection;


/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class AzureAppConfigurationConnection {

  private final String id;

  public AzureAppConfigurationConnection(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void invalidate() {
    // do something to invalidate this connection!
  }
}
