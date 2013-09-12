/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.nebula.widgets.nattable.print.action;


import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.print.command.PrintCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOffCommand;
import org.eclipse.nebula.widgets.nattable.print.command.TurnViewportOnCommand;
import org.eclipse.nebula.widgets.nattable.summaryrow.command.CalculateSummaryRowValuesCommand;
import org.eclipse.nebula.widgets.nattable.ui.action.IKeyAction;
import org.eclipse.swt.events.KeyEvent;

public class PrintAction implements IKeyAction {

	@Override
	public void run(NatTable natTable, KeyEvent event) {
		natTable.doCommand(new TurnViewportOffCommand());
		
		//if a SummaryRowLayer is in the layer stack, we need to ensure that the values are calculated
		natTable.doCommand(new CalculateSummaryRowValuesCommand());
		
		natTable.doCommand(new PrintCommand(natTable.getConfigRegistry(), natTable.getShell()));
		
		natTable.doCommand(new TurnViewportOnCommand());
	}

}
