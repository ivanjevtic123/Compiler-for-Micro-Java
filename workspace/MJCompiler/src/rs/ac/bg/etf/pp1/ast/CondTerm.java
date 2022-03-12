// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class CondTerm implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private CondFactListRec CondFactListRec;

    public CondTerm (CondFactListRec CondFactListRec) {
        this.CondFactListRec=CondFactListRec;
        if(CondFactListRec!=null) CondFactListRec.setParent(this);
    }

    public CondFactListRec getCondFactListRec() {
        return CondFactListRec;
    }

    public void setCondFactListRec(CondFactListRec CondFactListRec) {
        this.CondFactListRec=CondFactListRec;
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
        if(CondFactListRec!=null) CondFactListRec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactListRec!=null) CondFactListRec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactListRec!=null) CondFactListRec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTerm(\n");

        if(CondFactListRec!=null)
            buffer.append(CondFactListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTerm]");
        return buffer.toString();
    }
}
