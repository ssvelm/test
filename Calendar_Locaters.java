//$Id$
package Calendar;
import tasks.Projects_actions;


import org.openqa.selenium.By;



public class Calendar_Locaters extends Projects_actions {

		//Add Task From Calendar
		public By Home=By.id("topProjMenu_myhome");
		public By Viewmore=By.id("dashaction_9");
		public By Projtab=By.id("topProjMenu_allproj");
		public By CalTab=By.className("zoho-home-projectcalendar");
		public By Tasklink=By.cssSelector("[switchtype*='task']");
		public By TaskText=By.id("addTodoTaskForm_title");
		public By SubmitBut=By.name("addtoptasksubmit");
		public By ClickSelUser=By.className("select2-search-field");
		public By ChooseUser=By.className("select2-result-label");
		public By TaskIcon=By.className("zoho-tasks");
		public By Dur=By.className("maillink");
		public By Dure=By.id("edatelink");
		public By DurVal=By.name("duration");
		public By DeleteTask=By.cssSelector("[title*='Delete task']");
		public By taskBar=By.cssSelector("[type*='task']");
		public By Timesheetdiv=By.id("myworktimesheet");
		
		//Create Project
		public By ProjCreatBut=By.id("newpdivaddproj");
		public By ProjTilText=By.id("newproject");
		public By AddProjButton=By.name("addprojsubmit");
		public By Dashboard=By.className("zoho-home-dashboard");
		public By otheractionicomm=By.className("tourdashboard-1");
		public By Trashicon=By.className("zoho-trash");
		public By Okbutton=By.id("button1");
		
		
		
		//Add Meeting
		public By Eventlink=By.cssSelector("[switchtype*='meeting']");
		public By EventTitle=By.id("addMeeting_title");
		public By SelectAlllUser=By.id("selectAll");
		public By EventBut=By.className("buttonNew");
		public By Eventadd=By.name("reminder");
		public By Location=By.id("newmeeting");
		public By Updatemeettitle=By.name("meettitle");
		public By CalendIcon=By.className("zoho-ev-meeting");
		public By UpdatevenBut=By.id("updmeetincal");
		public By Updatelocat=By.id("update_meeting");
		public By scheduleDate = By.id("app_trigger_c_update");
		public By EventBar=By.cssSelector("[type*='meeting']");
		public By Eventsize=By.className("zpborbtmdash ");
		
		//Edit Meeting
		public By Edit=By.id("showedit");
		public By Editpencil=By.id("event_sidebar_title_zpeditNew");
		public By Time=By.id("schhour");
		public By UpdateButton=By.id("updmeetincal");
		public By cancelButton=By.id("calpopclose");
		public By EventComment=By.className("cmtBottom");
		public By CommentTextBox=By.id("milenewCommtxtar");
		public By AddCommentButton=By.id("addnMileNoteButton");
		public By CommentBox=By.cssSelector("[id*='nmcommCnt_']");
		public By MileUpdatetitle=By.name("mtitle");
		public By EventDelete=By.cssSelector("[title*='Delete meeting']");
		public By DeleteMsg=By.id("centerstatusmsg");
		
		//Add Milestone
		public By Milelink=By.cssSelector("[switchtype*='milestone']");
		public By Miletitle=By.id("addMilestone_title");
		public By MileButt=By.name("msubmit");
		public By MileIcon=By.className("zoho-cal-milestone");
		public By Mileflag=By.id("mileflagselect");
		public By MileUpddateButton=By.id("editmilesubmit");
		public By MileOwner=By.id("username");
		public By MilepopcancelBut=By.className("nmupdcancelcomment ");
		public By MileEnddate=By.cssSelector("[onclick*='#enddate_trigger_']");
		public By DateClick=By.className("DynarchCalendar-day");
		public By Today=By.cssSelector("[dyc-btn*='today']");
		public By NxtMonth=By.className("DynarchCalendar-nextMonth");
		public By MileBar=By.cssSelector("[type*='milestone']");
		
		//Add Bug
		public By Buglink=By.cssSelector("[switchtype*='bug']");
		public By Bugtitle=By.id("fileabugform_title");
		public By  Bugicon=By.className("zoho-bugs1");
		public By BugBar=By.cssSelector("[type*='bug']");
		
		//Events Page
		
		public By Eventtab=By.className("tourcalendar-2");
		public By Evantaddbut=By.id("addmeetId");
		public By Clickdatepic=By.id("app_trigger_c");
		public By ClickEveTitle=By.cssSelector("[id*='event_title_']");
		public By DeleteEvent=By.id("event_sidebar_title_zptrash");
		public By EventNots=By.id("addmeetnotes");
		public By remind=By.id("schremindbefore");
		public By repeat=By.id("meetalert");
		public By SelectProjID=By.id("s2id_logproject");
		public By SelectProjList=By.className("select2-result-label");
		public By Nxtmonth=By.id("nextmonth");
		
		//My Calendar Filter
		public By Filter=By.className("zoho-filter");
		public By Filtersearch=By.className("zoho-search");
		public By Filtertext=By.id("project_zpfilter");
		public By SelectBox=By.cssSelector("[ftype*='project']");
		public By Submitfilter=By.id("pfilter");
		public By ProjectList=By.id("logproject");
		public By EventAddasser=By.className("tasklistTitle4 ");
		public By Commentbutton=By.xpath("//div[text()='Add Comment']");
		
		
		//Associate Events Documents
		public By EventAttach=By.id("event_sidebar_attachments_0");
		public By Associ=By.linkText("Associate Documents");
		public By DocsFrame=By.id("zv_callreceiverframe");
		
		
		//Events Comments From Events tab
		public By projselect=By.className("select2-choice");
		public By Eventscomment=By.linkText("Comments");
		public By EventCommentbox=By.cssSelector("[id*='addtnote_']");
		public By AddCMTBtton=By.className("shortAddCmnt");
		public By Commentsize=By.cssSelector("[id*='notes_mn_']");
		public By UploadAttach=By.name("uploadfile");
		public By Eventclose=By.className("zoho-close");
		public By popclose=By.cssSelector("[onclick*='formSlideOnCancel']");
		public By eventpopclose=By.id("eventpopclose");
		public By Editevecmt=By.cssSelector("[id*='added_by_']");
		public By EditeveBox=By.className("logtimeaddtext");
		public By UpdateEvencmtbut=By.name("updatetasknote");
		public By proj_name_mycal = By.id("logproject");
		
		public By Eventattach=By.cssSelector("[id*='event_sidebar_attachments']");
		public By associateBut=By.cssSelector("[id*='eventfilemap_']");
		public By ChooseFile=By.cssSelector("[id*='fileNameSpan_']");
		public By AttachBut=By.className("ui-button-text");
		
				
}


