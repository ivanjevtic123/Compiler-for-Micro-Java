// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListRec_Dot extends DesignatorListRec {

    private DesignatorListRec DesignatorListRec;
    private DesignatorName DesignatorName;

    public DesignatorListRec_Dot (DesignatorListRec DesignatorListRec, DesignatorName DesignatorName) {
        this.DesignatorListRec=DesignatorListRec;
        if(DesignatorListRec!=null) DesignatorListRec.setParent(this);
        this.DesignatorName=DesignatorName;
        if(DesignatorName!=null) DesignatorName.setParent(this);
    }

    public DesignatorListRec getDesignatorListRec() {
        return DesignatorListRec;
    }

    public void setDesignatorListRec(DesignatorListRec DesignatorListRec) {
        this.DesignatorListRec=DesignatorListRec;
    }

    public DesignatorName getDesignatorName() {
        return DesignatorName;
    }

    public void setDesignatorName(DesignatorName DesignatorName) {
        this.DesignatorName=DesignatorName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorListRec!=null) DesignatorListRec.accept(visitor);
        if(DesignatorName!=null) DesignatorName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorListRec!=null) DesignatorListRec.traverseTopDown(visitor);
        if(DesignatorName!=null) DesignatorName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorListRec!=null) DesignatorListRec.traverseBottomUp(visitor);
        if(DesignatorName!=null) DesignatorName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListRec_Dot(\n");

        if(DesignatorListRec!=null)
            buffer.append(DesignatorListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorName!=null)
            buffer.append(DesignatorName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListRec_Dot]");
        return buffer.toString();
    }
}
