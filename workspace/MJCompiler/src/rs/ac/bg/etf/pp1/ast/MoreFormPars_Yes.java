// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class MoreFormPars_Yes extends MoreFormPars {

    private Type Type;
    private FormPar FormPar;
    private MoreFormPars MoreFormPars;

    public MoreFormPars_Yes (Type Type, FormPar FormPar, MoreFormPars MoreFormPars) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormPar=FormPar;
        if(FormPar!=null) FormPar.setParent(this);
        this.MoreFormPars=MoreFormPars;
        if(MoreFormPars!=null) MoreFormPars.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormPar getFormPar() {
        return FormPar;
    }

    public void setFormPar(FormPar FormPar) {
        this.FormPar=FormPar;
    }

    public MoreFormPars getMoreFormPars() {
        return MoreFormPars;
    }

    public void setMoreFormPars(MoreFormPars MoreFormPars) {
        this.MoreFormPars=MoreFormPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FormPar!=null) FormPar.accept(visitor);
        if(MoreFormPars!=null) MoreFormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormPar!=null) FormPar.traverseTopDown(visitor);
        if(MoreFormPars!=null) MoreFormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormPar!=null) FormPar.traverseBottomUp(visitor);
        if(MoreFormPars!=null) MoreFormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MoreFormPars_Yes(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPar!=null)
            buffer.append(FormPar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MoreFormPars!=null)
            buffer.append(MoreFormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MoreFormPars_Yes]");
        return buffer.toString();
    }
}
