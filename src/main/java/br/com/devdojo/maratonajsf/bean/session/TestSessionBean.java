package br.com.devdojo.maratonajsf.bean.session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@SessionScoped
// O @SessionScoped indica que o objeto criado dessa classe vai durar enquanto a sessão com o servidor estiver ativa.
// E quando a sessão é finalizada? Quando fechamos o brownser ou quando é chamado algum método em algum momento para
// invalidar a sessão, como o método "logout()" criado abaixo, ou um timeout da sessão, configurado lá no web.xml (confi-
// guração em minutos). Fechar a aba, ou abrir outras, continua viva a mesma sessão, ou seja, o(s) objeto(s) criado(s)
// com esse escopo continuará(ão) vivo(s) e utilizável(is).
// Isso é interessante para quando você quer inicializar atributos que serão usados por várias partes do seu sistema,
// seja em outras beans, seja em outras views. Um exemplo bem comum é o login.
// Cuidado: Todos os objetos de beans que são iniciados ficam na memória do servidor, logo, se for utilizado demasiadamente
//          e desnecessariamente o @SessionScoped, a memória do servidor ficará sobrecarregada rapidamente e provavelmente
//          sem necessidade. Só se deve usar o escopo de sessão apenas quando é necessário de fato, e não apenas como
//          atalho para facilitar as implementações do sistema.
// Obs: Mais uma vez, deve-se usar o @SessionScoped do pacote javax.enterprise.context. A versão que está no pacote
//      javax.faces.context é antiga e só existe por fins de retrocompatibilidade.
public class TestSessionBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Entrou no @PostConstruct do @SessionScoped");
        personagens = asList("Mordred", "Aedrich", "Aurocastro", "Nomma", "Hadvar", "Heimdallr", "Bedrich", "Godfrey");
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true";
    }

    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(8);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
