package com.testemobile.steps;

import com.testemobile.pages.ContatosPage;
import com.testemobile.support.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.pt.*;

public class CriarContatoSteps {

    private ContatosPage contatos;

    @Dado("que o aplicativo de contatos está aberto")
    public void abrirAppContatos() throws Exception {
        contatos = new ContatosPage(DriverFactory.iniciarDriver());
        // Aguarda o carregamento
        Thread.sleep(2000);
    }

    @Quando("eu toco para criar um novo contato")
    public void criarNovoContato() throws InterruptedException {
        contatos.tocarEmCriarNovoContato();
    }

    @E("preencho o nome {string}")
    public void preencherNome(String nome) throws InterruptedException {
        contatos.preencherNome(nome);
    }

    @E("preencho o sobrenome {string}")
    public void preencherSobrenome(String sobrenome) throws InterruptedException {
        contatos.preencherSobrenome(sobrenome);
    }

    @E("preencho o telefone {string}")
    public void preencherTelefone(String telefone) throws InterruptedException {
        contatos.preencherTelefone(telefone);
    }

    @E("salvo o contato")
    public void salvarContato() throws InterruptedException {
        contatos.salvarContato();
    }

    @Então("o contato deve ser salvo com sucesso")
    public void verificarSucesso() {
        contatos.validarContatoSalvo();
    }

    @After
    public void finalizar() {
        DriverFactory.encerrarDriver();
        driver.quit();
    }
}
