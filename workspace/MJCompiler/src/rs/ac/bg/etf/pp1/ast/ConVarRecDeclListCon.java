// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class ConVarRecDeclListCon extends ConVarRecDeclList {

    private ConVarRecDeclList ConVarRecDeclList;
    private ConstDeclList ConstDeclList;

    public ConVarRecDeclListCon (ConVarRecDeclList ConVarRecDeclList, ConstDeclList ConstDeclList) {
        this.ConVarRecDeclList=ConVarRecDeclList;
        if(ConVarRecDeclList!=null) ConVarRecDeclList.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public ConVarRecDeclList getConVarRecDeclList() {
        return ConVarRecDeclList;
    }

    public void setConVarRecDeclList(ConVarRecDeclList ConVarRecDeclList) {
        this.ConVarRecDeclList=ConVarRecDeclList;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConVarRecDeclList!=null) ConVarRecDeclList.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConVarRecDeclListCon(\n");

        if(ConVarRecDeclList!=null)
            buffer.append(ConVarRecDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConVarRecDeclListCon]");
        return buffer.toString();
    }
}
