import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class Message implements java.io.Serializable {

    @Excel(name = "HTTPStatus" )
    private int httpStatus;


    @Excel(name = "code" )
    private String code;



    @Excel(name = "description" )
    private String description;


}