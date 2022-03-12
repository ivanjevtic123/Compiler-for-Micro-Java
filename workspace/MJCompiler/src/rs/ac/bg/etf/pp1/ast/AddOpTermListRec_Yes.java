// generated with ast extension for cup
// version 0.8
// 26/0/2022 20:19:56


package rs.ac.bg.etf.pp1.ast;

public class AddOpTermListRec_Yes extends AddOpTermListRec {

    private AddOpTermListRec AddOpTermListRec;
    private AddOp AddOp;
    private Term Term;

    public AddOpTermListRec_Yes (AddOpTermListRec AddOpTermListRec, AddOp AddOp, Term Term) {
        this.AddOpTermListRec=AddOpTermListRec;
        if(AddOpTermListRec!=null) AddOpTermListRec.setParent(this);
        this.AddOp=AddOp;
        if(AddOp!=null) AddOp.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public AddOpTermListRec getAddOpTermListRec() {
        return AddOpTermListRec;
    }

    public void setAddOpTermListRec(AddOpTermListRec AddOpTermListRec) {
        this.AddOpTermListRec=AddOpTermListRec;
    }

    public AddOp getAddOp() {
        return AddOp;
    }

    public void setAddOp(AddOp AddOp) {
        this.AddOp=AddOp;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddOpTermListRec!=null) AddOpTermListRec.accept(visitor);
        if(AddOp!=null) AddOp.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddOpTermListRec!=null) AddOpTermListRec.traverseTopDown(visitor);
        if(AddOp!=null) AddOp.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddOpTermListRec!=null) AddOpTermListRec.traverseBottomUp(visitor);
        if(AddOp!=null) AddOp.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddOpTermListRec_Yes(\n");

        if(AddOpTermListRec!=null)
            buffer.append(AddOpTermListRec.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddOp!=null)
            buffer.append(AddOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddOpTermListRec_Yes]");
        return buffer.toString();
    }
}
