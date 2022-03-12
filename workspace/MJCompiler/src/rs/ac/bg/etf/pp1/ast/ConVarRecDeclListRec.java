// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class ConVarRecDeclListRec extends ConVarRecDeclList {

    private ConVarRecDeclList ConVarRecDeclList;
    private RecDecl RecDecl;

    public ConVarRecDeclListRec (ConVarRecDeclList ConVarRecDeclList, RecDecl RecDecl) {
        this.ConVarRecDeclList=ConVarRecDeclList;
        if(ConVarRecDeclList!=null) ConVarRecDeclList.setParent(this);
        this.RecDecl=RecDecl;
        if(RecDecl!=null) RecDecl.setParent(this);
    }

    public ConVarRecDeclList getConVarRecDeclList() {
        return ConVarRecDeclList;
    }

    public void setConVarRecDeclList(ConVarRecDeclList ConVarRecDeclList) {
        this.ConVarRecDeclList=ConVarRecDeclList;
    }

    public RecDecl getRecDecl() {
        return RecDecl;
    }

    public void setRecDecl(RecDecl RecDecl) {
        this.RecDecl=RecDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConVarRecDeclList!=null) ConVarRecDeclList.accept(visitor);
        if(RecDecl!=null) RecDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseTopDown(visitor);
        if(RecDecl!=null) RecDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConVarRecDeclList!=null) ConVarRecDeclList.traverseBottomUp(visitor);
        if(RecDecl!=null) RecDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConVarRecDeclListRec(\n");

        if(ConVarRecDeclList!=null)
            buffer.append(ConVarRecDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RecDecl!=null)
            buffer.append(RecDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConVarRecDeclListRec]");
        return buffer.toString();
    }
}
