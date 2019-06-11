package Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tasks.Task_common_actions;



//$Id$

public class Calendar_Add_Update_Cases extends Calendar_Locaters {

	WebDriver driver;
	DesiredCapabilities capabilities;
	String RandomVal  = RandomStringUtils.randomAlphabetic(10);
	Task_common_actions tc = new Task_common_actions();
	Calendar_common_action cc=new Calendar_common_action();
	
	
	@BeforeClass
	public void webdriver() throws Exception{
		
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} 
			else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","/Users/vel-2789/Downloads/chromedriver");
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			signIn(driver,mailId,Password,Url);
			Thread.sleep(2000);
			cc.CreateProject(driver, RandomVal);
		}
		
		catch (WebDriverException e) {

			System.out.println(e);
		}
	}


	@Test(priority=1)
	public void AddTask_from_Proj_calendarView() throws Exception
	{
			
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String date1= dateFormat.format(date);
		Thread.sleep(8000);
		tc.ClickFunction(driver, CalTab);
		driver.findElement(By.id(date1)).click();
		Thread.sleep(2000);
		tc.ClickFunction(driver, Tasklink);
		tc.Send_task_Name(driver);
		cc.SelecttaskAssinee(driver);
		tc.ClickFunction(driver, SubmitBut);
		Thread.sleep(8000);
		Assert.assertTrue(driver.findElement(TaskIcon).isDisplayed());
		Thread.sleep(3000);
	
}
	
	@Test(priority=2)
	public void Add_Milestone_from_project_Calendar() throws Exception
	{
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		driver.findElement(CalTab).click();
		String tomorrowAsString = dateFormat.format(tomorrow);
		if(driver.findElements(By.id(tomorrowAsString)).size()==0){
			
			tc.ClickFunction(driver,Nxtmonth);
			Thread.sleep(3000);
		}
		driver.findElement(By.id(tomorrowAsString)).click();
		Thread.sleep(2000);
		tc.ClickFunction(driver,Milelink);
		Thread.sleep(2000);
		driver.findElement(Miletitle).sendKeys(RandomVal);
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileButt);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(MileIcon).isEnabled());
		Thread.sleep(3000);
	
	}
	@Test(priority=3)
	public void Add_Bug_from_project_Calendar() throws Exception
	{
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 3);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		driver.findElement(CalTab).click();
		String tomorrowAsString = dateFormat.format(tomorrow);
		if(driver.findElements(By.id(tomorrowAsString)).size()==0){
			
			tc.ClickFunction(driver,Nxtmonth);
			Thread.sleep(3000);
		}
		driver.findElement(By.id(tomorrowAsString)).click();
		Thread.sleep(2000);
		tc.ClickFunction(driver,Buglink);
		Thread.sleep(2000);
		driver.findElement(Bugtitle).sendKeys(RandomVal);
		Thread.sleep(3000);
		tc.ClickFunction(driver,Eventadd);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(Bugicon).isDisplayed());
		Thread.sleep(3000);
	
	}
	
	@Test(priority=4)
	public void Add_event_from_project_Calendar() throws Exception
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		tc.ClickFunction(driver,CalTab);
		String tomorrowAsString = dateFormat.format(tomorrow);
		if(driver.findElements(By.id(tomorrowAsString)).size()==0){
			
			tc.ClickFunction(driver,Nxtmonth);
			Thread.sleep(3000);
		}
		driver.findElement(By.id(tomorrowAsString)).click();
		Thread.sleep(2000);
		driver.findElement(EventTitle).sendKeys(RandomVal);
		Thread.sleep(2000);
		tc.ClickFunction(driver,SelectAlllUser);
		Thread.sleep(3000);
		driver.findElement(Location).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(CalendIcon).isDisplayed());
		Thread.sleep(3000);
	}
	@Test(priority=5)
	public void Edit_event_Time_from_project_Calendar() throws Exception
	{
		cc.EventEditClick(driver);
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(Time));
		dropdown.selectByIndex(2);
		cc.UpdateButton(driver);
		Thread.sleep(3000);
		tc.ClickFunction(driver,CalendIcon);
		Thread.sleep(3000);
		tc.ClickFunction(driver,Edit);
		Thread.sleep(2000);
		Select dropdown1 = new Select(driver.findElement(Time));
		String timeval=dropdown1.getFirstSelectedOption().getText();
		Thread.sleep(2000);
		cc.UpdateButton(driver);
		Thread.sleep(2000);
		Assert.assertEquals("03", timeval);
		Thread.sleep(3000);
	}
/*	@Test(priority=5)
	public void Edit_event_Date_from_project_Calendar() throws Exception
	{
		try
		{
			
			Calendar_common_action.EventEditClick(driver);
			Thread.sleep(2000);
			driver.findElement(scheduleDate).click();
			Thread.sleep(2000);
			driver.findElement(DateClick).click();
			Thread.sleep(2000);
			Calendar_common_action.UpdateButton(driver);
			Thread.sleep(3000);
			driver.findElement(CalendIcon).click();
			Thread.sleep(3000);
			driver.findElement(Edit).click();
			Thread.sleep(2000);
			String timeval=driver.findElement(Time).getText();
			Calendar_common_action.UpdateButton(driver);
			Thread.sleep(2000);
			Assert.assertEquals(02, timeval);
			Thread.sleep(3000);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	@Test(priority=6)
	public void Update_event_Titile_from_project_Calendar() throws Exception
	{
		cc.EventEditClick(driver);
		Thread.sleep(5000);
		driver.findElement(Updatemeettitle).sendKeys(RandomVal);
		Thread.sleep(2000);
		String Tile=driver.findElement(Updatemeettitle).getAttribute("value");
		Thread.sleep(2000);
		tc.ClickFunction(driver,UpdatevenBut);
		Thread.sleep(3000);
		Assert.assertTrue(Tile.contains(RandomVal));
		Thread.sleep(3000);
	}
	@Test(priority=7)
	public void Update_event_Location_from_project_Calendar() throws Exception
	{
		cc.EventEditClick(driver);
		Thread.sleep(5000);
		driver.findElement(Updatelocat).sendKeys(RandomVal);
		Thread.sleep(2000);
		tc.ClickFunction(driver,UpdatevenBut);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElements(EventBar).size()==1);
		Thread.sleep(3000);
	}
	//@Test(priority=8)
	public void ADD_event_Comment_from_project_Calendar() throws Exception
	{
		tc.ClickFunction(driver,CalendIcon);
		Thread.sleep(2000);
		tc.ClickFunction(driver,EventComment);
		Thread.sleep(2000);
		driver.findElement(CommentTextBox).sendKeys(RandomVal);
		Thread.sleep(2000);
		tc.ClickFunction(driver,AddCommentButton);
		String timeval=driver.findElement(CommentBox).getText();
		Thread.sleep(4000);
		tc.ClickFunction(driver,cancelButton);
		Thread.sleep(3000);
		Assert.assertEquals(RandomVal, timeval);
		Thread.sleep(3000);
	}
	@Test(priority=9)
	public void Update_Milestone_Flag_from_project_Calendar() throws Exception
	{
		cc.MilestoneEditClick(driver);
		Thread.sleep(3000);
		Select dropdown = new Select(driver.findElement(Mileflag));
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		tc.ClickFunction(driver,MileUpddateButton);
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileIcon);
		Thread.sleep(2000);
		tc.ClickFunction(driver,Edit);
		Thread.sleep(3000);
		Select dropdown1 = new Select(driver.findElement(Mileflag));
		String timeval =dropdown1.getFirstSelectedOption().getText();
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileUpddateButton);
		Thread.sleep(3000);
		Assert.assertEquals("External", timeval);
		Thread.sleep(3000);
	
	}
	
	@Test(priority=10)
	public void Update_Milestone_Owner_from_project_MyCalendar() throws Exception
	{
		cc.MilestoneEditClick(driver);
		Thread.sleep(3000);
		Select dropdown = new Select(driver.findElement(MileOwner));
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		tc.ClickFunction(driver,MileUpddateButton);
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileIcon);
		driver.findElement(MileIcon).click();
		Thread.sleep(2000);
		tc.ClickFunction(driver,Edit);
		Thread.sleep(3000);
		Select dropdown1 = new Select(driver.findElement(MileOwner));
		String timeval =dropdown1.getFirstSelectedOption().getText();
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileUpddateButton);
		Assert.assertTrue(!timeval.toString().equals("Me"));
		Thread.sleep(3000);
	
		}
	@Test(priority=11)
	public void Update_Milestone_Title_from_project_Calendar() throws Exception
	{
			
		cc.MilestoneEditClick(driver);
		Thread.sleep(3000);
		driver.findElement(MileUpdatetitle).sendKeys(RandomVal);
		Thread.sleep(2000);
		String timeval =driver.findElement(MileUpdatetitle).getText();
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileUpddateButton);
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileIcon);
		Thread.sleep(2000);
		tc.ClickFunction(driver,Edit);
		Thread.sleep(3000);
		tc.ClickFunction(driver,MileUpddateButton);
		Assert.assertTrue(timeval.contains(RandomVal));
		Thread.sleep(3000);
		
	}
	
	/*@Test(priority=12)
	public void Update_Milestone_DueDate_from_project_Calendar() throws Exception
	{
		try
		{
			
			Calendar_common_action.MilestoneEditClick(driver);
			Thread.sleep(3000);
			driver.findElement(MileEnddate).click();
			Thread.sleep(2000);
			driver.findElement(NxtMonth).click();
			Thread.sleep(2000);
			driver.findElement(DateClick).click();
			Thread.sleep(2000);
			driver.findElement(MileUpddateButton).click();
			Thread.sleep(3000);
			driver.findElement(MileIcon).click();
			Thread.sleep(2000);
			driver.findElement(Edit).click();
			Thread.sleep(3000);
			String timeval =driver.findElement(Mileflag).getText();
			Thread.sleep(3000);
			driver.findElement(MileUpddateButton).click();
			Thread.sleep(3000);
			Assert.assertEquals("External", timeval);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
	//@Test(priority=13)
	public void Add_Milestone_Comment_from_project_Calendar() throws Exception
	{
		tc.ClickFunction(driver,CalTab);
		Thread.sleep(4000);
		tc.ClickFunction(driver,MileIcon);
		driver.findElement(MileIcon).click();
		Thread.sleep(3000);
		tc.ClickFunction(driver,EventComment);
		Thread.sleep(2000);
		cc.EventsCommentbuttondisplayed(driver);
		driver.findElement(CommentTextBox).sendKeys(RandomVal);
		Thread.sleep(2000);
		tc.ClickFunction(driver,AddCommentButton);
		String timeval=driver.findElement(CommentBox).getText();
		Thread.sleep(4000);
		tc.ClickFunction(driver,cancelButton);
		Thread.sleep(3000);
		Assert.assertEquals(RandomVal, timeval);
		Thread.sleep(3000);
		
	}
	@Test(priority=14)
	public void Delete_Task_from_project_Calendar() throws Exception
	{
		
			tc.ClickFunction(driver,CalTab);
			cc.Delete_task(driver);
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElements(taskBar).size() == 0);
			Thread.sleep(3000);
		
	}
	@Test(priority=15)
	public void Delete_Event_from_project_Calendar() throws Exception
	{
		
		cc.Delete_event(driver);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElements(EventBar).size()==0); 
		Thread.sleep(3000);
		
	}
	@Test(priority=16)
	public void Delete_Milestone_from_project_Calendar() throws Exception
	{
		
		WebElement TaskDel = driver.findElement(MileBar);
		Actions action = new Actions(driver);
		action.moveToElement(TaskDel).perform();
		Thread.sleep(2000);
		tc.ClickFunction(driver,Trashicon);
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		tc.ClickFunction(driver,Okbutton);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElements(MileBar).size() ==0);
		Thread.sleep(3000);
		
	}

	@Test(priority=17)
	public void Delete_Bug_from_project_Calendar() throws Exception
	{
		
		WebElement TaskDel = driver.findElement(BugBar);
		Actions action = new Actions(driver);
		action.moveToElement(TaskDel).perform();
		Thread.sleep(2000);
		tc.ClickFunction(driver,Trashicon);
		tc.ClickFunction(driver,Okbutton);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElements(BugBar).size() ==0);
		Thread.sleep(3000);
		
	}
	@Test(priority=18)
	public void AddTask_With_Duration_from_Proj_calendarView() throws Exception
	{
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String date1= dateFormat.format(date);
		Thread.sleep(4000);
		tc.ClickFunction(driver,CalTab);
		driver.findElement(By.id(date1)).click();
		Thread.sleep(2000);
		tc.ClickFunction(driver,Tasklink);
		tc.Send_task_Name(driver);
		cc.SelecttaskAssinee(driver);
		Thread.sleep(2000);
		tc.ClickFunction(driver,Dure);
		Thread.sleep(2000);
		driver.findElement(DurVal).sendKeys("2");
		Thread.sleep(2000);
		tc.ClickFunction(driver,SubmitBut);
		Thread.sleep(8000);
		boolean Ticon=driver.findElement(TaskIcon).isDisplayed();
		Thread.sleep(3000);
		cc.Delete_task(driver);
		Thread.sleep(5000);
		Assert.assertTrue(Ticon);
		Thread.sleep(3000);
		
	}
		
	@AfterClass
	public void tearDown() throws Exception
	{
		cc.TrashProject(driver);
		Thread.sleep(3000);
		signOut(driver);
		driver.quit();
		}
	}

