package org.hudsonci.plugins;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.DescriptorExtensionList;
import hudson.Extension;
import hudson.model.ParameterValue;
import hudson.model.BooleanParameterDefinition;
import hudson.model.ChoiceParameterDefinition;
import hudson.model.Descriptor;
import hudson.model.Hudson;
import hudson.model.ParameterDefinition;
import hudson.model.Slave;
import hudson.model.StringParameterDefinition;
import hudson.model.StringParameterValue;

public class ChoiceSyncOptions extends ChoiceParameterDefinition {
	private static String[] ss;

	private String name;
	@DataBoundConstructor
	public ChoiceSyncOptions(String name) {
		super("Choices", new String[]{name}, "desc");
		this.name = name;
	}
	
    @Override
    public ParameterValue createValue(StaplerRequest req, JSONObject json) {
    	System.err.println("createvalue: " + name);
        ChoiceSyncParameterValue value = req.bindJSON(ChoiceSyncParameterValue.class, json);
        System.err.println("Createdvalue: " + value);
        return value;
    }
	
	public void setName(String name) {this.name = name;}
	public String getName() {return name;}
	
	@Extension
	public static class DescriptorImpl extends ParameterDescriptor {
		@Override
		public String getDisplayName() {
			return "Enable selection of Build Slave at Runtime";
		}
	}
}