import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class InterfaceError implements java.io.Serializable {


    @Excel(name = "code" )
    private String code;



    @Excel(name = "description" )
    private String description;


}
