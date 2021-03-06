//
// Generated by JTB 1.3.2
//

package piglet.visitor;
import piglet.RuntimeError;
import piglet.syntaxtree.BinOp;
import piglet.syntaxtree.CJumpStmt;
import piglet.syntaxtree.Call;
import piglet.syntaxtree.ErrorStmt;
import piglet.syntaxtree.Exp;
import piglet.syntaxtree.Goal;
import piglet.syntaxtree.HAllocate;
import piglet.syntaxtree.HLoadStmt;
import piglet.syntaxtree.HStoreStmt;
import piglet.syntaxtree.IntegerLiteral;
import piglet.syntaxtree.JumpStmt;
import piglet.syntaxtree.Label;
import piglet.syntaxtree.MoveStmt;
import piglet.syntaxtree.NoOpStmt;
import piglet.syntaxtree.NodeList;
import piglet.syntaxtree.NodeListOptional;
import piglet.syntaxtree.NodeOptional;
import piglet.syntaxtree.NodeSequence;
import piglet.syntaxtree.NodeToken;
import piglet.syntaxtree.Operator;
import piglet.syntaxtree.PrintStmt;
import piglet.syntaxtree.Procedure;
import piglet.syntaxtree.Stmt;
import piglet.syntaxtree.StmtExp;
import piglet.syntaxtree.StmtList;
import piglet.syntaxtree.Temp;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu) throws RuntimeError;
   public R visit(NodeListOptional n, A argu) throws RuntimeError;
   public R visit(NodeOptional n, A argu) throws RuntimeError;
   public R visit(NodeSequence n, A argu) throws RuntimeError;
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> "MAIN"
    * f1 -> StmtList()
    * f2 -> "END"
    * f3 -> ( Procedure() )*
    * f4 -> <EOF>
 * @throws RuntimeError 
    */
   public R visit(Goal n, A argu) throws RuntimeError;

   /**
    * f0 -> ( ( Label() )? Stmt() )
 * @throws RuntimeError *
    */
   public R visit(StmtList n, A argu) throws RuntimeError;

   /**
    * f0 -> Label()
    * f1 -> "["
    * f2 -> IntegerLiteral()
    * f3 -> "]"
    * f4 -> StmtExp()
 * @throws RuntimeError 
    */
   public R visit(Procedure n, A argu) throws RuntimeError;

   /**
    * f0 -> NoOpStmt()
    *       | ErrorStmt()
    *       | CJumpStmt()
    *       | JumpStmt()
    *       | HStoreStmt()
    *       | HLoadStmt()
    *       | MoveStmt()
    *       | PrintStmt()
 * @throws RuntimeError 
    */
   public R visit(Stmt n, A argu) throws RuntimeError;

   /**
    * f0 -> "NOOP"
    */
   public R visit(NoOpStmt n, A argu);

   /**
    * f0 -> "ERROR"
 * @throws RuntimeError 
    */
   public R visit(ErrorStmt n, A argu) throws RuntimeError;

   /**
    * f0 -> "CJUMP"
    * f1 -> Exp()
    * f2 -> Label()
 * @throws RuntimeError 
    */
   public R visit(CJumpStmt n, A argu) throws RuntimeError;

   /**
    * f0 -> "JUMP"
    * f1 -> Label()
 * @throws RuntimeError 
    */
   public R visit(JumpStmt n, A argu) throws RuntimeError;

   /**
    * f0 -> "HSTORE"
    * f1 -> Exp()
    * f2 -> IntegerLiteral()
    * f3 -> Exp()
 * @throws RuntimeError 
    */
   public R visit(HStoreStmt n, A argu) throws RuntimeError;

   /**
    * f0 -> "HLOAD"
    * f1 -> Temp()
    * f2 -> Exp()
    * f3 -> IntegerLiteral()
 * @throws RuntimeError 
    */
   public R visit(HLoadStmt n, A argu) throws RuntimeError;

   /**
    * f0 -> "MOVE"
    * f1 -> Temp()
    * f2 -> Exp()
 * @throws RuntimeError 
    */
   public R visit(MoveStmt n, A argu) throws RuntimeError;

   /**
    * f0 -> "PRINT"
    * f1 -> Exp()
 * @throws RuntimeError 
    */
   public R visit(PrintStmt n, A argu) throws RuntimeError;

   /**
    * f0 -> StmtExp()
    *       | Call()
    *       | HAllocate()
    *       | BinOp()
    *       | Temp()
    *       | IntegerLiteral()
    *       | Label()
 * @throws RuntimeError 
    */
   public R visit(Exp n, A argu) throws RuntimeError;

   /**
    * f0 -> "BEGIN"
    * f1 -> StmtList()
    * f2 -> "RETURN"
    * f3 -> Exp()
    * f4 -> "END"
 * @throws RuntimeError 
    */
   public R visit(StmtExp n, A argu) throws RuntimeError;

   /**
    * f0 -> "CALL"
    * f1 -> Exp()
    * f2 -> "("
    * f3 -> ( Exp() )*
    * f4 -> ")"
 * @throws RuntimeError 
    */
   public R visit(Call n, A argu) throws RuntimeError;

   /**
    * f0 -> "HALLOCATE"
    * f1 -> Exp()
 * @throws RuntimeError 
    */
   public R visit(HAllocate n, A argu) throws RuntimeError;

   /**
    * f0 -> Operator()
    * f1 -> Exp()
    * f2 -> Exp()
 * @throws RuntimeError 
    */
   public R visit(BinOp n, A argu) throws RuntimeError;

   /**
    * f0 -> "LT"
    *       | "PLUS"
    *       | "MINUS"
    *       | "TIMES"
 * @throws RuntimeError 
    */
   public R visit(Operator n, A argu) throws RuntimeError;

   /**
    * f0 -> "TEMP"
    * f1 -> IntegerLiteral()
    */
   public R visit(Temp n, A argu);

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Label n, A argu);

}
