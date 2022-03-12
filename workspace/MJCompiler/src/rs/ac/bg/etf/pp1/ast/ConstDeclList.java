// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclList implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private ConstDec ConstDec;
    private MoreConstDec MoreConstDec;

    public ConstDeclList (Type Type, ConstDec ConstDec, MoreConstDec MoreConstDec) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstDec=ConstDec;
        if(ConstDec!=null) ConstDec.setParent(this);
        this.MoreConstDec=MoreConstDec;
        if(MoreConstDec!=null) MoreConstDec.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(ConstDec!=null) ConstDec.accept(visitor);
        if(MoreConstDec!=null) MoreConstDec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDec!=null) ConstDec.traverseTopDown(visitor);
        if(MoreConstDec!=null) MoreConstDec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDec!=null) ConstDec.traverseBottomUp(visitor);
        if(MoreConstDec!=null) MoreConstDec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [ConstDeclList]");
        return buffer.toString();
    }
}
