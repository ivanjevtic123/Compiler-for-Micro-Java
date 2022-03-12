// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class Term implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private FactorMulopListRec FactorMulopListRec;

    public Term (FactorMulopListRec FactorMulopListRec) {
        this.FactorMulopListRec=FactorMulopListRec;
        if(FactorMulopListRec!=null) FactorMulopListRec.setParent(this);
    }

    public FactorMulopListRec getFactorMulopListRec() {
        return FactorMulopListRec;
    }

    public void setFactorMulopListRec(FactorMulopListRec FactorMulopListRec) {
        this.FactorMulopListRec=FactorMulopListRec;
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
        if(FactorMulopListRec!=null) FactorMulopListRec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorMulopListRec!=null) FactorMulopListRec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorMulopListRec!=null) FactorMulopListRec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Term(\n");

        if(FactorMulopListRec!=null)
            buffer.append(FactorMulopListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Term]");
        return buffer.toString();
    }
}
