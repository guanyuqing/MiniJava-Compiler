package minijava.symboltable;import java.io.PrintStream;import java.util.Collections;import java.util.HashSet;import java.util.Hashtable;import java.util.Vector;import minijava.typecheck.TypeError;public class MClassList extends MType//总符号表类{	private Hashtable<String, MClass> classList = new Hashtable<String, MClass>();//类列表		private Vector<TypeError> errList = new Vector<TypeError>();//类型错误表		public MClassList()//预先插入基本类型	{		classList.put("int", new MBasicType("int"));		classList.put("int[]", new MBasicType("int[]"));		classList.put("boolean", new MBasicType("boolean"));	}		public boolean insert(MClass newClass, int nLine)//插入新类	{		String szNewClass = newClass.getName();		if (classList.containsKey(szNewClass))//如果有重复		{			szNewClass += "repeated " + nLine;			classList.put(szNewClass, newClass);//仍然插入，以便进入此类进行类型检查			return false;		}				classList.put(szNewClass, newClass);		return true;	}		public MClass get(String szName)//直接获取类	{		return classList.get(szName);	}		public MClass get(String szName, int nLine)//在类定义处获取类，考虑重复定义的情况	{		MClass newClass =  classList.get(szName + "repeated " + nLine);		if (newClass != null) return newClass;		else return classList.get(szName);//非重复定义	}		public boolean contains(String szName)//包含某类	{		return classList.containsKey(szName);	}		public boolean classEqualsOrDerives(String szBase, String szExt)//szBase是否等价于szExt或者是szExt基类	{		if (szBase == null) return szExt == null;//都为null		else		{			if (szExt == null) return false;			if (szExt.equals(szBase)) return true;//两者等价			if (!classList.containsKey(szExt)) return false;//无szExt类						MClass extClass = classList.get(szExt);			MClass currentClass = extClass;						String szCurrentBase = extClass.getBase();						while (szCurrentBase != null && !szCurrentBase.equals(szExt))//有基类且未循环继承			{				currentClass = classList.get(szCurrentBase);								if (currentClass == null) return false;				if (currentClass.szName.equals(szBase)) return true;//找到基类								szCurrentBase = currentClass.getBase();			}						return false;		}	}		public void addError(TypeError e)//添加类型错误	{		errList.add(e);	}		public void printErrors(PrintStream ps)//输出所有错误	{		Collections.sort(errList);//先按行号排序				for (TypeError e : errList) ps.println(e);//打印各错误		ps.println(errList.size() + " type error found.");//总共个数	}		public boolean hasTypeErrors() { return errList.size() > 0; }//是否有错		public String toString()//输出层次结构	{		String szTemp = "";				for (MClass _class : classList.values())//输出各类		{			if (!(_class instanceof MBasicType)) szTemp += _class;		}				return szTemp;	}		public int alloc(int nTemp)//分配内存偏移值，设置各方法Piglet下名称，分配局部变量TEMP值	{		HashSet<String> methodPigletNames = new HashSet<String>();		for (MClass _class : classList.values())		{			nTemp = _class.alloc(nTemp, methodPigletNames);//依次对各类进行分配		}		return nTemp;	}}