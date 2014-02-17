/**
 *  Copyright 1996-2013 Founder International Co.,Ltd.
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
 * 
 * @author ych
 * @author kenshin
 */
package org.fixflow.editor.language.json.converter;

import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import org.eclipse.bpmn2.BaseElement;
import org.eclipse.bpmn2.Bpmn2Factory;
import org.eclipse.bpmn2.FlowElement;
import org.eclipse.bpmn2.SendTask;


public class SendTaskJsonConverter extends BaseBpmnJsonConverter {

	public static void fillTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap,
		      Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
		    
		    fillJsonTypes(convertersToBpmnMap);
		    fillBpmnTypes(convertersToJsonMap);
	}
	
	public static void fillJsonTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap) {
		    convertersToBpmnMap.put(STENCIL_TASK_SEND, SendTaskJsonConverter.class);
	}
		  
	public static void fillBpmnTypes(Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
		 convertersToJsonMap.put(SendTask.class, SendTaskJsonConverter.class);
	}
	@Override
	protected void convertElementToJson(ObjectNode propertiesNode,
			FlowElement flowElement) {

	}

	@Override
	protected FlowElement convertJsonToElement(JsonNode elementNode,
			JsonNode modelNode, Map<String, JsonNode> shapeMap) {
		SendTask sendTask  = Bpmn2Factory.eINSTANCE.createSendTask();
		return sendTask;
	}

	@Override
	protected String getStencilId(FlowElement flowElement) {
		return STENCIL_TASK_SEND;
	}

}