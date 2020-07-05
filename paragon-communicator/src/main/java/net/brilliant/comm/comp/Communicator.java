/**
 * 
 */
package net.brilliant.comm.comp;

import net.brilliant.comm.domain.CorpMimeMessage;
import net.brilliant.exceptions.CommunicatorException;
import net.brilliant.model.ExecutionContext;

/**
 * @author ducbq
 *
 */
public interface Communicator {
	void sendEmail(CorpMimeMessage mailMessage) throws CommunicatorException;
	void send(ExecutionContext context) throws CommunicatorException;
}
