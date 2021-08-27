import java.io.IOException;  

public class RunBat
{  
    public static void main(String args[]) {  
        Runtime run = Runtime.getRuntime();  
        Process p = null;  
        String cmd = ".\\commit.cmd";  
        try 
		{  
            p = run.exec(cmd);  
            p.getErrorStream();  
            System.out.println("RUN.COMPLETED.SUCCESSFULLY");  
        }  
        catch (IOException e)
		{  
            e.printStackTrace();  
            System.out.println("ERROR.RUNNING.CMD");  
            p.destroy();  
        }  
    }  
}  