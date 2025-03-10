package dataprovider;

import org.testng.annotations.DataProvider;

import Patrol.utilities.ExcelUtils;

public class DistrictCourtDataProvider {
	
	@DataProvider(name = "ByCNRDistrictCourtDataProvider")
    public static Object[][] provideDataExternal() {
        return new Object[][] {
        	
        	//Valid CNR

        	{"DLNE020003822022"},
        	{"PBFZA10003602014"},
        	{"MHYA020014692016"},
        	{"WBHW040009282022"},
       	    {"TNDP010004962022"},
        	{"MNIW080000012024"},
        	{"ODAN040007062020"},
        	{"APNE0A0002542022"},
            {"TSAD0D0000092022"},
        	
            //Invalid CNR numbers  
        	
         	{"WBSP01008496201"},  // Less than 16 characters
            {"WBSP0100849620178"},  // More than 16 characters
            {"1234567890123456"},  // Only digits, no valid court code
            {"XXXX010084962017"},  // Invalid court code
            {"WBSP01A084962017"},  // Contains an alphabet in the numeric section
            {"WBSP01008496201@"},  // Contains a special character
            {"W BSP010084962017"},  // Contains a space/            
            {"WBSP01008496201O"},  // Contains the letter 'O' instead of zero            
            {"WBHC010000002024"},  // Random invalid CNR
            {"GJSP019999992000"},  // Random invalid CNR
            {"DLHC010ABCDE2015"},  // Contains alphabets in numeric section
            {"APHC999999999999"},  // Unlikely valid pattern
            {"HPHC010000000000"}   // Too many zeros
        	
        };
	}
	
//	@DataProvider(name = "ByCaseDistrictCourtDataProvider")
//    public static Object[][] provideDataExternal2() {
//        return new Object[][] {
//        	
//        	//State , District , Forum , Case Type
//        	
//        	 };
//        
//	}
	
	@DataProvider(name = "districtbycase")
    public Object[][] getData() {
        String filePath = "src/test/resources/test-data/state1.xlsx"; // Change as per your file location
        String sheetName = "Sheet1";
        return ExcelUtils.getExcelData(filePath, sheetName);
    }
	
	
	
	@DataProvider(name = "ByPartyNameDistrictCourtDataProvider")
    public static Object[][] provideDataExternal3() {
        return new Object[][] {
        	
        	//State , District , Case Status
        	{"Andaman and Nicobar","Port Blair"},
        	{"Andhra Pradesh","Anantpur"},
        	{"Arunachal Pradesh","Changlang"},
        	{"Assam","Nellore"},
        	{"Bihar","Siwan"},
        	{"Chhattisgarh","Balodabazar"},
        	{"Dadra and Nagar Haveli","Silvassa"},
        	{"Delhi","South Delhi"},
        	{"Goa","North Goa"},
        	{"Gujarat","Bharuch"},
        	{"Haryana","Gurgaon"},
        	{"Himachal Pradesh","Kullu"},
        	{"Jammu and Kashmir","Pulwama"},
        	{"Jharkhand","Koderma"},



            };
	}

}
