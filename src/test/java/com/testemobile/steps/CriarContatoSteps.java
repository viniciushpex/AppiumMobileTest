package com.testemobile.steps;

import com.testemobile.pages.ContatosPage;
import com.testemobile.support.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.pt.*;
import io.appium.java_client.android.AndroidDriver;

public class CriarContatoSteps {

    private ContatosPage contatos;
    private AndroidDriver driver;

    @Dado("que o aplicativo de contatos está aberto")
    public void abrirAppContatos() throws Exception {
        driver = DriverFactory.iniciarDriver();
        contatos = new ContatosPage(driver);
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

    @E("o nome do contato deve ser {string}")
    public void validarNome(String nome) throws InterruptedException {
        contatos.validarNome(nome);
    }

    @E("o sobrenome do contato deve ser {string}")
    public void validarSobrenome(String sobrenome) throws InterruptedException {
        contatos.validarSobrenome(sobrenome);
    }

    @E("o telefone do contato deve ser {string}")
    public void validarTelefone(String telefone) throws InterruptedException {
        contatos.validarTelefone(telefone);
    }

    @After
    public void finalizar() {
        DriverFactory.encerrarDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
