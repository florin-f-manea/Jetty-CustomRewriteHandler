package ro.totalsoft.jetty.hostheaderrewriter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.rewrite.handler.HeaderRule;
import org.eclipse.jetty.server.Request;

public class HostHeaderRewriter extends HeaderRule{
    String host;
    int port=0;

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    
    @Override
    protected String apply(String target, String value, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Request jettyRequest=(Request) request;
        jettyRequest.getMetaData().getURI().setAuthority(host, port);
        return target;
    }
}