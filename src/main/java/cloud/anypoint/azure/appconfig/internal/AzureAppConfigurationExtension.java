package cloud.anypoint.azure.appconfig.internal;

import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Xml(prefix = "appconfig")
@Extension(name = "Azure App Configuration", vendor = "Anypoint Cloud")
@Configurations(AzureAppConfigurationConfiguration.class)
public class AzureAppConfigurationExtension {

}
