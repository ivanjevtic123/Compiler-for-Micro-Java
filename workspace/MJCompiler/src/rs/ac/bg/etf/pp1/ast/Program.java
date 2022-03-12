// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgramName ProgramName;
    private ConVarRecDeclList ConVarRecDeclList;
    private MethodList MethodList;

    public Program (ProgramName ProgramName, ConVarRecDeclList ConVarRecDeclList, MethodList MethodList) {
        this.ProgramName=ProgramName;
        if(ProgramName!=null) ProgramName.setParent(this);
        this.ConVarRecDeclList=ConVarRecDeclList;
        if(ConVarRecDeclList!=null) ConVarRecDeclList.setParent(this);
        this.MethodList=MethodList;
        if(MethodList!=null) MethodList.setParent(this);
    }

    public ProgramName getProgramName() {
        return ProgramName;
    }

    public void setProgramName(ProgramName ProgramName) {
        this.ProgramName=ProgramName;
    }

    public ConVarRecDeclList getConVarRecDeclList() {
        return ConVarRecDeclList;
    }

    public void setConVarRecDeclList(ConVarRecDeclList ConVarRecDeclList) {
        this.ConVarRecDeclList=ConVarRecDeclList;
    }

    public MethodList getMethodList() {
        return MethodList;
    }

    public void setMethodList(MethodList MethodList) {
        this.MethodList=MethodList;
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
        if(ProgramName!=null) ProgramName.accept(visitor);
        if(ConVarRecDeclList!=null) ConVarRecDeclList.accept(visitor);
        if(MethodList!=null) MethodList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgramName!=null) ProgramName.traverseTopDown(visitor);
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseTopDown(visitor);
        if(MethodList!=null) MethodList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgramName!=null) ProgramName.traverseBottomUp(visitor);
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseBottomUp(visitor);
        if(MethodList!=null) MethodList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgramName!=null)
            buffer.append(ProgramName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConVarRecDeclList!=null)
            buffer.append(ConVarRecDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodList!=null)
            buffer.append(MethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
