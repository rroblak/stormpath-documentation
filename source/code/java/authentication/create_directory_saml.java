import com.stormpath.sdk.provider;
import com.stormpath.sdk.directory;
import com.stormpath.sdk.tenant;

Directory directory = client.instantiate(Directory.class);
directory.setName("My SAML Directory");
directory.setDescription("A SAML directory");

CreateDirectoryRequest request = Directories.newCreateRequestFor(directory).
            forProvider(Providers.SAML.builder()
                    .setSsoLoginUrl("https://example.com/saml2/sso/login")
                    .setSsoLogoutUrl("https://example.com/saml2/sso/logout")
                    .setRequestSignatureAlgorithm("RSA-SHA256")
                    .setEncodedX509SigningCert("-----BEGIN CERTIFICATE-----\n...Certificate goes here...\n-----END CERTIFICATE-----")
                    .build()
            ).build();

Tenant tenant = client.getCurrentTenant();
directory = tenant.createDirectory(request);
