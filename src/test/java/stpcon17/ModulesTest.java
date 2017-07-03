package stpcon17;

import browser.BrowserGetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.seOO.ntd17.ContentPage;
import pageobjects.stpcon17.ModulesPage;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class ModulesTest {

    private final Image readingModuleImage = new Image("https://c1.staticflickr.com/8/7494/27510788280_a9f43c3845_s.jpg", "125", "125");
    private final Image travelModuleImage = new Image("https://farm2.staticflickr.com/1642/25881055090_e29679a37d_q.jpg", "125", "125");
    private final Image photoModuleImage = new Image("https://farm1.staticflickr.com/612/32840145345_4bdf828d8f_q.jpg", "125", "125");

    private final Link readingModuleLink = new Link("http://iamalittletester.wordpress.com/", "Read about testing", "_blank");
    private final Link travelModuleLink = new Link("http://travelwithcori.wordpress.com/", "Read a travel blog", "_blank");
    private final Link photoModuleLink = new Link("https://www.flickr.com/photos/capreoara", "Look at photos", "_blank");

    private final Module readingModule = new Module(readingModuleImage, "Go ahead. Read something!", readingModuleLink);
    private final Module travelModule = new Module(travelModuleImage, "Go out, do some sightseeing!", travelModuleLink);
    private final Module photoModule = new Module(photoModuleImage, "Chill. Look at some photos!", photoModuleLink);

    //webDriver instance
    private WebDriver webDriver;
    //class used for initializing browser
    private BrowserGetter browserGetter = new BrowserGetter();
    //page object class
    private ModulesPage page;

    @BeforeClass
    public void beforeClass() {
        //initialize the Chrome browser here
        webDriver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(webDriver, ModulesPage.class);
        webDriver.get(new File("src/test/resources/htmls/stpcon17/fullPage.html").getAbsolutePath());
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

    @Test
    public void images() throws InterruptedException {
        assertEquals(new Image(page.readingModuleImageElement), readingModuleImage);
        assertEquals(new Image(page.travelModuleImageElement), travelModuleImage);
        assertEquals(new Image(page.photoModuleImageElement), photoModuleImage);
    }

    @Test
    public void links() {
        assertEquals(new Link(page.readingModuleLinkElement), readingModuleLink);
        assertEquals(new Link(page.travelModuleLinkElement), travelModuleLink);
        assertEquals(new Link(page.photoModuleLinkElement), photoModuleLink);
    }

    @Test
    public void modules() {
        assertEquals(new Module(page.readingModuleElement), readingModule);
        assertEquals(new Module(page.travelModuleElement), travelModule);
        assertEquals(new Module(page.photoModuleElement), photoModule);
    }
}
