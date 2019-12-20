package br.com.devdojo.maratonajsf.bean.request;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
// @Named permite que essa classe possa ser acessada no view pelos Expression Languages - escrevendo #{testRequestBean.algumMetodo()}
@RequestScoped
// Observar que @RequestScoped é importado do pagote javax.enterprise.context. Isso é importante, pois existe uma versão
// mais antiga que é do pacote javax.faces.context, mantida apenas por retrocompatibilidade.
// O RequestScoped diz para o sistema que o objeto criado com essa classe apenas continuará existindo durante um pedido.
// Após o pedido ao servidor, o objeto é mandado pro Garbage Collector e numa próxima utilização, ou requisição, será
// criado um novo objeto. Se a intenção é apenas exibir dados para o usuário, sem precisar usar esses dados novamente pra
// outras chamadas, o @RequestScoped já é suficiente para esse propósito.
public class TestRequestBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Entrou no @PostConstruct do @RequestScoped");
        personagens = asList("Mordred", "Aedrich", "Aurocastro", "Nomma", "Hadvar", "Heimdallr", "Bedrich", "Godfrey");
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
