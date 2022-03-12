// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class MoreVarDeclaration extends MoreVarDec {

    private VarDec VarDec;
    private MoreVarDec MoreVarDec;

    public MoreVarDeclaration (VarDec VarDec, MoreVarDec MoreVarDec) {
        this.VarDec=VarDec;
        if(VarDec!=null) VarDec.setParent(this);
        this.MoreVarDec=MoreVarDec;
        if(MoreVarDec!=null) MoreVarDec.setParent(this);
    }

    public VarDec getVarDec() {
        return VarDec;
    }

    public void setVarDec(VarDec VarDec) {
        this.VarDec=VarDec;
    }

    public MoreVarDec getMoreVarDec() {
        return MoreVarDec;
    }

    public void setMoreVarDec(MoreVarDec MoreVarDec) {
        this.MoreVarDec=MoreVarDec;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDec!=null) VarDec.accept(visitor);
        if(MoreVarDec!=null) MoreVarDec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDec!=null) VarDec.traverseTopDown(visitor);
        if(MoreVarDec!=null) MoreVarDec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDec!=null) VarDec.traverseBottomUp(visitor);
        if(MoreVarDec!=null) MoreVarDec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreVarDeclaration(\n");

        if(VarDec!=null)
            buffer.append(VarDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MoreVarDec!=null)
            buffer.append(MoreVarDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreVarDeclaration]");
        return buffer.toString();
    }
}
