package br.com.devdojo.maratonajsf.bean.estudante;

import br.com.devdojo.maratonajsf.model.Estudante;

import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

import static java.util.Arrays.asList;

@Named
public class EstudanteRegistrarBean implements Serializable {
    private Estudante estudante = new Estudante();
    private String nomesArray[] = {"DevDojo", "eh", "foda"};
    private List<String> nomesList = asList("Arthur", "Jorge", "Vila", "Nova", "Bezerra");
    private Set<String> nomesSet = new HashSet<>(asList("Primeiro", "Segundo", "Terceiro", "Quarto", "Quinto"));
    private Map<String, String> nomesMap = new HashMap<>();

    {
        nomesMap.put("Primeiro", "Esse carinha eh o primeiro que coloquei");
        nomesMap.put("Segundo", "Esse carinha eh o segundo que coloquei");
        nomesMap.put("Terceiro", "Esse carinha eh o terceiro que coloquei");
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }

    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public String[] getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(String[] nomesArray) {
        this.nomesArray = nomesArray;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
