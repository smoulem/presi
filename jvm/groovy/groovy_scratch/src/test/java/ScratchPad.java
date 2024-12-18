import java.util.Date;

import org.junit.jupiter.api.Test;

public class ScratchPad
{
    private static String getFinderService()
    {
        return "m";
    }
    
    static void processSomething()
    {
        System.out.println(getFinderService());
        
    }
    
    @Test
    void doCalc()
    {
//        System.out.println(new Date());
        java.sql.Date date = java.sql.Date.valueOf( new Date().toString() );
        System.out.println(date);
//        processSomething();
    }
    
    static class MockScratchPad extends ScratchPad
    {
        
        private static String getFinderService()
        {
            return "w";
        }
        
        String doBiz()
        {
            return getFinderService();
        }
    }
    
    @Test
    void doCalcWithMock()
    {
        MockScratchPad subjectUnderTest = new MockScratchPad();
        System.out.println(subjectUnderTest.doBiz());
    }
}

