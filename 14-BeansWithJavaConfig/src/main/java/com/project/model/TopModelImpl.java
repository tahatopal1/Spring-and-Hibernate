package com.project.model;

public class TopModelImpl implements TopModel {

	BottomModel bottomModel;
	
	public TopModelImpl(BottomModel bottomModel) {
		super();
		this.bottomModel = bottomModel;
	}

	@Override
	public void topModelMethod() {
		bottomModel.bottomModelMethod();
	}

}
