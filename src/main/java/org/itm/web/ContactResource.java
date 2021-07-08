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

@Path("contact")
@Authenticated
public class ContactResource {
    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    Template contact;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance noauth() {
        return contact.data("username", securityIdentity.getPrincipal().getName());
    }
}
