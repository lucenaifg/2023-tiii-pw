package br.edu.ifg.luziania;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class Login {

    //Atributo que recupera o html na pasta resources
    private final Template login;


    //Construtor de inicialização do template
    public Login(Template login) {
        this.login = login;
    }

    @GET
    @Path("/ok")
    public String ok(){
        return "ok";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/login")
    public TemplateInstance login(){
        return login.instance();
    }
}
