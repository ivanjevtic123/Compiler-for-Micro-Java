// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class CondFactListRec_Yes extends CondFactListRec {

    private CondFactListRec CondFactListRec;
    private CondFact CondFact;

    public CondFactListRec_Yes (CondFactListRec CondFactListRec, CondFact CondFact) {
        this.CondFactListRec=CondFactListRec;
        if(CondFactListRec!=null) CondFactListRec.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public CondFactListRec getCondFactListRec() {
        return CondFactListRec;
    }

    public void setCondFactListRec(CondFactListRec CondFactListRec) {
        this.CondFactListRec=CondFactListRec;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactListRec!=null) CondFactListRec.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactListRec!=null) CondFactListRec.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactListRec!=null) CondFactListRec.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactListRec_Yes(\n");

        if(CondFactListRec!=null)
            buffer.append(CondFactListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactListRec_Yes]");
        return buffer.toString();
    }
}
