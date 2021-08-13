package com.project.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleCodeConstraintValidator implements ConstraintValidator<RoleCode, String> {

	private String rolePrefix;

	@Override
	public void initialize(RoleCode roleCode) {
		// TODO Auto-generated method stub
		ConstraintValidator.super.initialize(roleCode);
		rolePrefix = roleCode.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (value != null && value.startsWith(rolePrefix)) ? true : false;
	}

}
