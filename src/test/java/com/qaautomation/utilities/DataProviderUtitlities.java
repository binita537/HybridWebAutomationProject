package com.qaautomation.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderUtitlities {

	// @test will take care to load webDriverWrapper class and initilise the driver
	// and
	
	// then loginTest and pass this driver to loginTest
	
	//

	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException {
		Object[][] Data = ExcelUtils.getExcelSheetToObjectArray("src/test/resources/TestData/ExcelData.xlsx",
				method.getName()); //keep sheet   name as method name 
		return Data;
	}
 
}
