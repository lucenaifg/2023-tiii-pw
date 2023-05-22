package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.bo.UsuarioBO;
import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RetornoAutenticacaoDTO;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Path -> avisa o servidor de aplicação que essa classe java pode receber requisições
// e defini o caminho base para essa classe.
@Path("")
public class LoginController {

    @Inject
    UsuarioBO usuarioBO;

    //Atributo que recupera o html na pasta resources
    private final Template login;

    //Construtor de inicialização do template
    public LoginController(Template login) {
        this.login = login;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("")
    public TemplateInstance loginHTML(){
        return login.instance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/autenticar")
    public Response autenticar(AutenticacaoDTO autenticacaoDTO){
        return Response.ok(usuarioBO.autenticar(autenticacaoDTO.getEmail(), autenticacaoDTO.getSenha()), MediaType.APPLICATION_JSON).build();
    }
}
