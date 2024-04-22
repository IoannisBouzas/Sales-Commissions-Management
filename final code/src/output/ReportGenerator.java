
package output;

import data.Salesman;

public abstract class ReportGenerator {

	protected Salesman salesman;
	
	public abstract void takePath() throws Exception;
	public abstract void processData() throws Exception;


	
	public void saveFile()
	{
		try
		{
			takePath();
			processData();
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
		
	
}
