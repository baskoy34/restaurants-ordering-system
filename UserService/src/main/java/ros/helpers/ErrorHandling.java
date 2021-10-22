package ros.helpers;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
@Component
public class ErrorHandling extends Exception{

    private String error;

    private String location;

    private Date date;

    public ErrorHandling(){

    }

    public ErrorHandling(String error,String location){
        this.error = error;
        this.location = location;
        this.date = java.util.Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(error+"\n"+location+"\n"+date.toString());
    }

}
