/*
 * Copyright 2011-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.hadoop.pig;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

/**
 * Holder class for a pig script.
 *
 * @author Costin Leau
 */
public class PigScript {

	private Resource resource;
	private Map<String, String> arguments;

	/**
	 * Constructs a new <code>PigScript</code> instance from the given
	 * resource.
	 *
	 * @param resource script resource.
	 */
	public PigScript(Resource resource) {
		this(resource, (Properties) null);
	}

	/**
	 * Constructs a new <code>PigScript</code> instance. Both the script
	 * content and its parameters are supplied.
	 *
	 * @param resource script content.
	 * @param args script arguments.
	 */
	public PigScript(Resource resource, Properties args) {
		Assert.notNull(resource, "a valid resource is required");
		this.resource = resource;

		if (args != null) {
			arguments = new LinkedHashMap<String, String>();
			for (String key : args.stringPropertyNames()) {
				arguments.put(key, args.getProperty(key));
			}
		}
	}

	/**
	 * Constructs a new <code>PigScript</code> instance.
	 *
	 * @param resource
	 * @param args
	 */
	public PigScript(Resource resource, Map<String, String> args) {
		Assert.notNull(resource, "a valid resource is required");
		this.resource = resource;
		this.arguments = args;
	}

	/**
	 * Returns the script resource.
	 *
	 * @return Returns the resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * Returns the arguments associated with this script.
	 *
	 * @return Returns the arguments for this script.
	 */
	public Map<String, String> getArguments() {
		return arguments;
	}

	@Override
	public String toString() {
		return resource.getDescription();
	}
}