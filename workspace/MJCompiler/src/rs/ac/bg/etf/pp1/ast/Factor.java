// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class Factor implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private MayMinus MayMinus;
    private FactorSub FactorSub;

    public Factor (MayMinus MayMinus, FactorSub FactorSub) {
        this.MayMinus=MayMinus;
        if(MayMinus!=null) MayMinus.setParent(this);
        this.FactorSub=FactorSub;
        if(FactorSub!=null) FactorSub.setParent(this);
    }

    public MayMinus getMayMinus() {
        return MayMinus;
    }

    public void setMayMinus(MayMinus MayMinus) {
        this.MayMinus=MayMinus;
    }

    public FactorSub getFactorSub() {
        return FactorSub;
    }

    public void setFactorSub(FactorSub FactorSub) {
        this.FactorSub=FactorSub;
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
        if(MayMinus!=null) MayMinus.accept(visitor);
        if(FactorSub!=null) FactorSub.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MayMinus!=null) MayMinus.traverseTopDown(visitor);
        if(FactorSub!=null) FactorSub.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MayMinus!=null) MayMinus.traverseBottomUp(visitor);
        if(FactorSub!=null) FactorSub.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Factor(\n");

        if(MayMinus!=null)
            buffer.append(MayMinus.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorSub!=null)
            buffer.append(FactorSub.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Factor]");
        return buffer.toString();
    }
}
