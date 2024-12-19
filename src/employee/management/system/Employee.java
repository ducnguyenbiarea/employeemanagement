
package employee.management.system;

public class Employee {
    private String tfname;
    private String dcdob;
    private String designation;
    private String cbeducation;
    private double tfsalary;
    private String tfcccd;
    private String lblempId;
    private String tfemail;
    private String tfaddress;
    private String tfphone;
    

    // Constructors
    public Employee() {}

    public Employee(String tfname, String dcdob, String designation, String cbeducation, double tfsalary, String tfcccd, String lblempId, String tfemail, String tfaddress, String tfphone) {
        this.tfname = tfname;
        this.dcdob = dcdob;
        this.designation = designation;
        this.cbeducation = cbeducation;
        this.tfsalary = tfsalary;
        this.tfcccd = tfcccd;
        this.lblempId = lblempId;
        this.tfemail = tfemail;
        this.tfaddress = tfaddress;
        this.tfphone = tfphone;
    }

    public String getTfname() {
        return tfname;
    }

    public void setTfname(String tfname) {
        this.tfname = tfname;
    }

    public String getDcdob() {
        return dcdob;
    }

    public void setDcdob(String dcdob) {
        this.dcdob = dcdob;
    }
    
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCbeducation() {
        return cbeducation;
    }

    public void setCbeducation(String cbeducation) {
        this.cbeducation = cbeducation;
    }

    public double getTfsalary() {
        return tfsalary;
    }

    public void setTfsalary(double tfsalary) {
        this.tfsalary = tfsalary;
    }

    public String getTfcccd() {
        return tfcccd;
    }

    public void setTfcccd(String tfcccd) {
        this.tfcccd = tfcccd;
    }

    public String getLblempId() {
        return lblempId;
    }

    public void setLblempId(String lblempId) {
        this.lblempId = lblempId;
    }

    public String getTfemail() {
        return tfemail;
    }

    public void setTfemail(String tfemail) {
        this.tfemail = tfemail;
    }

    public String getTfaddress() {
        return tfaddress;
    }

    public void setTfaddress(String tfaddress) {
        this.tfaddress = tfaddress;
    }

    public String getTfphone() {
        return tfphone;
    }

    public void setTfphone(String tfphone) {
        this.tfphone = tfphone;
    }

}