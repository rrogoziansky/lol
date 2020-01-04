import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class find {
//    private boolean greenexist;
    private int timeout;

    //    @BeforeClasspublicstaticvoidopenInbox(){timeout=10000;baseUrl="http://gmail.com";open("/");$(byText("Loading")).should(disappear);login()
    @Test
    public void findValid() {
        Configuration.startMaximized = true;
        //System.setProperty("webdriver.chrome.driver", "c:\\Git\\autotests\\drivers\\chromedriver_win32_77.0.3865.40_v2\\chromedriver.exe");
        open("https://keys.lol/ethereum/595152888053985722161695317475469997481780498821257707627723014319776359314");

        WebElement green = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 py-1 lg:py-0 filled\"]"));
        WebElement red = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 py-1 lg:py-0 empty\"]"));
        WebElement grey = $(By.xpath("//*[@class=\"wallet loading flex flex-col lg:flex-row font-mono text-sm pl-2 py-1 lg:py-0\"]"));

        boolean greenexist;
        int i = 0;

        do {
            $(By.xpath("//*[@class=\"wallet loading flex flex-col lg:flex-row font-mono text-sm pl-2 py-1 lg:py-0\"]")).waitUntil(Condition.disappear, 15*1000);

            greenexist = $(green).exists();
            System.out.print(i + " ");
            System.out.print("Green exist: " + $(green).exists() + "| ");
            System.out.print("Red exist: " + $(red).exists() + "| ");
            System.out.println(" " + greenexist + " status");
            if (greenexist == false) {
              $(By.xpath("//a[@title=\"Random page\"]")).click();
//                $(By.xpath("//a[@title=\"Last page\"]")).click();
            }
            i++;
        } while (greenexist == false);
        if (greenexist == true) {
            System.out.println("GOOOOOOOOOOOOD");
            Selenide.screenshot("link");
            System.out.println($(green).getText());
        }
    }
}


//        while (r == false && i < iteration);
//        if (r == false) System.out.println("Test fell");
//        if (r == true) System.out.println("Scan completed");
//        return this;

//
//            try {Thread.sleep(1 * 2000);}
//                    catch (InterruptedException e) {e.printStackTrace();}



 /*       boolean greenExist = true;
        int i = 0;

        System.out.println($(green).exists());
        System.out.println($(red).exists());
        boolean greenexist = $(green).exists();


        int tt =  $$(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 py-1 lg:py-0 empty\"]")).size();
        int redExpected =  120;
        System.out.println(Objects.equals(tt, redExpected));
        boolean itaration =  Objects.equals(tt, redExpected);
        do {

            if (itaration != true) {
                int n = 0;
                do {
                    try {Thread.sleep(1 * 500);}
                    catch (InterruptedException e) {e.printStackTrace();}
                    System.out.println("is: " + n);
                    n++;

                } while (itaration == false);
            }
            System.out.println(tt + " wsfsdfsdfd");

            $(By.xpath("//a[@title=\"Random page\"]")).click();
            i++;
            if (greenexist == true) {
                Selenide.screenshot("link");
            }
        }
            while (greenexist == false);
            System.out.println("fff");
            */
//            i++;
//                    try {Thread.sleep(5 * 1000);}
//                    catch (InterruptedException e) {e.printStackTrace();}
//                    int scantime = i*5;
//                    System.out.println(i + " Status is: " + k + ", Scan time is: " + scantime + " sec" );
//                    if (o == true) {
//                    System.out.println("Scan status is: " + ouchStatus + "Check the settings");
//                    Selenide.close();
//                    }
//                    }


