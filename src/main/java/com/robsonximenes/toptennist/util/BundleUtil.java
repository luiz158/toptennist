package com.robsonximenes.toptennist.util;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.util.Beans;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

public class BundleUtil {

	@Inject
	private ResourceBundle bundle;

	private static BundleUtil instance = Beans.getReference(BundleUtil.class);

	public static ResourceBundle getBundle() {
		return instance.bundle;
	}
}
