/*
 * Copyright 2011 the original author or authors.
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
package org.gradle.api.plugins.gae.task

import org.gradle.api.internal.ConventionTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

/**
 * Google App Engine task that downloads SDK to be used.
 *
 * @author Benjamin Muschko
 */
class GaeDownloadSdkTask extends ConventionTask {
    @InputFile File gaeSdkZipFile
    File explodedSdkDirectory
    File gaeSdkRootDir

    @TaskAction
    void start() {
        setExplodedSdkDirectory( new File(getGaeSdkZipFile().parentFile.parent + File.separator + "sdks") )
        setGaeSdkRootDir( new File(getExplodedSdkDirectory().canonicalPath + File.separator +
                getGaeSdkZipFile().name - ".zip") )

        if ( !getGaeSdkRootDir().exists() )
            ant.unzip(src: getGaeSdkZipFile(), dest: getExplodedSdkDirectory())

        System.setProperty(AbstractGaeTask.APPENGINE_SDK_ROOT_SYS_PROP_KEY, getGaeSdkRootDir().canonicalPath)
    }
}
