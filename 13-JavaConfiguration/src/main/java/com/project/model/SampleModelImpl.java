package com.project.model;

import org.springframework.stereotype.Component;

@Component
public class SampleModelImpl implements SampleModel {

	@Override
	public void sampleMethod() {
		System.out.println("This is sample method");
	}

}
