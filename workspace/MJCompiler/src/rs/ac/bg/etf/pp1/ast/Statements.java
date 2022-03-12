// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class Statements implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private StatementListRec StatementListRec;

    public Statements (StatementListRec StatementListRec) {
        this.StatementListRec=StatementListRec;
        if(StatementListRec!=null) StatementListRec.setParent(this);
    }

    public StatementListRec getStatementListRec() {
        return StatementListRec;
    }

    public void setStatementListRec(StatementListRec StatementListRec) {
        this.StatementListRec=StatementListRec;
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
        if(StatementListRec!=null) StatementListRec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementListRec!=null) StatementListRec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementListRec!=null) StatementListRec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Statements(\n");

        if(StatementListRec!=null)
            buffer.append(StatementListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Statements]");
        return buffer.toString();
    }
}
