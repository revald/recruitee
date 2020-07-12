# recruitee
Setting up Selenium Java environment
Как развернуть окружение для работы связки Java+Selenium.

С картинками откройте Word document

Что нужно установить:
Java(JDK)
Eclipse
Selenium Client and WebDriver Language bindings
Configuring Selenium Webdriver with Eclipse

Шаг 1
Надо иметь JDK (java development kit) установленным
If no java (JDK) is present on your system then you need to install it.

https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

После установки проверить:  в CMD  java – version
 
Если не работает проверить System Properties – Environment Variables
 


 

Шаг 2
Eclipse for Java   (select according to your system)

https://www.eclipse.org/downloads/packages/

Выбрать   Eclipse IDE for Java Developers
 
Шаг 3

Selenium Client and WebDriver Language Bindings

Загрузить из этой ссылки official Selenium website. 



 

Разпокавать zip файл.

Шаг 4
Сонфигурация Selenium WebDriver и Eclipse

Открыть Eclipse. (eclipse.exe)
Задать локацию ‘’Workspace”

 

Создать ‘’Java Project”. File – New – Java Project

 

Создать ‘Package” - правой мышкой на созданный проект и выбрать ‘New --Package”

 

Создать ‘Class” - правой мышкой на созданный ‘Package” и выбрать “New -- Class”

 

Пришло время для Selenium Jar файлов. Правой мышкой на “Package” и выбрать ‘Build Path – Configure Build Path ..’


 

В открывшемся окне выбрать tab ‘Libraries’ и кликнуть ‘Class path’

 

Кликнуть кнопку ‘Add External JARs..’ и выбрать все JAR файлы которые были распакованы из ‘Selenium ….zip’ Click “Apply and Close”

Затем надо проверить что установка программ и конфигурация проведены правильно.
В класс который создан добавить этот код. То что выделено красным цветом оставить как у вас – это имя созданного ‘Package’ и класса.

package recruitee;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OneRecruitee {

public static void main(String[] args) {
// TODO Auto-generated method stub


//Initiating your chromedriver
WebDriver driver = new FirefoxDriver();

//Applied wait time
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//maximize window
driver.manage().window().maximize();

//open browser with desried URL
driver.get("https://www.google.com");

//closing the browser
driver.close();


	}

}
Если FireFox поднялся и открыл Google значит работает.

Следующее установим TestNG Eclipse plug in 

Help – Install new software
 

В “Work with box” заносим
	“"http://dl.bintray.com/testng-team/testng-eclipse-release/" “
Add button

 

Печатаем "TestNG" в Name поле

 

Выбираем "TestNG" checkbox
 

В ‘Install Details” кликаем Next

Выбираем "I accept the terms of the license agreement" и “Finish”

 

Если “Security warning” кликаем “Install Anyway”

Когда закончит установку – “Restart” кнопку


Если появляется ошибка при запуске Suite – “TestNG by default disables loading DTD from unsecure Urls. … “

Тогда надо добавить -Dtestng.dtd.http=true в VM option. Для этого правой кнопкой мышки на testing.xml и выбрать Run – Run Configurations. Выбрать ‘Arguments’ и в поле VM arguments вставить “-Dtestng.dtd.http=true” и кликнуть “Apply”
 




