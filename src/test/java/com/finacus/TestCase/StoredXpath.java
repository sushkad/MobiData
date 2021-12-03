package com.finacus.TestCase;

public class StoredXpath {


	//Have you received your collection test kit? NO
	public static final String kitNotRecieved = "//label[@for='kitNotRecieved']";
	//Do you have Lab Requisition Form?
	public static final String havingRequisitionFormYES = "//label[@for='havingRequisitionForm']";
	public static final String nothavingRequisitionForm = "//label[@for='notHavingRequisitionForm']";

	//If you do not have your blood collection kit or Requisition Form please refer to your Physician 
	//for more details on receiving your kit or Requisition Form
	public static final String MoreDetailspopup = "//a[normalize-space()='Ok']";

	//Covid-19
	public static final String Covid19 = "//a[normalize-space()='COVID-19 Testing']";
	public static final String Cfirstname = "first_name"; //id
	public static final String Clastname = "last_name"; //id
	public static final String Cemail = "email"; //id
	public static final String Cphonenumber = "phone_number"; //id
	public static final String Cresult = "result"; //id
	public static final String CSend = "//button[normalize-space()='Send']";

	
	//Have you received your collection test kit? YES
	public static final String receivedKit = "//label[@for='receivedKit']";
	public static final String FirstName = "//input[@id='appointment_patient_first_name']";
	public static final String LastName = "//input[@id='appointment_patient_last_name']";
	public static final String DOB = "//input[@id='appointment_patient_birth_date']";
	public static final String Emailid = "//input[@id='appointment_patient_email']";
	public static final String PhoneNumber = "//input[@id='appointment_patient_phone_number']";
	
	public static final String Next = "//input[@id='appointment_patient_phone_number']/../../following-sibling::*/button[text()='Next']";
//	public static final String Nextbutton = "//button[text()='Next']";
	public static final String schAnApp = "//h1[text()='Schedule an appointment']";
	//Personal Information tab
	public static final String PersonalInformationtab = "//a[normalize-space()='1']";

	//Address
	public static final String Address = "appointment_patient_address_street";  //id
	public static final String AddressNext = "//button[@class='btn btn-gradient address-submit nextBtn btn-lg pull-right w-100']";

	//Lab and Test Kits
	public static final String SelectLab = "//select[@id='appointment_organisation_details_organisation']";

	public static final String Lab4 ="/html/body/main/div/div/div[2]/form/div[3]/div[1]/div/div[1]/select/option[5]";

	public static final String UNITY = "//label[normalize-space()='UNITY']";

	public static final String NextbuttonLab = "//button[@class='btn btn-gradient nextBtn btn-lg pull-right w-100 step-3-form']";

	public static final String Lab1 = "//*[@id=\"step-3\"]/div[1]/div/div[2]/div/div[1]/div[3]/label";

	public static final String LabNext = "//button[@class='btn btn-gradient nextBtn btn-lg pull-right w-100 step-3-form']";

	//Date and Time
	public static final String Date = "//input[@id='appointment_appointment_details_appointment_date']";
	public static final String Date31 = "//span[@aria-label='October 31, 2021']";

	public static final String Time = "//input[@id='appointment_appointment_details_appointment_time']";
	public static final String Time1 ="//input[@aria-label='Hour']";
	public static final String AdditionalRequest = "//textarea[@id='appointment_appointment_details_note']";
	public static final String Nextbuttondateandtime = "//button[@type='submit']";

	//Payment
	public static final String CC = "//input[@id='card_number']";
	public static final String Expmy = "//input[@id='card_month']";		
	public static final String CVC = "//input[@id='card_code']";
	public static final String Paynow = "//input[@id='pay-now']";

	//Sign In
	public static final String SignIN = "//a[normalize-space()='Sign In']";
	public static final String Email = "//input[@id='user_email']";
	public static final String password = "//input[@id='user_password']";
	public static final String Login = "//input[@name='commit']";
	public static final String Search = "//input[@id='q_patient_tests_kit_organisation_name_or_patient_first_name_or_patient_email_or_patient_phone_number_or_patient_last_name_or_agent_email_or_appointment_request_id_or_patient_address_city_cont']";


	public static final String AddAppointment = "//a[normalize-space()='Add Appointment']";
	public static final String Dateandtime = "//a[normalize-space()='Created Date/Time']";

	
	public static final String AppStatus = "//select[@id='q_status_eq']";
	public static final String Completed = "//option[normalize-space()='COMPLETED']";
	public static final String Edit1 = "//tbody/tr[2]/td[10]/div[1]/a[2]//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]";
	public static final String Canceledit1 = "//a[normalize-space()='Cancel']";

}