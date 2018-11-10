package model;/* 
** Created By Tareq on 09, November, 2018
*/

public class Student_Model {
    private String s_Name;

    private String s_Email;

    private String s_Grade1;

    private String s_Grade2;

    private String s_Grade3;

    private String s_Grade_Avg;

    public String getS_Name() {
        return s_Name;
    }

    public String getS_Email() {
        return s_Email;
    }

    public String getS_Grade1() {
        return s_Grade1;
    }

    public String getS_Grade2() {
        return s_Grade2;
    }

    public String getS_Grade3() {
        return s_Grade3;
    }

    public String getS_Grade_Avg() {
        return s_Grade_Avg;
    }

    private Student_Model(Builder builder) {
        s_Name = builder.s_Name;
        s_Email = builder.s_Email;
        s_Grade1 = builder.s_Grade1;
        s_Grade2 = builder.s_Grade2;
        s_Grade3 = builder.s_Grade3;
        s_Grade_Avg = builder.s_Grade_Avg;
    }


    public static final class Builder {
        private String s_Name;
        private String s_Email;
        private String s_Grade1;
        private String s_Grade2;
        private String s_Grade3;
        private String s_Grade_Avg;

        public Builder() {
        }

        public Builder withS_Name(String val) {
            s_Name = val;
            return this;
        }

        public Builder withS_Email(String val) {
            s_Email = val;
            return this;
        }

        public Builder withS_Grade1(String val) {
            s_Grade1 = val;
            return this;
        }

        public Builder withS_Grade2(String val) {
            s_Grade2 = val;
            return this;
        }

        public Builder withS_Grade3(String val) {
            s_Grade3 = val;
            return this;
        }

        public Builder withS_Grade_Avg(String val) {
            s_Grade_Avg = val;
            return this;
        }

        public model.Student_Model build() {
            return new model.Student_Model(this);
        }
    }
}
