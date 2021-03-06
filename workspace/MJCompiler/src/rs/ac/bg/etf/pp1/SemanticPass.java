package rs.ac.bg.etf.pp1;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {


	Obj currentMethod = null;
	boolean errorDetected = false; //stavlja se na true samo ako se pozove "report_error()"
	int nVars;
	
	boolean returnFlag = false;
	boolean mainFlag = false;
	
	String nazivTipa = "";
	List<Struct> ActParsList = new LinkedList<Struct>();
	
	List<String> labelsHappened = new LinkedList<String>();
	List<String> labelsToGoTo = new LinkedList<String>();
	
	
	Logger log = Logger.getLogger(getClass());
	private Obj currentProg;
	private Struct currentType;
	private int constant;
	private String currentVar;
	private Obj currentRecord;
	private Obj currentMeth;

	public void report_error(String message, SyntaxNode info) { //kad se desi greska - setuje "errorDetected" na true
		errorDetected = true; //FLAG
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public boolean passed(){
    	return !errorDetected;
    }
	
	
	@Override
	public void visit(ProgramName programName) { //universe ObjNode  //poziva se pre ove ispod metode
		currentProg = Tab.insert(Obj.Prog, programName.getI1(), Tab.noType);
		Tab.openScope(); //otvaram globalni Scope
		
		/*Struct boolStruct = new Struct(Struct.Bool);
        Obj boolObj = Tab.insert(Obj.Type, "bool", boolStruct);
        boolObj.setLevel(-1);
        boolObj.setAdr(-1);*/
	}
	
	@Override
	public void visit(Program program) {
		nVars = Tab.currentScope.getnVars(); //dodao //4 FAZA - num of vars, globalnih prom broj
		
		if(mainFlag == false) {
			report_error("GRESKA: Niste definisali Main metodu", program);
		}
		
		Tab.chainLocalSymbols(currentProg); //prelancam ovaj odozgo //OBJ
		Tab.closeScope(); //zatvorim scope kad sam ga prelancao
	}
	
	
	public void visit(ConstDec constDec) {
		//provara da li konstanta vec postoji
		//provera da li je currentType isto sto i tip od constant
		/*if(!(constDec.getConst() == Tab.find(null))) {
			
		}*/
		/*if(Tab.find(constDec.getI1()).getType() != currentType) {
			report_error("...", constDec);
		}*/
		if(!(constDec.getConst().struct == currentType)) {
			report_error("GRESKA: Los tip", constDec);
		}
		else if(!Tab.find(constDec.getI1()).equals(Tab.noObj)) {
			report_error("GRESKA: Konstanta vec postoji", constDec);
		} else {
			Obj constObj = Tab.insert(Obj.Con, constDec.getI1(), currentType);
			constObj.setAdr(constant);
			
			report_info("Deklarisana konstanta: " + constDec.getI1(), constDec);
		}
		
	}
	
	@Override
	public void visit(NumConst numConst) {
		numConst.struct = Tab.intType;
		constant = numConst.getN1();
	}
	
	@Override
	public void visit(BoolConst boolConst) { 
		boolConst.struct = Tab.find("bool").getType();
		constant = boolConst.getB1();
	}
	
	@Override
	public void visit(CharConst charConst) { 
		charConst.struct = Tab.charType;
		constant = charConst.getC1();
	}
	
	@Override
	public void visit(Type type) {
		currentType = Tab.noType;
		Obj typeObj = Tab.find(type.getI1()); //IDENT
		if(typeObj.equals(Tab.noObj)) { //gresniCvor
			report_error("...", type);
			//currentType = Tab.noType;
		} 
		else if(typeObj.getKind() != Obj.Type) { //vec postoji
			report_error("...", type);
			//currentType = Tab.noType;
		} 
		else {
			currentType = typeObj.getType(); //Od objektnog dohvati mi njegov strukturni
			type.struct = currentType; //4faza
			nazivTipa = typeObj.getName();
		}
		type.struct = currentType;
	}
    

	/*@Override
	public void visit(ConstDeclList constDeclList) {
		if(constDeclList.getConstDec().getConst().struct != currentType) {
			report_error("Los tip konstante", constDeclList);
		}
		else if(Tab.find(constDeclList.getConstDec().getI1()) != Tab.noObj) {
			report_error("Konstanta vec postoji", constDeclList);
		}
		else {
	 	//chck
		Code.load(fct.getDes().obj); //addr
		Code.put(Code.load_1);  //i
		Code.put(Code.aload);
		Code.put(Code.load_2);  // 3_
		
		Code.put(Code.jcc + Code.le);
		int ifskok  = Code.pc;
		Code.put2(0);
		}
	}*/
	
	@Override
	public void visit(VarName varName) {
		currentVar = varName.getI1();
		if(Tab.currentScope.findSymbol(currentVar) != null) {
			report_error("GRESKA: Simbol vec postoji " + currentVar, varName);
		}
	}
	
	@Override
	public void visit(Array_Yes array_Yes) {
		Tab.insert(Obj.Var, currentVar, new Struct(Struct.Array, currentType));
	}
	
	@Override
	public void visit(Array_No array_No) {
		Tab.insert(Obj.Var, currentVar, currentType);
	}
	
	@Override
	public void visit(RecDeclName recDeclName) {
		currentRecord = Tab.insert(Obj.Prog, recDeclName.getI1(), new Struct(Obj.Fld));/*Tab.noType*/
		if(Tab.currentScope.findSymbol(currentVar) != null) {
			report_error("GRESKA: Simbol vec postoji " + currentVar, recDeclName);
		}
		Tab.openScope(); //Otvaram Scope Recorda
	}
	
	/*@Override
	public void visit(VarDeclListRec VarDeclListRec) {
		//ne ovde
		int beginWhilePc = Code.pc;
		Code.put(Code.load_1); //i
		Code.put(Code.load_3); //len 2_
		Code.put(Code.jcc + Code.ge);
		int jumpAdressPc  = Code.pc;
		Code.put2(0);
	}*/
	
	@Override
	public void visit(RecDecl RecDecl) {
		Tab.chainLocalSymbols(currentRecord);
		Tab.closeScope(); //Zatvaram Scope Recorda
	}
	
	@Override
	public void visit(MethName methName) {
		labelsHappened.clear();
		labelsToGoTo.clear();
		
		String name = methName.getI1();
		if (Tab.find(name) != Tab.noObj) {
			report_error("GRESKA: Metod vec postoji " + name, methName);
			methName.obj = Tab.noObj; //4faza
		}
		currentMeth = Tab.insert(Obj.Meth, name, currentType);
		methName.obj = currentMeth; //4faza
		
		Tab.openScope(); //Otvaram Scope Metode
		
		if(name.equals("main")) {
			mainFlag = true;
			if(currentType != Tab.noType) {
				report_error("GRESKA: Main mora biti tipa VOID" + ", ovde je tip: " + nazivTipa, methName);
				methName.obj = Tab.noObj; //4faza
			}
		}
	}
	
	@Override
	public void visit(MethodDecl methodDecl) {
		if(currentMeth.getType() != Tab.noType && (!returnFlag)) {
			report_error("GRESKA: Return metode nije pronadjen", methodDecl);
		}
		Tab.chainLocalSymbols(currentMeth); //Chainujem Scope Metode
		Tab.closeScope(); //Zatvaram Scope Metode
		currentMeth = null;
		returnFlag = false;
		
		//Labele checker:
		boolean lblFound = false;
		for(String l1: labelsToGoTo) {
			for(String l2: labelsHappened) {
				if(l1.equals(l2)) {
					lblFound = true; //postoji label za goto
				}
			}
			if(lblFound == false) {
				report_error("GRESKA: Ne postoji labela za goto " + l1 + ", u metodi " + methodDecl.getMethName().getI1(), methodDecl);
			}
			lblFound = false;
		}
	}
	
	@Override
	public void visit(FormPars formPars) {
		if(currentMeth.getName().equals("main")) {
			report_error("GRESKA: Main ne sme imati parametre", formPars);
		}
	}
	
    @Override
    public void visit(TypeOrVoidName_Void typeOrVoidName_Void) {
    	currentType = Tab.noType;
    }
	
    @Override
    public void visit(DesignatorName1 designatorName1) {
    	Obj des = Tab.find(designatorName1.getI1());
    	if(des == Tab.noObj) {
    		report_error("GRESKA: Nije definisan simbol ", designatorName1);
    		designatorName1.obj  = Tab.noObj;
    	}
    	else if(des.getKind() != Obj.Var && des.getKind() != Obj.Con && des.getKind() != Obj.Meth) {
    		report_error("GRESKA: Nevalidna promenljiva ", designatorName1);
    		designatorName1.obj  = Tab.noObj;
    	}
    	else {
    		designatorName1.obj = des;
    		report_info("Koriscenje simbola: " + designatorName1.getI1(), designatorName1);
    	}
    }
    
	@Override
	public void visit(DesignatorName2 designatorName2) {
		
		if(designatorName2.getDesignatorArrayName().obj == Tab.noObj) {
			designatorName2.obj = Tab.noObj;
		}
		else if(!designatorName2.getExpr().struct.equals(Tab.intType)) {
			report_error("GRESKA: Expr za indeksiranje niza mora biti tipa - Int", designatorName2);
			designatorName2.obj = Tab.noObj;
		}
		else {
			designatorName2.obj = new Obj(Obj.Elem, designatorName2.getDesignatorArrayName().obj.getName() + "[num]", designatorName2.getDesignatorArrayName().obj.getType().getElemType());
			report_info("Pristup elementu niza: " + designatorName2.getDesignatorArrayName().getI1(), designatorName2);
		}
	}
   
	@Override
	public void visit(DesignatorArrayName designatorArrayName) {
		Obj arrVar = Tab.find(designatorArrayName.getI1());
		if(arrVar.equals(Tab.noObj)) {
			report_error("GRESKA: Niz nije deklarisan " +designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		}
		else if(arrVar.getKind() == Obj.Var && arrVar.getType().getKind() == Struct.Array){
			designatorArrayName.obj = arrVar;
		}
		else {
			report_error("GRESKA: Nevalidna promenljiva niza " +designatorArrayName.getI1(), designatorArrayName);
			designatorArrayName.obj = Tab.noObj;
		}
	}
    
    @Override
    public void visit(AddOpTermListRec_Yes addOpTermListRec_Yes) {
   
    	Struct r = addOpTermListRec_Yes.getTerm().struct;
    	Struct l = addOpTermListRec_Yes.getAddOpTermListRec().struct;
    	if(r != Tab.intType || l != Tab.intType) {
    		addOpTermListRec_Yes.struct = Tab.noType;
    		report_error("GRESKA: Operand za AddOp nije Int", addOpTermListRec_Yes);
    	}
    	else {
    		addOpTermListRec_Yes.struct = Tab.intType;
    		
    	}
    	
    }
    
    @Override
    public void visit(AddOpTermListRec_Firt addOpTermListRec_Firt) {
    	addOpTermListRec_Firt.struct = addOpTermListRec_Firt.getTerm().struct;
    }
    
    @Override
    public void visit(FactorMulopListRec_Yes factorMulopListRec_Yes) {
    	
    	Struct r = factorMulopListRec_Yes.getFactor().struct;
    	Struct l = factorMulopListRec_Yes.getFactorMulopListRec().struct;
    	if(r != Tab.intType || l != Tab.intType) {
    		factorMulopListRec_Yes.struct = Tab.noType;
    		report_error("GRESKA: Operand za MulOp nije Int", factorMulopListRec_Yes);
    	}
    	else  {
    		factorMulopListRec_Yes.struct = Tab.intType;
    		
    	}
    }
    
    @Override
    public void visit(FactorMulopListRec_First factorMulopListRec_First) {
    	factorMulopListRec_First.struct = factorMulopListRec_First.getFactor().struct;
    }
	
	@Override
	public void visit(Factor_DesignatorVar factor_DesignatorVar) {
		if(factor_DesignatorVar.getDesignator().obj == Tab.noObj) {
			factor_DesignatorVar.struct = Tab.noType;
		}
		else if (factor_DesignatorVar.getDesignator().obj.getKind() == Obj.Meth) {
			report_error("GRESKA: Neadekvatno koriscenje metode " + factor_DesignatorVar.getDesignator().obj.getName(), factor_DesignatorVar);
			factor_DesignatorVar.struct = Tab.noType;
		}
		else
			factor_DesignatorVar.struct = factor_DesignatorVar.getDesignator().obj.getType();
	}
	
	@Override
	public void visit(Factor_DesignatorMeth factor_DesignatorMeth) {
		report_error("GRESKA: neadekvatan izraz (nivo B) [Factor_DesignatorMeth]", factor_DesignatorMeth);
		if(factor_DesignatorMeth.getDesignator().obj == Tab.noObj) {
			factor_DesignatorMeth.struct = Tab.noType;
		}
		else if (factor_DesignatorMeth.getDesignator().obj.getKind() != Obj.Meth) {
			report_error("GRESKA: Neadekvatno koriscenje promenljive " + factor_DesignatorMeth.getDesignator().obj.getName(), factor_DesignatorMeth);
			factor_DesignatorMeth.struct = Tab.noType;
		}
		else
			factor_DesignatorMeth.struct = factor_DesignatorMeth.getDesignator().obj.getType();
	}
	
	@Override
	public void visit(DesignatorStat_ActPars designatorStat_ActPars) {
		report_error("GRESKA: neadekvatan izraz (nivo B) [DesignatorStat_ActPars]", designatorStat_ActPars);
		
		if (designatorStat_ActPars.getDesignator().obj.getKind() != Obj.Meth) {
			report_error("GRESKA: Neadekvatno koriscenje promenljive " + designatorStat_ActPars.getDesignator().obj.getName(), designatorStat_ActPars);
			
		}
		
	}
	
	@Override
	public void visit(DesignatorStat_Inc designatorStat_Inc) {
		int desKind = designatorStat_Inc.getDesignator().obj.getKind();
		if(desKind == Obj.Var || desKind == Obj.Elem) {
			if(designatorStat_Inc.getDesignator().obj.getType().equals(Tab.intType))
				report_info("Adekvatno inkrementiranje", designatorStat_Inc);
			else
				report_error("GRESKA: Promenljiva koja se inkrementira nije Int", designatorStat_Inc);
		}
		else
			report_error("GRESKA: Neadekvatna promenljiva pri inkrementiranju", designatorStat_Inc);
	}
	
	@Override
	public void visit(DesignatorStat_Dec designatorStat_Dec) {
		int desKind = designatorStat_Dec.getDesignator().obj.getKind();
		if(desKind == Obj.Var || desKind == Obj.Elem) {
			if(designatorStat_Dec.getDesignator().obj.getType().equals(Tab.intType))
				report_info("Adekvatno dekrementiranje", designatorStat_Dec);
			else
				report_error("GRESKA: Promenljiva koja se dekrementira nije Int", designatorStat_Dec);
		}
		else
			report_error("GRESKA: Neadekvatna promenljiva pri dekrementiranju", designatorStat_Dec);
	}
	
	
	
	@Override
	public void visit(Factor_Num factor_Num) {
		factor_Num.struct = Tab.intType;
	}
	
	@Override
	public void visit(Factor_Char factor_Char) {
		factor_Char.struct = Tab.charType;
	}
	
	@Override
	public void visit(Factor_Bool factor_Bool) {
		factor_Bool.struct = Tab.find("bool").getType();
	}
	
	@Override
	public void visit(Factor_NewArray factor_NewArray) {
		if(factor_NewArray.getExpr().struct.equals(Tab.intType)) {
			factor_NewArray.struct = new Struct(Struct.Array, currentType);
		}
		else {
			report_error("GRESKA: Nevalidno kreiranje niza", factor_NewArray);
			factor_NewArray.struct = Tab.noType;
		}
	}
	
	@Override
	public void visit(Factor_NewRecObj factor_NewRecObj) {
		report_error("GRESKA: nedozvoljen izraz (nivo B) [Factor_NewRecObj]", factor_NewRecObj);
	}
	
	@Override
	public void visit(Factor_Expr factor_Expr) {
		factor_Expr.struct = factor_Expr.getExpr().struct;
	}
	
	@Override
	public void visit(CondFactExprRelop condFactExprRelop) {
		Struct r = condFactExprRelop.getExpr1().struct;
		Struct l = condFactExprRelop.getExpr().struct;
		if(l.compatibleWith(r)) {
			if((r.getKind() == Struct.Array) && (l.getKind() == Struct.Array)) {
				//int operation = condFactExprRelop.getRelOp().obj.Fld;
				
			}
		} else {
			report_error("GRESKA: Operandi nisu kompatibilni", condFactExprRelop);
		}
	}
	
	@Override
	public void visit(CondFactExpr condFactExpr) {
		if(condFactExpr.getExpr().struct != Tab.find("bool").getType()) {
			report_error("GRESKA: Condition nije tipa bool", condFactExpr);
		}
	}
	
	@Override
	public void visit(SingleStatement_DoWhile singleStatement_DoWhile) {
		report_error("GRESKA: nedozvoljen izraz (nivo B) [SingleStatement_DoWhile]", singleStatement_DoWhile);
		if(singleStatement_DoWhile.getCondition().struct != Tab.find("bool").getType()) {
			report_error("GRESKA: Condition nije tipa bool", singleStatement_DoWhile);
		}
	}
	
	@Override
	public void visit(ActPar actPar) {
		ActParsList.add(actPar.getExpr().struct);
	}
	
	@Override
	public void visit(SingleStatement_Return singleStatement_Return) {
		returnFlag = true;
		if(currentMeth.getType() != Tab.noType) {
			report_error("GRESKA: Meth tipa VOID ne sme imati ReturnValue", singleStatement_Return);
		}
	}
	
	
	
	@Override
	public void visit(SingleStatement_Read singleStatement_Read) {
		int kind = singleStatement_Read.getDesignator().obj.getKind();
		Struct type = singleStatement_Read.getDesignator().obj.getType();
		if(!(kind != Obj.Var && kind != Obj.Elem)) {
			if(type != Tab.find("bool").getType() && type != Tab.charType && type != Tab.intType) {
				report_error("GRESKA: Read prihvata samo bool, char i int", singleStatement_Read);
			}
		} else {
			report_error("GRESKA: Read prihvata promenljivu ili niz", singleStatement_Read);
		}
	}
	
	@Override
	public void visit(SingleStatement_Print singleStatement_Print) {
		//int kind = singleStatement_Print.getExpr().struct.getKind();
		Struct type = singleStatement_Print.getExpr().struct;
		if(type != Tab.find("bool").getType() && type != Tab.charType && type != Tab.intType) {
			report_error("GRESKA: Print prihvata samo bool, char i int", singleStatement_Print);
		}
	}
	
	@Override
	public void visit(Factor factor) {
		if(factor.getMayMinus() instanceof MayMinus_Yes) {
			if(factor.getFactorSub().struct.equals(Tab.intType))
				factor.struct = Tab.intType;
			else {
				report_error("GRESKA: Negacija necega sto nije Int", factor);
				factor.struct = Tab.noType;
			}
		}
		else
			factor.struct = factor.getFactorSub().struct;
	}
	
	@Override
	public void visit(Term term) {
		term.struct = term.getFactorMulopListRec().struct;
	}
	
	@Override
	public void visit(Expr expr) {
		expr.struct = expr.getAddOpTermListRec().struct;
	}
	
	@Override
	public void visit(DesignatorStat_AssignExpr des) {
		Struct l = des.getDesignator().obj.getType();
		Struct r = des.getExpr().struct;
		
		if(r.assignableTo(l)) {
			if(des.getDesignator().obj.getKind() == Obj.Var || des.getDesignator().obj.getKind() == Obj.Elem) {
				report_info("Adekvatna dodela", des);
			}
				
			else {
				report_error("GRESKA: Sa leve strane mora biti el niza ili promenljiva", des);
			}
		} else 
			report_error("GRESKA: Neadekvatna dodela", des);
		
	}
	
	
	
	
	@Override
	public void visit(SingleStatement_IfElse singleStatement_IfElse) {
		report_error("GRESKA: nedozvoljen izraz (nivo B) [SingleStatement_IfElse]", singleStatement_IfElse);
	}
	
	@Override
	public void visit(SingleStatement_Break singleStatement_Break) {
		report_error("GRESKA: nedozvoljen izraz (nivo B) [SingleStatement_Break]", singleStatement_Break);
	}
	
	@Override
	public void visit(SingleStatement_Continue singleStatement_Continue) {
		report_error("GRESKA: nedozvoljen izraz (nivo B) [SingleStatement_Continue]", singleStatement_Continue);
	}
	
	@Override
	public void visit(SingleStatement_ReturnExpr singleStatement_ReturnExpr) {
		report_error("GRESKA: nedozvoljen izraz (nivo B) [SingleStatement_ReturnExpr]", singleStatement_ReturnExpr);
//		returnFlag = true;
//		if(currentMeth.getType() != Tab.noType) {
//			boolean compatible = currentMeth.getType().equals(singleStatement_ReturnExpr.getExpr().struct);
//			if(compatible == false) {
//				report_error("Povratni tip metode i tip iz return nisu uskladjeni", singleStatement_ReturnExpr);
//			}
//		} else {
//			report_error("Return niste stavili u metodu", singleStatement_ReturnExpr);
//		}
	}
	
	@Override
	public void visit(Label label) {
		//String labelName = label.getI1();
	}
	
	@Override
	public void visit(StatementSingleLabel statementSingleLabel) { //label:
		String lblName = statementSingleLabel.getLabel().getI1();
		/*if (Tab.find(lblName) != Tab.noObj) {
			report_error("Label vec postoji " + lblName, statementSingleLabel);
		} else {
			Tab.insert(constant, lblName, currentType);
		}*/
		if(labelsHappened.contains(lblName)) {
			report_error("GRESKA: U metodi vec postoji Label pod nazivom " + lblName, statementSingleLabel);
		} else {
			labelsHappened.add(lblName);
		}
	}
	
	@Override
	public void visit(SingleStatement_GoTo singleStatement_GoTo) { //go to label
		labelsToGoTo.add(singleStatement_GoTo.getLabel().getI1());
	}
	
	@Override
	public void visit(VarDec varDec) {
		if(varDec.getMayArray() instanceof Array_Yes) {
			report_info("Deklarisan niz: " + varDec.getVarName().getI1(), varDec);
		} else {
			report_info("Deklarisana promenljiva: " + varDec.getVarName().getI1(), varDec);
		}
	}
	
	
	//if(designatorStat_C.getDesignator().obj.getType().getKind() != Struct.Array) //nije Array designator
	//if(factor_H.getDesignator().obj.getKind() != Obj.Var) //nije Promenljiva
	//if(singleStatement_Print.getExpr().struct.getKind() == Struct.Array)
	
	//hm.containsKey(key); hm.get(key)-val returnuje; hm.put(key, val);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//5 - int; 1 - char sirina ispisa
	//java -cp lib/mj-runtime-1.1.jar rs.etf.pp1.mj.runtime.Run test/program.obj
	//Code.error("GRESKA:");
	
	
}
