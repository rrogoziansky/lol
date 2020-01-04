import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;

public class find_Ethereum {
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
//            $(By.xpath("//a[@title=\"Last page\"]")).click();
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

