/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zend Technologies
 *******************************************************************************/
package org.eclipse.php.internal.core.language;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.php.core.PHPVersion;
import org.eclipse.php.core.language.ILanguageModelProvider;
import org.eclipse.php.core.project.ProjectOptions;
import org.eclipse.php.internal.core.Logger;
import org.eclipse.php.internal.core.PHPCorePlugin;

/**
 * Default initializer for standard PHP functions/classes
 * 
 * @author michael
 * 
 */
class DefaultLanguageModelProvider implements ILanguageModelProvider {

	private static final String LANGUAGE_LIBRARY_PATH = "$nl$/Resources/language/php"; //$NON-NLS-1$

	@Override
	public IPath getPath(IScriptProject project) {
		try {
			return new Path(getLanguageLibraryPath(project, ProjectOptions.getPHPVersion(project)));
		} catch (Exception e) {
			Logger.logException(e);
			return null;
		}
	}

	@Override
	public String getName() {
		return Messages.DefaultLanguageModelProvider_1;
	}

	private String getLanguageLibraryPath(IScriptProject project, PHPVersion phpVersion) {
		if (phpVersion == PHPVersion.PHP5) {
			return LANGUAGE_LIBRARY_PATH + "5.0"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP5_3) {
			return LANGUAGE_LIBRARY_PATH + "5.3"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP5_4) {
			return LANGUAGE_LIBRARY_PATH + "5.4"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP5_5) {
			return LANGUAGE_LIBRARY_PATH + "5.5"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP5_6) {
			return LANGUAGE_LIBRARY_PATH + "5.6"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP7_0) {
			return LANGUAGE_LIBRARY_PATH + "7.0"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP7_1) {
			return LANGUAGE_LIBRARY_PATH + "7.1"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP7_2) {
			return LANGUAGE_LIBRARY_PATH + "7.2"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP7_3) {
			return LANGUAGE_LIBRARY_PATH + "7.3"; //$NON-NLS-1$
		}
		if (phpVersion == PHPVersion.PHP7_4) {
			return LANGUAGE_LIBRARY_PATH + "7.4"; //$NON-NLS-1$
		}
		return LANGUAGE_LIBRARY_PATH + "7.4"; //$NON-NLS-1$
	}

	@Override
	public Plugin getPlugin() {
		return PHPCorePlugin.getDefault();
	}
}