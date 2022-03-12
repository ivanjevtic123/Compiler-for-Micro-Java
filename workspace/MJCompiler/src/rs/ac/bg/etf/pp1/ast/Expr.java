// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class Expr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private AddOpTermListRec AddOpTermListRec;

    public Expr (AddOpTermListRec AddOpTermListRec) {
        this.AddOpTermListRec=AddOpTermListRec;
        if(AddOpTermListRec!=null) AddOpTermListRec.setParent(this);
    }

    public AddOpTermListRec getAddOpTermListRec() {
        return AddOpTermListRec;
    }

    public void setAddOpTermListRec(AddOpTermListRec AddOpTermListRec) {
        this.AddOpTermListRec=AddOpTermListRec;
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
        if(AddOpTermListRec!=null) AddOpTermListRec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddOpTermListRec!=null) AddOpTermListRec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddOpTermListRec!=null) AddOpTermListRec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr(\n");

        if(AddOpTermListRec!=null)
            buffer.append(AddOpTermListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr]");
        return buffer.toString();
    }
}
