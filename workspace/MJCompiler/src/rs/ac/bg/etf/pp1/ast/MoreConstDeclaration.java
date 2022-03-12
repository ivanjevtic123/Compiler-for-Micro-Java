// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class MoreConstDeclaration extends MoreConstDec {

    private ConstDec ConstDec;
    private MoreConstDec MoreConstDec;

    public MoreConstDeclaration (ConstDec ConstDec, MoreConstDec MoreConstDec) {
        this.ConstDec=ConstDec;
        if(ConstDec!=null) ConstDec.setParent(this);
        this.MoreConstDec=MoreConstDec;
        if(MoreConstDec!=null) MoreConstDec.setParent(this);
    }

    public ConstDec getConstDec() {
        return ConstDec;
    }

    public void setConstDec(ConstDec ConstDec) {
        this.ConstDec=ConstDec;
    }

    public MoreConstDec getMoreConstDec() {
        return MoreConstDec;
    }

    public void setMoreConstDec(MoreConstDec MoreConstDec) {
        this.MoreConstDec=MoreConstDec;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDec!=null) ConstDec.accept(visitor);
        if(MoreConstDec!=null) MoreConstDec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDec!=null) ConstDec.traverseTopDown(visitor);
        if(MoreConstDec!=null) MoreConstDec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDec!=null) ConstDec.traverseBottomUp(visitor);
        if(MoreConstDec!=null) MoreConstDec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreConstDeclaration(\n");

        if(ConstDec!=null)
            buffer.append(ConstDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MoreConstDec!=null)
            buffer.append(MoreConstDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreConstDeclaration]");
        return buffer.toString();
    }
}
