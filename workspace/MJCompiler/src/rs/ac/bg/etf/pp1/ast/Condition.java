// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class Condition implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private CondTermListRec CondTermListRec;

    public Condition (CondTermListRec CondTermListRec) {
        this.CondTermListRec=CondTermListRec;
        if(CondTermListRec!=null) CondTermListRec.setParent(this);
    }

    public CondTermListRec getCondTermListRec() {
        return CondTermListRec;
    }

    public void setCondTermListRec(CondTermListRec CondTermListRec) {
        this.CondTermListRec=CondTermListRec;
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
        if(CondTermListRec!=null) CondTermListRec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermListRec!=null) CondTermListRec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermListRec!=null) CondTermListRec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Condition(\n");

        if(CondTermListRec!=null)
            buffer.append(CondTermListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Condition]");
        return buffer.toString();
    }
}
