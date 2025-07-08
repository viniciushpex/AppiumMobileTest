package com.testemobile.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ContatosPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public ContatosPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ELEMENTOS
    private final By botaoNovoContato = MobileBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc='Criar contato']");
    private final By campoNome = MobileBy.xpath("//android.widget.EditText[contains(@text,'Nome')]");
    private final By campoSobrenome = MobileBy.xpath("//android.widget.EditText[contains(@text,'Sobrenome')]");
    private final By campoTelefone = MobileBy.xpath("(//android.widget.EditText)[4]");
    private final By botaoSalvar = MobileBy.xpath("//android.widget.TextView[@text='Salvar']");
    private final By contatoSalvo = MobileBy.xpath("//android.widget.TextView[@content-desc='Ligar']");

    // AÇÕES

    public void tocarEmCriarNovoContato() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoNovoContato)).click();
    }

    public void preencherNome(String nome) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoNome)).sendKeys(nome);
    }

    public void preencherSobrenome(String sobrenome) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSobrenome)).sendKeys(sobrenome);
    }

    public void preencherTelefone(String telefone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoTelefone)).sendKeys(telefone);
    }

    public void salvarContato() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoSalvar)).click();
    }

    public boolean validarContatoSalvo() {
        try {
            WebElement contato = wait.until(ExpectedConditions.visibilityOfElementLocated(contatoSalvo));
            return contato.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
