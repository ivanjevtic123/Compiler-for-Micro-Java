// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class VarDec implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private VarName VarName;
    private MayArray MayArray;

    public VarDec (VarName VarName, MayArray MayArray) {
        this.VarName=VarName;
        if(VarName!=null) VarName.setParent(this);
        this.MayArray=MayArray;
        if(MayArray!=null) MayArray.setParent(this);
    }

    public VarName getVarName() {
        return VarName;
    }

    public void setVarName(VarName VarName) {
        this.VarName=VarName;
    }

    public MayArray getMayArray() {
        return MayArray;
    }

    public void setMayArray(MayArray MayArray) {
        this.MayArray=MayArray;
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
        if(VarName!=null) VarName.accept(visitor);
        if(MayArray!=null) MayArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarName!=null) VarName.traverseTopDown(visitor);
        if(MayArray!=null) MayArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarName!=null) VarName.traverseBottomUp(visitor);
        if(MayArray!=null) MayArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDec(\n");

        if(VarName!=null)
            buffer.append(VarName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MayArray!=null)
            buffer.append(MayArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDec]");
        return buffer.toString();
    }
}
