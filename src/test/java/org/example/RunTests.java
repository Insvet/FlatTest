package org.example;

import org.example.steps.TestImport;
import org.example.steps.TestProfNet;
import org.example.steps.TestProfile;
import org.junit.Test;


public class RunTests {
    static TestImport step1 = new TestImport();
    static TestProfile step2 = new TestProfile();
    static TestProfNet step3 = new TestProfNet();

//    @Test
    public void compilation() throws InterruptedException {
        step1.testImp(); //Импорт профиля сертификатов
        step2.profile(); //Создание профиля
        step3.testNet(); //Подключения к сайту
    }
}


