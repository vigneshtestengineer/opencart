package utilites;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\TestData\\LoginData.xlsx";  //taking xl file from testdata
		
		ExcelUtilites xlutil=new ExcelUtilites(path); //Creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=1;j<=totalcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j); //1,0
			}
		}
		return logindata;  //Returning two dimension array
	}

}
