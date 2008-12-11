package org.meta_environment.rascal.interpreter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.imp.pdb.facts.type.NamedTreeType;
import org.eclipse.imp.pdb.facts.type.NamedType;
import org.eclipse.imp.pdb.facts.type.ParameterType;
import org.eclipse.imp.pdb.facts.type.TreeNodeType;
import org.eclipse.imp.pdb.facts.type.TupleType;
import org.eclipse.imp.pdb.facts.type.Type;
import org.meta_environment.rascal.ast.FunctionDeclaration;
import org.meta_environment.rascal.ast.Name;
import org.meta_environment.rascal.ast.QualifiedName;

/**
 * An environment that implements the scoping rules of Rascal.
 * 
 */
public class EnvironmentStack implements IEnvironment {
	protected final Stack<IEnvironment> stack = new Stack<IEnvironment>();
    
	public EnvironmentStack(IEnvironment bottom) {
		stack.push(bottom);
	}
	
	public boolean isRootEnvironment() {
		return false;
	}
	
	public void pushFrame() {
		stack.push(new Environment());
	}
	
	public void push(IEnvironment e) {
		if (e == null) { 
			throw new RascalBug("Empty environment");
		}
		stack.push(e);
	}

	public void popFrame() {
		stack.pop();
	}
	
	public void pop() {
		stack.pop();
	}

	protected IEnvironment bottom() {
		return stack.get(0);
	}
	
	protected IEnvironment top() {
		return stack.peek();
	}
	
	public void storeFunction(String name, FunctionDeclaration function) {
		TupleType formals = (TupleType) function.getSignature().accept(TypeEvaluator.getInstance());
		
		getFunctionDefiningEnvironment(name, formals).storeFunction(name, function);
	}

	public void storeVariable(String name, EvalResult value) {
		getVariableDefiningEnvironment(name).storeVariable(name, value);
	}
	
	public IEnvironment getRootEnvironment() {
		for (int i = stack.size() - 1; i >= 0; i--) {
			IEnvironment env = stack.get(i);
			if (env.isRootEnvironment()) {
				return env;
			}
		}
		
		return bottom();
	}

	public IEnvironment getFunctionDefiningEnvironment(Name name, TupleType formals) {
		return getFunctionDefiningEnvironment(Names.name(name), formals);
	}
	
	public IEnvironment getFunctionDefiningEnvironment(String name, TupleType formals) {
		int i;
		
		for (i = stack.size() - 1; i >= 0; i--) {
			IEnvironment env = stack.get(i);
			
			if (env.isRootEnvironment()
					|| env.getFunction(name, formals) != null) {
				return env;
			}
		}
		
		return top();
	}
	
	public IEnvironment getVariableDefiningEnvironment(String name) {
		int i;
		
		for (i = stack.size() - 1; i >= 0; i--) {
			IEnvironment env = stack.get(i);
			
            if (env.isRootEnvironment() || env.getVariable(name) != null) {
            	return env;
            }
		}
		
		return top();
	}

	public Map<ParameterType, Type> getTypes() {
		Map<ParameterType,Type> types = new HashMap<ParameterType,Type>();
		
		for (int i = 0; i < stack.size(); i++) {
			IEnvironment environment = stack.get(i);
			types.putAll(environment.getTypes());
		}
		
		// result can not be given to a match
		return Collections.unmodifiableMap(types);
	}

	public void storeType(ParameterType par, Type type) {
		// types have module scope
		bottom().storeType(par, type);
	}
	
	public void storeTypes(Map<ParameterType, Type> bindings) {
		// types have module scope
		bottom().storeTypes(bindings);
	}

	public FunctionDeclaration getFunction(Name name, TupleType actuals) {
		return getFunction(Names.name(name), actuals);
	}
	
	public FunctionDeclaration getFunction(String name, TupleType actuals) {
		IEnvironment env = getFunctionDefiningEnvironment(name, actuals);
		return env.getFunction(name, actuals);
	}

	public Type getType(ParameterType par) {
		return bottom().getType(par);
	}

	public EvalResult getVariable(String name) {
		IEnvironment env = getVariableDefiningEnvironment(name);
		return env.getVariable(name);
	}

	public void storeType(NamedType decl) {
		bottom().storeType(decl);
	}

	public void storeType(NamedTreeType decl) {
		bottom().storeType(decl);
	}

	public void storeType(TreeNodeType decl) {
		bottom().storeType(decl);
	}

	public FunctionDeclaration getFunction(QualifiedName name, TupleType actuals) {
		return getFunction(Names.lastName(name), actuals);
	}

	public EvalResult getVariable(QualifiedName name) {
		return getVariable(Names.lastName(name));
	}

	public void storeFunction(QualifiedName name, FunctionDeclaration function) {
		storeFunction(Names.lastName(name), function);
		
	}

	public void storeVariable(QualifiedName name, EvalResult value) {
		storeVariable(Names.lastName(name), value);
	}

	public EvalResult getVariable(Name name) {
		return getVariable(Names.name(name));
	}

	public void storeFunction(Name name, FunctionDeclaration function) {
		storeFunction(Names.name(name), function);
		
	}

	public void storeVariable(Name name, EvalResult value) {
		storeVariable(Names.name(name), value);
		
	}
}
