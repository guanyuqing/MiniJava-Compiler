//
// Generated by JTB 1.3.2
//

package piglet.syntaxtree;

import piglet.RuntimeError;

/**
 * Grammar production:
 * f0 -> "HSTORE"
 * f1 -> Exp()
 * f2 -> IntegerLiteral()
 * f3 -> Exp()
 */
public class HStoreStmt implements Node {
   public NodeToken f0;
   public Exp f1;
   public IntegerLiteral f2;
   public Exp f3;

   public HStoreStmt(NodeToken n0, Exp n1, IntegerLiteral n2, Exp n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public HStoreStmt(Exp n0, IntegerLiteral n1, Exp n2) {
      f0 = new NodeToken("HSTORE");
      f1 = n0;
      f2 = n1;
      f3 = n2;
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

