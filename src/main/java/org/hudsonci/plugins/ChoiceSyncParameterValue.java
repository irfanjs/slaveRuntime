package org.hudsonci.plugins;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.model.Hudson;
import hudson.model.ParameterValue;
import hudson.model.Slave;

public class ChoiceSyncParameterValue extends ParameterValue {

	private Slave slaveNode;
	
	@DataBoundConstructor
	public ChoiceSyncParameterValue(String name, String slave) {
		super(name);
		if (!"master".equals(slave)) {
			this.slaveNode = Hudson.getInstance().getSlave(slave);
			System.out.println("Selecting " + this.slaveNode.getDisplayName() + " node.");
		} else {
			System.out.println("Selecting master node.");
		}
	}
}
