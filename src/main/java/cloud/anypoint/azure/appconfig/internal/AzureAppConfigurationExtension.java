package cloud.anypoint.azure.appconfig.internal;

import cloud.anypoint.azure.appconfig.api.ConnectorError;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;

@Xml(prefix = "appconfig")
@Extension(name = "Azure App Configuration", vendor = "Anypoint Cloud")
@ErrorTypes(ConnectorError.class)
@Configurations(AzureAppConfigurationConfiguration.class)
public class AzureAppConfigurationExtension {

}

/**
 *    Copyright 2023 Ryan Hoegg
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */