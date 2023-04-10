package br.edu.ifg.luziania;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Path -> avisa o servidor de aplicação que essa classe java pode receber requisições
// e defini o caminho base para essa classe.
@Path("")
public class Login {

    //Atributo que recupera o html na pasta resources
    private final Template login;

    //Construtor de inicialização do template
    public Login(Template login) {
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
    public Response autenticar(Autenticacao autenticacao){
        RetornoAutenticacao retorno = new RetornoAutenticacao();
        if (autenticacao.getEmail().equals("daniel@ifg.edu.br") && autenticacao.getSenha().equals("123")) {
            retorno.setMessagem("Usuário autenticado!");
            return Response.ok(retorno, MediaType.APPLICATION_JSON).build();
        }
        else {
            retorno.setMessagem("Usuário não autenticado!");
            return Response.ok(retorno, MediaType.APPLICATION_JSON).build();
        }
    }
}
