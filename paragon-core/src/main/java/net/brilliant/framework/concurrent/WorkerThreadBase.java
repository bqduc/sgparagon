/**
 * 
 */
package net.brilliant.framework.concurrent;

import java.util.concurrent.Callable;

import net.brilliant.framework.component.CompCore;
import net.brilliant.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
public abstract class WorkerThreadBase extends CompCore implements Callable<ExecutionContext> {
	private static final long serialVersionUID = -1054379747356010375L;

	private ExecutionContext executionContext;

  protected WorkerThreadBase(ExecutionContext executionContext) {
      this.executionContext = ExecutionContext.builder().build();
      this.executionContext.putAll(executionContext);
  }

	@Override
	public ExecutionContext call() throws Exception {
		return perform();
	}

	protected ExecutionContext perform() {
		throw new RuntimeException("Not implemented yet!");
		//return this.executionContext;
	}
}
