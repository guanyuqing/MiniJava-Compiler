//
// Generated by JTB 1.3.2
//

package piglet.syntaxtree;

import piglet.RuntimeError;

/**
 * Grammar production:
 * f0 -> "BEGIN"
 * f1 -> StmtList()
 * f2 -> "RETURN"
 * f3 -> Exp()
 * f4 -> "END"
 */
public class StmtExp implements Node {
   public NodeToken f0;
   public StmtList f1;
   public NodeToken f2;
   public Exp f3;
   public NodeToken f4;

   public StmtExp(NodeToken n0, StmtList n1, NodeToken n2, Exp n3, NodeToken n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public StmtExp(StmtList n0, Exp n1) {
      f0 = new NodeToken("BEGIN");
      f1 = n0;
      f2 = new NodeToken("RETURN");
      f3 = n1;
      f4 = new NodeToken("END");
   }

   public void accept(piglet.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(piglet.visitor.GJVisitor<R,A> v, A argu) throws RuntimeError {
      return v.visit(this,argu);
   }
   public <R> R accept(piglet.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(piglet.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

