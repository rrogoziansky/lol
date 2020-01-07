import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class seo {
    @Test
    public void findValid() {

        Configuration.startMaximized = true;
        open("https://seo-fast.ru/work_surfing");
        WebElement green = $(By.xpath("//*[@class=\"wallet flex flex-col lg:flex-row font-mono text-sm pl-2 py-1 lg:py-0 filled\"]"));


        $(By.xpath("//a[@title=\"Random page\"]")).click();

    }
}
