import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class find_Bitcoin {
    @Test
    public void find_Bitcoin() {
        Configuration.startMaximized = true;
        open("https://keys.lol/bitcoin/206964111000802114613190418704495848530984750016337335727414223401519891050");

        WebElement red = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 empty\"]"));
        WebElement green = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 filled\"]"));
        WebElement yellow = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 used\"]"));
        WebElement grey = $(By.xpath("//*[@class=\"wallet loading flex flex-col lg:flex-row font-mono text-sm pl-2\"]"));

        boolean greenExist;
        boolean yellowExist;
        int i = 0;
        do {
            $(By.xpath("//*[@class=\"wallet loading flex flex-col lg:flex-row font-mono text-sm pl-2\"]")).waitUntil(Condition.disappear, 15*1000);
            greenExist = $(green).exists();
            greenExist = $(green).exists();
            System.out.print(i + " ");
            System.out.print("Green exist: " + $(green).exists() + "| ");
            System.out.print("Red exist: " + $(red).exists() + "| ");
            System.out.print("Yellow exist: " + $(yellow).exists() + "| ");
            System.out.println(" " + greenExist + " status");
            if (greenExist == false) {
                $(By.xpath("//a[@title=\"Random page\"]")).click();
//            $(By.xpath("//a[@title=\"Last page\"]")).click();
            }
            i++;
        } while (greenExist == false);
        if (greenExist == true) {
            System.out.println("GOOOOOOOOOOOOD");
            Selenide.screenshot("link");
            System.out.println($(green).getText());
        }
    }
}
