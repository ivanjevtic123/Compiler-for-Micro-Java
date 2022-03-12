// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class VarDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private VarDec VarDec;
    private MoreVarDec MoreVarDec;

    public VarDeclList (Type Type, VarDec VarDec, MoreVarDec MoreVarDec) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDec=VarDec;
        if(VarDec!=null) VarDec.setParent(this);
        this.MoreVarDec=MoreVarDec;
        if(MoreVarDec!=null) MoreVarDec.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(VarDec!=null) VarDec.accept(visitor);
        if(MoreVarDec!=null) MoreVarDec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDec!=null) VarDec.traverseTopDown(visitor);
        if(MoreVarDec!=null) MoreVarDec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDec!=null) VarDec.traverseBottomUp(visitor);
        if(MoreVarDec!=null) MoreVarDec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [VarDeclList]");
        return buffer.toString();
    }
}
