
package core.bean;

public class SessBean {

    public String name1 = "",  name2 = "";

    public SessBean() {
    }

    public SessBean(String name1, String name2) {
        setName1(name1);
        setName2(name2);
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName1() {
        return (name1);
    }

    public String getName2() {
        return (name2);
    }
}
