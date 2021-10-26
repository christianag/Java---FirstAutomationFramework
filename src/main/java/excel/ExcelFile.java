package excel;

import org.apache.poi.ss.usermodel.CellStyle;

public class ExcelFile {

    public String name;
    public String email;
    public String issue_date;
//    public String mejeri_final_exam_date;

    public ExcelFile(String name, String email, String issue_date) {
        this.name = name;
        this.email = email;
        this.issue_date = issue_date;
//        this.mejeri_final_exam_date = mejeri_final_exam_date;
    }


}


