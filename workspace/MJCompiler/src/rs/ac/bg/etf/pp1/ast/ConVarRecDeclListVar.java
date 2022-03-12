// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class ConVarRecDeclListVar extends ConVarRecDeclList {

    private ConVarRecDeclList ConVarRecDeclList;
    private VarDeclList VarDeclList;

    public ConVarRecDeclListVar (ConVarRecDeclList ConVarRecDeclList, VarDeclList VarDeclList) {
        this.ConVarRecDeclList=ConVarRecDeclList;
        if(ConVarRecDeclList!=null) ConVarRecDeclList.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public ConVarRecDeclList getConVarRecDeclList() {
        return ConVarRecDeclList;
    }

    public void setConVarRecDeclList(ConVarRecDeclList ConVarRecDeclList) {
        this.ConVarRecDeclList=ConVarRecDeclList;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConVarRecDeclList!=null) ConVarRecDeclList.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConVarRecDeclListVar(\n");

        if(ConVarRecDeclList!=null)
            buffer.append(ConVarRecDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConVarRecDeclListVar]");
        return buffer.toString();
    }
}
