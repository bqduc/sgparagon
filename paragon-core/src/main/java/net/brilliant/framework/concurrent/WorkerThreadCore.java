/**
 * 
 */
package net.brilliant.framework.concurrent;

import net.brilliant.framework.component.CompCore;
import net.brilliant.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
public abstract class WorkerThreadCore extends CompCore implements Runnable {
	private static final long serialVersionUID = -2857158059074111900L;

	protected ExecutionContext executionContext;

	public WorkerThreadCore(ExecutionContext executionContext) {
		this.executionContext = ExecutionContext.builder().build();
		this.executionContext.putAll(executionContext);
	}

	@Override
	public void run() {
		perform();
	}

	protected abstract void perform();
}
