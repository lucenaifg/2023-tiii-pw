package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.dto.AutenticacaoDTO;
import br.edu.ifg.luziania.model.dto.RetornoAutenticacaoDTO;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Path -> avisa o servidor de aplicação que essa classe java pode receber requisições
// e defini o caminho base para essa classe.
@Path("")
public class LoginController {

    //Atributo que recupera o html na pasta resources
    private final Template login;

    //Construtor de inicialização do template
    public LoginController(Template login) {
        this.login = login;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("")
    public TemplateInstance login(){
        return login.instance();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/autenticar")
    public Response autenticar(AutenticacaoDTO autenticacaoDTO){
        RetornoAutenticacaoDTO retorno = new RetornoAutenticacaoDTO();
        if (autenticacaoDTO.getEmail().equals("daniel@ifg.edu.br") && autenticacaoDTO.getSenha().equals("123")) {
            retorno.setMensagem("Usuário autenticado!");
            return Response.ok(retorno, MediaType.APPLICATION_JSON).build();
        }
        else {
            retorno.setMensagem("Usuário não autenticado!");
            return Response.ok(retorno, MediaType.APPLICATION_JSON).build();
        }
    }
}
