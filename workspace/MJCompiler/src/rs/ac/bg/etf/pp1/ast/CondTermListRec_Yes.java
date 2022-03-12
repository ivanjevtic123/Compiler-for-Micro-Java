// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class CondTermListRec_Yes extends CondTermListRec {

    private CondTermListRec CondTermListRec;
    private CondTerm CondTerm;

    public CondTermListRec_Yes (CondTermListRec CondTermListRec, CondTerm CondTerm) {
        this.CondTermListRec=CondTermListRec;
        if(CondTermListRec!=null) CondTermListRec.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondTermListRec getCondTermListRec() {
        return CondTermListRec;
    }

    public void setCondTermListRec(CondTermListRec CondTermListRec) {
        this.CondTermListRec=CondTermListRec;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermListRec!=null) CondTermListRec.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermListRec!=null) CondTermListRec.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermListRec!=null) CondTermListRec.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermListRec_Yes(\n");

        if(CondTermListRec!=null)
            buffer.append(CondTermListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermListRec_Yes]");
        return buffer.toString();
    }
}
