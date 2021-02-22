package test.service;

import com.siemens.exception.LowerCaseCharException;
import com.siemens.exception.MaximumCharException;
import com.siemens.exception.MinimumCharException;
import com.siemens.service.CalculationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculationServiceTest {

    //Min Deletion of Chars Functionality is Checked againist several inputs
    @Test
    void minDeletionOfChars() throws Exception {
      Assertions.assertEquals(1,CalculationService.minDeletionOfChars("aaaabbbb"));
      Assertions.assertEquals(6,CalculationService.minDeletionOfChars("ccaaffddecee"));
      Assertions.assertEquals(0,CalculationService.minDeletionOfChars("eeee"));
      Assertions.assertEquals(4,CalculationService.minDeletionOfChars("example"));
    }

    //EXCEPTION TESTS

    // check string chars are between lowercase letter a-z
    @Test
    void checkLowerCaseException(){
        //check uppercase
        Assertions.assertThrows(LowerCaseCharException.class,()->{
            CalculationService.minDeletionOfChars("AaaBbbc");
        });
        //check char not range in a-z | alphanumeric
        Assertions.assertThrows(LowerCaseCharException.class,()->{
            CalculationService.minDeletionOfChars("1324");
        });

        Assertions.assertThrows(LowerCaseCharException.class,()->{
            CalculationService.minDeletionOfChars("aaaa+");
        });

    }

    //check string more than 300000 char and throws MaximumCharException if it more than 300000
    @Test
    void checkMaxCharException(){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<300001;i++){
            builder.append('a');
        }
        Assertions.assertThrows(MaximumCharException.class,()->{
            CalculationService.minDeletionOfChars(builder.toString());
        });
    }

    //check string less than 1 char and throws MinimumCharException if it less than 1
    @Test
    void checkMinCharException(){
        Assertions.assertThrows(MinimumCharException.class,()->{
            CalculationService.minDeletionOfChars("");
        });
    }


}

