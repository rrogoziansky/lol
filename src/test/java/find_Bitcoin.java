import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;


public class find_Bitcoin {
    @Test
    public void find_Bitcoin() {
        Configuration.startMaximized = true;
        open("https://keys.lol/bitcoin/5790");

       // https://keys.lol/bitcoin/206964111000802114613190418704495848530984750016337335727414223401519891050
        //https://keys.lol/bitcoin/2

        WebElement red = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 empty\"]"));
        WebElement green = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 filled\"]"));
        WebElement yellow = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 used\"]"));
        WebElement grey = $(By.xpath("//*[@class=\"wallet loading flex flex-col lg:flex-row font-mono text-sm pl-2\"]"));

        boolean greenExist;
        boolean yellowExist;
        int i = 0;
        Point sdf;
       // String currentURL =  $(sdf).getLocation();
        do {
            $(By.xpath("//*[@class=\"wallet loading flex flex-col lg:flex-row font-mono text-sm pl-2\"]")).waitUntil(Condition.disappear, 15*1000);
            yellowExist = $(yellow).exists();
            greenExist = $(green).exists();
            System.out.print(i + " ");
            System.out.print("Red exist: " + $(red).exists() + "| ");
            System.out.print("Yellow exist: " + $(yellow).exists() + "| ");
            System.out.println("Green exist: " + $(green).exists() + "| ");
//            System.out.println(" " + greenExist + " status");
            if (yellowExist == true) {
                System.out.println($(yellow).getText());
                System.out.println("URL is: " + url());
            }
            if (greenExist == false) {
//                $(By.xpath("//a[@title=\"Random page\"]")).click();
//            $(By.xpath("//a[@title=\"Last page\"]")).click();
            $(By.xpath("//a[@title=\"Next page\"]")).click();
            }

            i++;
        } while (greenExist == false);
        if (greenExist == true) {
            System.out.println("GOOOOOOOOOOOOD");
            Selenide.screenshot("link");
            System.out.println();
            System.out.println($(green).getText());
            System.out.println("URL is: " + url());
        }
    }

}
