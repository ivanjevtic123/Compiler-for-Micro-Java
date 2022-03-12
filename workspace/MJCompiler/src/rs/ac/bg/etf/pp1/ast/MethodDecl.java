// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private TypeOrVoidName TypeOrVoidName;
    private MethName MethName;
    private MayFormPars MayFormPars;
    private VarDeclListRec VarDeclListRec;
    private StatementListRec StatementListRec;

    public MethodDecl (TypeOrVoidName TypeOrVoidName, MethName MethName, MayFormPars MayFormPars, VarDeclListRec VarDeclListRec, StatementListRec StatementListRec) {
        this.TypeOrVoidName=TypeOrVoidName;
        if(TypeOrVoidName!=null) TypeOrVoidName.setParent(this);
        this.MethName=MethName;
        if(MethName!=null) MethName.setParent(this);
        this.MayFormPars=MayFormPars;
        if(MayFormPars!=null) MayFormPars.setParent(this);
        this.VarDeclListRec=VarDeclListRec;
        if(VarDeclListRec!=null) VarDeclListRec.setParent(this);
        this.StatementListRec=StatementListRec;
        if(StatementListRec!=null) StatementListRec.setParent(this);
    }

    public TypeOrVoidName getTypeOrVoidName() {
        return TypeOrVoidName;
    }

    public void setTypeOrVoidName(TypeOrVoidName TypeOrVoidName) {
        this.TypeOrVoidName=TypeOrVoidName;
    }

    public MethName getMethName() {
        return MethName;
    }

    public void setMethName(MethName MethName) {
        this.MethName=MethName;
    }

    public MayFormPars getMayFormPars() {
        return MayFormPars;
    }

    public void setMayFormPars(MayFormPars MayFormPars) {
        this.MayFormPars=MayFormPars;
    }

    public VarDeclListRec getVarDeclListRec() {
        return VarDeclListRec;
    }

    public void setVarDeclListRec(VarDeclListRec VarDeclListRec) {
        this.VarDeclListRec=VarDeclListRec;
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
        if(TypeOrVoidName!=null) TypeOrVoidName.accept(visitor);
        if(MethName!=null) MethName.accept(visitor);
        if(MayFormPars!=null) MayFormPars.accept(visitor);
        if(VarDeclListRec!=null) VarDeclListRec.accept(visitor);
        if(StatementListRec!=null) StatementListRec.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeOrVoidName!=null) TypeOrVoidName.traverseTopDown(visitor);
        if(MethName!=null) MethName.traverseTopDown(visitor);
        if(MayFormPars!=null) MayFormPars.traverseTopDown(visitor);
        if(VarDeclListRec!=null) VarDeclListRec.traverseTopDown(visitor);
        if(StatementListRec!=null) StatementListRec.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeOrVoidName!=null) TypeOrVoidName.traverseBottomUp(visitor);
        if(MethName!=null) MethName.traverseBottomUp(visitor);
        if(MayFormPars!=null) MayFormPars.traverseBottomUp(visitor);
        if(VarDeclListRec!=null) VarDeclListRec.traverseBottomUp(visitor);
        if(StatementListRec!=null) StatementListRec.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(TypeOrVoidName!=null)
            buffer.append(TypeOrVoidName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethName!=null)
            buffer.append(MethName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MayFormPars!=null)
            buffer.append(MayFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclListRec!=null)
            buffer.append(VarDeclListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementListRec!=null)
            buffer.append(StatementListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
