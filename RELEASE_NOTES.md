### Version 0.5.1 (June 19, 2011)

* Ignore `IllegalStateException` when running `gradle -t` and `gaeSdk` configuration is not declared.

### Version 0.5 (June 5, 2011)

* Added convention property `disableUpdateCheck` for disabling the update check.
* Added convention property `debug` for enabling the JVM debugger.
* Added convention property `downloadSdk` for automatically downloading the App Engine SDK to used for running the plugin's tasks.
* Setting the App Engine tools SDK library in the buildscript's classpath is not required anymore. It will be resolved
automatically by using the JAR packages with the App Engine SDK.

### Version 0.4 (April 13, 2011)

* Only stopping the thread when calling `gaeStop` for local development server running in background; not JVM - [Issue 3](https://github.com/bmuschko/gradle-gae-plugin/issues/3).
* When passing in the password the `passIn` property will always be set - [Issue 4](https://github.com/bmuschko/gradle-gae-plugin/issues/4).

### Version 0.3 (April 12, 2011)

* Support for running local development server as daemon - [Issue 1](https://github.com/bmuschko/gradle-gae-plugin/issues#issue/1).
* Allow providing password via gradle.properties or convention property - [Issue 2](https://github.com/bmuschko/gradle-gae-plugin/issues#issue/2).

### Version 0.2 (March 18, 2011)

* Added new task `gaeExplodeWar`.
* Cut dependency to exploded WAR directory for `gaeVersion` task.
* Task `gaeRun` will use exploded WAR directory by default. This behavior can be overriden by the convention property
`warDir`.

### Version 0.1 (March 17, 2011)

* Initial release.