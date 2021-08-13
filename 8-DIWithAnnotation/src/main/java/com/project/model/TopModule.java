package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopModule {
	
	@Autowired
	public ModelForFieldInjection 		 modelForFieldInjection;
	
	public ModelForConstructorInjection  modelForConstructorInjection;
	public ModelForMethodInjection 	 	 modelForMethodInjection;
	public ModelForSetterInjection 	 	 modelForSetterInjection;
	
	@Autowired
	public TopModule(ModelForConstructorInjection modelForConstructorInjection) {
		super();
		this.modelForConstructorInjection = modelForConstructorInjection;
	}

	@Autowired
	public void awkwardMethodForMethodInjection(ModelForMethodInjection modelForMethodInjection) {
		this.modelForMethodInjection = modelForMethodInjection;
	}

	@Autowired
	public void setModelForSetterInjection(ModelForSetterInjection modelForSetterInjection) {
		this.modelForSetterInjection = modelForSetterInjection;
	}
	
	
	
	
	
	
}
