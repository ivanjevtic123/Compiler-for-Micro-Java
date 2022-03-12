// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class RecDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private RecDeclName RecDeclName;
    private VarDeclListRec VarDeclListRec;

    public RecDecl (RecDeclName RecDeclName, VarDeclListRec VarDeclListRec) {
        this.RecDeclName=RecDeclName;
        if(RecDeclName!=null) RecDeclName.setParent(this);
        this.VarDeclListRec=VarDeclListRec;
        if(VarDeclListRec!=null) VarDeclListRec.setParent(this);
    }

    public RecDeclName getRecDeclName() {
        return RecDeclName;
    }

    public void setRecDeclName(RecDeclName RecDeclName) {
        this.RecDeclName=RecDeclName;
    }

    public VarDeclListRec getVarDeclListRec() {
        return VarDeclListRec;
    }

    public void setVarDeclListRec(VarDeclListRec VarDeclListRec) {
        this.VarDeclListRec=VarDeclListRec;
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
        if(RecDeclName!=null) RecDeclName.accept(visitor);
        if(VarDeclListRec!=null) VarDeclListRec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RecDeclName!=null) RecDeclName.traverseTopDown(visitor);
        if(VarDeclListRec!=null) VarDeclListRec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RecDeclName!=null) RecDeclName.traverseBottomUp(visitor);
        if(VarDeclListRec!=null) VarDeclListRec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecDecl(\n");

        if(RecDeclName!=null)
            buffer.append(RecDeclName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclListRec!=null)
            buffer.append(VarDeclListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecDecl]");
        return buffer.toString();
    }
}
