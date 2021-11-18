package com.finacus.WebPortal;

public class VSBLIBXpath
{
	//Login page
	public static final String Email = "email";
	public static final String Password = "password";
	public static final String Login = "/html/body/div/main/div[2]/div/form/button/span[1]";
	
	public static final String Captcha = "//input[@id='captchaCode']";
	public static final String readline = "//form[@autocomplete='off']//div//div//div//img";
	public static final String CaptchaRefresh = "//form[@autocomplete='off']//button[@type='button']//span[1]//*[name()='svg']";

	//New Registration
	public static final String NewUserRegistration = "//a[normalize-space()='New User Registration?']";
	public static final String CustomerNumber = "//input[@id='custNo']"; 
	public static final String CustomerMobNo = "//input[@id='mobNo']";
	public static final String Validatebutton = "//span[normalize-space()='Validate']";
	public static final String Backbutton = "//body//div//main//div//main//div//div//form//button[@type='button']";

	public static final String MobileSubmit = "//span[@class='MuiButton-label']";
	public static final String MobileOK = "//button[normalize-space()='OK']";
	public static final String TxtOTP = "//input[@name='txtOTP']";
	public static final String OTPSubmit = "//span[@class='MuiButton-label']";
	public static final String OTPvalidate = "//button[normalize-space()='OK']";

	public static final String MPIN = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";

	// Forgot UserId
	public static final String ForgotUserId = "//a[normalize-space()='Forgot UserId?']";
	public static final String accNo  = "//input[@id='accNo']"; //id
	public static final String mobNo  = "//input[@id='mobNo']"; //id
	public static final String Continue = "//span[normalize-space()='Continue']";
	public static final String ForgotUserIdBack = "//span[normalize-space()='Back']";

	// Forgot Password?
	public static final String ForgotPassword  = "//a[normalize-space()='Forgot Password?']";
	public static final String ForgotuserId = "//input[@id='userId']";
	public static final String ForgotmobNo = "//input[@id='mobNo']";
	public static final String GetOTP  = "//span[normalize-space()='Get OTP']";
	public static final String Forgotback = "//span[normalize-space()='Back']";
	
	public static final String virtualkey = "//input[@value='remember']";

	//Accounts
	public static final String CASA = "//span[text()='CASA ACCOUNT']";
	//public static final String DEPOSIT = "//span[normalize-space()='DEPOSIT ACCOUNT']"; //"//span[text()='DEPOSIT ACCOUNT']";
	public static final String DEPOSIT = "//span[text()='DEPOSIT ACCOUNT']";
	
	public static final String LOAN = "//span[text()='LOAN ACCOUNT']";

	//HOME
	public static final String Logoutbutton = "//button[@title='Logout']//span[@class='MuiButton-label']//*[name()='svg']";
	public static final String UserManual = "//button[@title='User Manual']//span[@class='MuiButton-label']//*[name()='svg']";
	public static final String Help = "//button[@title='Help']//span[@class='MuiButton-label']//*[name()='svg']";

	public static final String ViewAccount = "//span[normalize-space()='View']";
	
	public static final String SelectAccount = "//select[@id='select']";
	
	//Dashboard
	
	public static final String Dashboard = "//span[text()='Dashboard']";
	public static final String AccountSummary = "//span[text()='Account Summary']";
	public static final String Request = "//span[text()='Request']";
	public static final String Enquiry = "//span[text()='Enquiry']";
	public static final String OtherServices = "//span[text()='Other Services']";
	

}
