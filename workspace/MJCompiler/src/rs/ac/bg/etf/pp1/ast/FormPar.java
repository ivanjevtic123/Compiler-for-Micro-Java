// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class FormPar implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarDec VarDec;

    public FormPar (VarDec VarDec) {
        this.VarDec=VarDec;
        if(VarDec!=null) VarDec.setParent(this);
    }

    public VarDec getVarDec() {
        return VarDec;
    }

    public void setVarDec(VarDec VarDec) {
        this.VarDec=VarDec;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDec!=null) VarDec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDec!=null) VarDec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDec!=null) VarDec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPar(\n");

        if(VarDec!=null)
            buffer.append(VarDec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPar]");
        return buffer.toString();
    }
}
