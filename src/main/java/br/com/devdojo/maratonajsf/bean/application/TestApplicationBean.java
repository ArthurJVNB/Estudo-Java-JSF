package br.com.devdojo.maratonajsf.bean.application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
// O @ApplicationScoped fica vivo durante o ciclo de vida inteiro do servidor. Em outras palavras, os objetos criados
// aqui são feitos apenas quando o servidor inicia, ou quando é reiniciado. Fica vivo independente de sessão ou cliente.
// Por conta dessa característica, qualquer escopo de qualquer lugar da aplicação poderá acessar os valores de um @ApplicationScoped.
// Cuidado: Mais uma vez tomar cuidado ao importar o pacote correto, que é o javax.enterprise.context. O antigo pacote,
//          javax.faces.bean, existe apenas para retrocompatibilidade.
// Cuidado: Mais uma vez, objetos criados ficam na memória do servidor. Logo, um objeto criado com o escopo sendo
//          @ApplicationScoped irá ficar vivo enquanto o servidor também estiver on.
public class TestApplicationBean implements Serializable {
    private List<String> categorias;

    @PostConstruct
    public void init() {
        System.out.println("Entrou no @PostConstruct do @ApplicationScoped");
        categorias = asList("RPG", "SCI-FI", "SIMULATION");
    }

    public void colocarFPS() {
        categorias = asList("RPG", "SCI-FI", "SIMULATION, FPS");
    }

    public void tirarFPS() {
        categorias = asList("RPG", "SCI-FI", "SIMULATION");
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }
}
