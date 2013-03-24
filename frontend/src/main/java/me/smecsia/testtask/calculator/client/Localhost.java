
package me.smecsia.testtask.calculator.client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Generated(value = {
    "wadl|http://localhost:8080/application.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2013-03-24T22:18:05.582+04:00")
public class Localhost {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://localhost:8080/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Localhost.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is!=null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                    "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +"']/@uri", 
                    new org.xml.sax.InputSource(is)); 
                if (found!=null && found.length()>0) {
                    originalURI = java.net.URI.create(found);
                }
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static Localhost.Calc calc(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Localhost.Calc(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     * 
     */
    private static void customizeClientConfiguration(ClientConfig cc) {
    }

    /**
     * Template method to allow tooling to override Client factory
     * 
     */
    private static com.sun.jersey.api.client.Client createClientInstance(ClientConfig cc) {
        return com.sun.jersey.api.client.Client.create(cc);
    }

    /**
     * Create a new Client instance
     * 
     */
    public static com.sun.jersey.api.client.Client createClient() {
        ClientConfig cc = new DefaultClientConfig();
        customizeClientConfiguration(cc);
        return createClientInstance(cc);
    }

    public static Localhost.Calc calc() {
        return calc(createClient(), BASE_URI);
    }

    public static Localhost.Calc calc(com.sun.jersey.api.client.Client client) {
        return calc(client, BASE_URI);
    }

    public static class Calc {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Calc(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Calc(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/calc");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public Localhost.Calc.BySyntaxtree bySyntaxtree() {
            return new Localhost.Calc.BySyntaxtree(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public Localhost.Calc.Sample sample() {
            return new Localhost.Calc.Sample(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class BySyntaxtree {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private BySyntaxtree(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public BySyntaxtree(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/by/syntaxtree");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public Result postXmlAsResult(Expression input) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Result.class);
            }

            public<T >T postXml(Object input, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class, input);
                if (response.getStatus()>= 400) {
                    throw new Localhost.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postXml(Object input, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                resourceBuilder = resourceBuilder.type("application/xml");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class, input);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class Sample {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Sample(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Sample(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("/sample");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public Expression getAsExpression() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(Expression.class);
            }

            public<T >T getAsXml(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }


    /**
     * Workaround for JAX_RS_SPEC-312
     * 
     */
    private static class WebApplicationExceptionMessage
        extends WebApplicationException
    {


        private WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         * 
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status!= null) {
                return (response.getStatus()+(" "+ status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s +(": "+ message));
        }

    }

}
