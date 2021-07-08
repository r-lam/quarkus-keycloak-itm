package org.itm.web;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;

@Path("customers")
@Authenticated
public class CustomerPageResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    Template customers;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance noauth() {
        return customers.data("username", securityIdentity.getPrincipal().getName());
    }
}
