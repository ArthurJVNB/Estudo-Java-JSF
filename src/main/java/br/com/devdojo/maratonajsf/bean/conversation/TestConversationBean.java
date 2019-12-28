package br.com.devdojo.maratonajsf.bean.conversation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@ConversationScoped
public class TestConversationBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    @Inject
    private Conversation conversation;

    @Inject
    public void init() {
        System.out.println("Entrou no @PostConstruct do @ConversationScoped");
        personagens = asList("Mordred", "Aedrich", "Aurocastro", "Nomma", "Hadvar", "Heimdallr", "Bedrich", "Godfrey");
        if (conversation.isTransient()) {
            conversation.begin();
            System.out.println("Iniciando @ConversationScoped, ID=" + conversation.getId());
        }
    }

    public String endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }

        return "conversation?faces-redirect=true";
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

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
