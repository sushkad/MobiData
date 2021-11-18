Add Screenshot code 

	  TakesScreenshot scrShot1 =((TakesScreenshot)d);
		File SrcFile1=scrShot1.getScreenshotAs(OutputType.FILE);
		File DestFile1=new File("E://FIN_MobiConnect//KYC1.png");
		FileUtils.copyFile(SrcFile1, DestFile1);
